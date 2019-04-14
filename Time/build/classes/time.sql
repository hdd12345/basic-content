/*  
 * 		简化的time数据库
SQLyog Ultimate v8.32 
MySQL - 5.7.13-log : Database - time
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`time` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `time`;

/*Table structure for table `address` */

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
  `adr_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `u_id` bigint(20) NOT NULL,
  `province` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `detail` varchar(100) DEFAULT NULL,
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`adr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `address` */

insert  into `address`(`adr_id`,`u_id`,`province`,`city`,`detail`,`add_time`) values (1,1,'湖北','武汉','武汉商学院','2018-06-06 19:24:33');

/*Table structure for table `change_log` */

DROP TABLE IF EXISTS `change_log`;

CREATE TABLE `change_log` (
  `cl_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '兑换日志',
  `u_id` bigint(20) NOT NULL,
  `consume` int(11) NOT NULL COMMENT '还是记录一下消费积分，有可能做活动，当时商品积分发生了变化',
  `g_id` bigint(20) NOT NULL,
  `cl_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '兑换时间',
  `adr_id` bigint(20) NOT NULL,
  PRIMARY KEY (`cl_id`),
  KEY `fk` (`u_id`,`g_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `change_log` */

insert  into `change_log`(`cl_id`,`u_id`,`consume`,`g_id`,`cl_time`,`adr_id`) values (1,1,5,1,'2018-06-06 19:23:48',1),(2,1,6,2,'2018-06-07 15:53:38',1),(3,2,50,1,'2018-06-08 13:01:18',1);

/*Table structure for table `goods` */

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `g_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `g_num` varchar(20) NOT NULL COMMENT '商品编号',
  `g_name` varchar(20) NOT NULL COMMENT '商品名',
  `consume` int(11) NOT NULL COMMENT '兑换所需积分',
  `count` int(11) NOT NULL COMMENT '剩余库存',
  `g_logo` varchar(100) DEFAULT NULL COMMENT '图标url',
  `g_type` int(11) NOT NULL,
  PRIMARY KEY (`g_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

/*Data for the table `goods` */

insert  into `goods`(`g_id`,`g_num`,`g_name`,`consume`,`count`,`g_logo`,`g_type`) values (1,'121561612','电电电电电风扇',50,545,'images/f3.jpg',2),(2,'34534535','猪肉铺（咸味）',10,9,'images/f1.jpg',5),(3,'3263653','充电宝',20,11,'images/f2.jpg',6),(4,'121524523','芒果干',8,2544,'images/f4.jpg',5),(5,'354355','猪肉铺（甜味）',10,13,'images/f1.jpg',5),(14,'758788','好好好东西',20,2,'images/',2),(15,'1221211','不知道是啥东西',13,10,'images/f7',4),(16,'758788','好东西',20,2,'images/',2),(19,'3877828','实惠商品',5,5,'images/',3),(21,'22','22',22,0,'images/',1),(22,'32323233','21231',12,0,'images/',1),(23,'2321','3213',23,123,'images/',4),(24,'151231','冰红茶',40,2525,'images/f5.jpg',7),(25,'5872752','为他柠檬茶',100,58727,'images/f6.jpg',7);

/*Table structure for table `goodstype` */

DROP TABLE IF EXISTS `goodstype`;

CREATE TABLE `goodstype` (
  `g_type` int(11) NOT NULL,
  `type_name` varchar(50) NOT NULL,
  `type_parent` int(11) DEFAULT '-1',
  PRIMARY KEY (`g_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goodstype` */

insert  into `goodstype`(`g_type`,`type_name`,`type_parent`) values (1,'食品',-1),(2,'电器',-1),(3,'电扇',2),(4,'饰件',-1),(5,'良品铺子的零食',1),(6,'小小小电器',2),(7,'饮料',1);

/*Table structure for table `manager` */

DROP TABLE IF EXISTS `manager`;

CREATE TABLE `manager` (
  `m_id` int(11) NOT NULL AUTO_INCREMENT,
  `m_name` varchar(20) NOT NULL,
  `m_pwd` varchar(20) DEFAULT NULL,
  `r_type` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`m_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `manager` */

insert  into `manager`(`m_id`,`m_name`,`m_pwd`,`r_type`) values (1,'admin','123',1),(2,'admin222','123456',1);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `r_type` int(11) NOT NULL,
  `r_name` varchar(20) NOT NULL,
  PRIMARY KEY (`r_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`r_type`,`r_name`) values (1,'管理员'),(2,'普通用户');

/*Table structure for table `time_log` */

DROP TABLE IF EXISTS `time_log`;

CREATE TABLE `time_log` (
  `tl_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `u_id` bigint(20) NOT NULL,
  `start` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `expire` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `achieve` int(11) NOT NULL DEFAULT '1' COMMENT '此次是否完成预期，默认完成',
  `failtime` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '没完成预期的话，是什么时候打破的呢。完成了，这个值就等于expire',
  PRIMARY KEY (`tl_id`),
  KEY `fk` (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `time_log` */

insert  into `time_log`(`tl_id`,`u_id`,`start`,`expire`,`achieve`,`failtime`) values (1,1,'2018-05-20 20:03:14','2018-05-20 23:03:14',1,'2018-05-20 23:03:14'),(2,1,'2018-05-25 21:33:40','2018-05-25 23:33:40',1,'2018-05-25 23:33:40'),(3,1,'2018-05-26 15:57:55','2018-05-26 19:57:55',0,'2018-05-26 19:27:55'),(4,2,'2018-05-27 10:57:46','2018-05-27 14:57:46',1,'2018-05-27 14:57:46'),(6,2,'2018-05-28 13:22:56','2018-05-29 13:22:56',1,'2018-05-29 13:22:56');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `u_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `u_name` varchar(20) NOT NULL,
  `u_pwd` varchar(20) NOT NULL,
  `credit` int(11) NOT NULL DEFAULT '0' COMMENT '积分，默认0',
  `duration` bigint(20) DEFAULT '0' COMMENT '总时长（按毫秒记录），默认0',
  `r_type` int(11) NOT NULL DEFAULT '2',
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`u_id`,`u_name`,`u_pwd`,`credit`,`duration`,`r_type`) values (1,'xuyun','1234',4970,654,2),(2,'abc','123',0,345,2),(3,'casc','2455',0,345,2),(4,'huli','123',0,345,2),(5,'shabi','534',0,445,2),(7,'111111','111111',0,33,2),(8,'12321','1211212',0,45,2),(9,'zhangling','123',0,12,2),(10,'何三','123',0,5,2),(11,'梁憨州','123',0,8,2),(12,'不知道是谁','123456',0,23,2),(13,'123','123',0,0,2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
