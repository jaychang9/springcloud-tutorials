/*Table structure for table `account` */
DROP TABLE IF EXISTS `t_account`;

CREATE TABLE `t_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` varchar(128) NOT NULL COMMENT '账号',
  `balance` decimal(10,2) NOT NULL COMMENT '用户余额',
  `freeze_amount` decimal(10,2) NOT NULL COMMENT '冻结金额，扣款暂存余额',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;