DROP TABLE IF EXISTS `t_order`;

CREATE TABLE `t_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `number` varchar(20) NOT NULL COMMENT '订单编号',
  `status` tinyint(4) NOT NULL COMMENT '订单状态',
  `user_id` varchar(128) NOT NULL COMMENT '账号',
  `product_id` varchar(128) NOT NULL COMMENT '商品编号',
  `total_amount` decimal(10,0) NOT NULL COMMENT '订单总价',
  `quantity` int(4) NOT NULL COMMENT '商品总数',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;