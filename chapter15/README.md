# 生产者
## 1.定义 Source
```java
public interface OrderSource {

    String OUTPUT_ORDER = "outputOrder";

    @Output(OrderSource.OUTPUT_ORDER)
    MessageChannel outputOrder();
}
```

## 2.启用Source
```java
@EnableBinding({Source.class,OrderSource.class})
public class BindingConfig {
}
```

## 3.配置stream
> 以上如果启用了某个Binding会读取application.yml spring.cloud.stream.bindings.outputOrder配置
这里就是destination(交换机名称)，contentType
```yaml
server:
  port: 8901
spring:
  cloud:
    stream:
      bindings:
        outputOrder:
          destination: mqTestDefault
          contentType: application/json
          binder: defaultRabbit
      binders:
        defaultRabbit:
          type: rabbit
          environment:
            spring:
              rabbitmq:
                host: 171.188.0.165
                port: 5672
                username: guest
                password: guest
                virtual-host: dev
      rabbit:
        bindings:
          outputOrder:
            producer:
              routing-key-expression: '''orderAdd'''
```

## 4.发送消息
```java
@Component
public class OrderMessageSender{
    @Autowired
    private OrderSource orderSource;

//  @Autowired
//  @Qualifier(OrderSource.OUTPUT_ORDER)
//  private MessageChannel orderMessageChannel;

    @GetMapping("/create")
    public String createOrder(){
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setPrice(BigDecimal.valueOf(new Random().nextDouble()));

        orderDTO.setCreateDate(new Date());

        orderDTO.setQuantity(new Random().nextInt(10));

        orderDTO.setSn(String.valueOf(System.currentTimeMillis()));

        orderDTO.setProductName("商品名称"+System.currentTimeMillis());

        boolean send = orderSource.outputOrder().send(MessageBuilder.withPayload(orderDTO).build());

        String result  = send ? "发送成功":"发送失败";
        System.out.println(result);
        return result;
    }
}    
```

# 消费者

## 1.定义Sink
```java
public interface OrderSink {
    String INPUT_ORDER = "inputOrder";

    @Input(INPUT_ORDER)
    SubscribableChannel inputOrder();
}
```

## 2.启用Sink,编写消息监听器
```java
@EnableBinding(OrderSink.class)
public class OrderMessageListener {
	@StreamListener(OrderSink.INPUT_ORDER)
	public void inputOrder(OrderDTO orderDTO) {
		System.out.println("收到新建完订单的消息: " + orderDTO);
	}
}
```
## 3.配置stream

```yaml
spring:
  cloud:
    stream:
      bindings:
        inputOrder: # 自定义的
          destination: mqTestDefault # 就是rabbitmq的交换机
          group: inputOrderConsumers # 就是rabbitmq的队列名
          binder: defaultRabbit
      binders:
        defaultRabbit:
          type: rabbit
          environment:
            spring:
              rabbitmq:
                host: 171.188.0.165
                port: 5672
                username: guest
                password: guest
                virtual-host: dev
      rabbit:
        bindings:
          inputOrder:
            consumer:
              bindingRoutingKey: orderAdd # 建议还是用这种好了
```

