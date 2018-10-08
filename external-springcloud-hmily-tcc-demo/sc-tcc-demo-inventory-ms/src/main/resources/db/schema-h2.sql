/*Table structure for table `inventory` */

DROP TABLE IF EXISTS `t_inventory`;

CREATE TABLE `t_inventory` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `product_id` VARCHAR(128) NOT NULL COMMENT '商品编号',
  `total_inventory` int(10) NOT NULL COMMENT '总库存',
  `lock_inventory` int(10) NOT NULL COMMENT '锁定库存',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;