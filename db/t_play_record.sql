/*
Navicat MySQL Data Transfer

Source Server         : Jeffery_mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : db_pet

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-03-10 16:38:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_play_record
-- ----------------------------
DROP TABLE IF EXISTS `t_play_record`;
CREATE TABLE `t_play_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `video_id` int(11) DEFAULT NULL COMMENT '视频id',
  `name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `user_id` int(11) DEFAULT NULL COMMENT '记录归属用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='播放记录表';
