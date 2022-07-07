CREATE TABLE `fund` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `fund_code` varchar(10) NOT NULL DEFAULT '' COMMENT '基金code',
  `fund_name` varchar(128) NOT NULL DEFAULT '' COMMENT '基金名称',
  `simple_pinyin` varchar(32) NOT NULL DEFAULT '' COMMENT '基金名称拼音首字母大写',
  `pinyin` varchar(128) NOT NULL DEFAULT '' COMMENT '基金名称全拼',
  `fund_type` varchar(32) NOT NULL DEFAULT '' COMMENT '基金类型',
  `manager` varchar(32) NOT NULL DEFAULT '' COMMENT '基金经理名称',
  `status` varchar(16) NOT NULL DEFAULT '' COMMENT '基金状态',
  `establish_date` date DEFAULT NULL COMMENT '基金成立日期',
  `creator_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建人ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '更新人ID',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;