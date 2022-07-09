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

CREATE TABLE `fund_component` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `fund_code` varchar(16) NOT NULL DEFAULT '' COMMENT '基金code',
  `component_code` varchar(16) NOT NULL DEFAULT '' COMMENT '持仓股票/债券code',
  `component_name` varchar(128) NOT NULL DEFAULT '' COMMENT '持仓股票/债券code',
  `component_type` varchar(16) NOT NULL DEFAULT '' COMMENT 'stock=股票,bond=债券',
  `percent` decimal(4,4) NOT NULL DEFAULT '0.0000' COMMENT '所占比重',
  `publish_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '持仓公布时间',
  `day_raise` decimal(8,4) NOT NULL,
  `raise_update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '日增长幅度更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `fund_performance` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `fund_code` varchar(16) NOT NULL DEFAULT '' COMMENT '基金编码',
  `fund_date` date DEFAULT NULL COMMENT '日期',
  `unit_value` decimal(8,4) NOT NULL DEFAULT '0.0000' COMMENT '单位净值',
  `tatal_unit_value` decimal(8,4) NOT NULL DEFAULT '0.0000' COMMENT '累计单位净值',
  `rese_percent` decimal(4,4) NOT NULL DEFAULT '0.0000' COMMENT '相较于昨天增长幅度',
  `estimate_unit_value` decimal(8,4) NOT NULL DEFAULT '0.0000' COMMENT '估算净值',
  `estimate_rise_percent` decimal(4,4) NOT NULL DEFAULT '0.0000' COMMENT '估算增幅',
  `estimate_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '估算时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `fund_component` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `fund_code` varchar(16) NOT NULL DEFAULT '' COMMENT '基金code',
  `component_code` varchar(16) NOT NULL DEFAULT '' COMMENT '持仓股票/债券code',
  `component_name` varchar(128) NOT NULL DEFAULT '' COMMENT '持仓股票/债券名称',
  `component_type` varchar(16) NOT NULL DEFAULT '' COMMENT 'stock=股票,bond=债券',
  `percent` decimal(4,4) NOT NULL DEFAULT '0.0000' COMMENT '所占比重',
  `publish_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '持仓公布时间',
  `day_raise` decimal(8,4) NOT NULL,
  `raise_update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '日增长幅度更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `user_subscribe_fund` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户ID',
  `fund_code` varchar(16) NOT NULL DEFAULT '' COMMENT '基金code',
  `subscribe_status` varchar(16) NOT NULL DEFAULT '' COMMENT '订阅状态',
  `subscribe_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订阅时间',
  `cancel_subscribe_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '取消订阅时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;