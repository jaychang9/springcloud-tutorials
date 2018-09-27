# 高可用Eureka注册中心
生产环境一个eureka服务实例肯定不行

本案例方案是通过3个eureka结点，每个结点注册到其他两个结点，实现高可用。
当然2个eureka结点，也是OK的


## hosts修改
```shelll
127.0.0.1 peer1
127.0.0.1 peer2
127.0.0.1 peer3
```

## 结点配置

### 结点1
```yaml
spring:
  profiles: peer1
  application:
    name: registry-server
server:
  port: 8761
eureka:
  instance:
    hostname: peer1
  client:
    register-with-eureka: false
    fetch-registry: false
    service-url:
      defaultZone: http://peer2:8762/eureka/,http://peer3:8763/eureka/
  server:
    enable-self-preservation: false
```
### 结点2
```yaml
spring:
  profiles: peer2
  application:
    name: registry-server
server:
  port: 8762
eureka:
  instance:
    hostname: peer2
  client:
    register-with-eureka: false
    fetch-registry: false
    service-url:
      defaultZone: http://peer1:8761/eureka/,http://peer3:8763/eureka/
  server:
    enable-self-preservation: false
```
### 结点3
```yaml
spring:
  profiles: peer3
  application:
    name: registry-server
server:
  port: 8763
eureka:
  instance:
    hostname: peer3
  client:
    register-with-eureka: false
    fetch-registry: false
    service-url:
      defaultZone: http://peer1:8761/eureka/,http://peer2:8762/eureka/
  server:
    enable-self-preservation: false
```