-- Adminer 4.7.7 MySQL dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

SET NAMES utf8mb4;

DROP TABLE IF EXISTS `t_trade`;
CREATE TABLE `t_trade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `otherUid` int(11) DEFAULT NULL,
  `money` double(12,2) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `comment` varchar(32) DEFAULT NULL,
  `balance` double(12,2) DEFAULT NULL,
  `consumType` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `t_trade` (`id`, `uid`, `otherUid`, `money`, `createTime`, `comment`, `balance`, `consumType`) VALUES
(1,	1,	2,	3.00,	'2019-09-09 07:21:02',	'haha',	2.20,	'支出'),
(2,	1,	1,	2.00,	'2020-09-09 07:21:33',	'dfdf',	23.00,	'支出'),
(3,	2,	1,	-100.00,	'2020-08-09 07:24:52',	'haha',	23.00,	'收入'),
(4,	3,	1,	-5.00,	'2020-05-09 07:25:14',	'haha',	23.00,	'收入'),
(5,	1,	NULL,	-2.00,	'2020-09-14 18:54:27',	NULL,	10.00,	NULL),
(6,	2,	NULL,	2.00,	NULL,	NULL,	4.00,	NULL),
(7,	1,	NULL,	-5.00,	'2020-09-14 19:46:43',	'转出',	5.00,	NULL),
(8,	2,	NULL,	-5.00,	'2020-09-14 19:46:43',	'转入',	9.00,	NULL),
(9,	1,	233,	-2.00,	'2020-09-14 19:50:15',	'转出',	3.00,	'支出'),
(10,	2,	1,	-2.00,	'2020-09-14 19:50:15',	'转入',	11.00,	'收入'),
(11,	1,	233,	-1.00,	'2020-09-15 08:52:22',	'转出',	2.00,	'支出'),
(12,	2,	1,	-1.00,	'2020-09-15 08:52:22',	'转入',	12.00,	'收入'),
(13,	1,	233,	-1.00,	'2020-09-15 09:01:27',	'转出',	1.00,	'支出'),
(14,	2,	1,	1.00,	'2020-09-15 09:01:27',	'转入',	13.00,	'收入'),
(15,	1,	233,	-1.00,	'2020-09-15 09:08:33',	'转出',	0.00,	'支出'),
(16,	2,	1,	1.00,	'2020-09-15 09:08:33',	'转入',	14.00,	'收入'),
(17,	2,	1,	-5.00,	'2020-09-15 09:18:23',	'转出',	9.00,	'支出'),
(18,	1,	2,	5.00,	'2020-09-15 09:18:23',	'转入',	5.00,	'收入'),
(19,	1,	2,	-1.00,	'2020-09-15 09:23:32',	'转出',	4.00,	'支出'),
(20,	2,	1,	1.00,	'2020-09-15 09:23:32',	'转入',	10.00,	'收入'),
(21,	1,	2,	1.00,	'2020-09-15 09:27:27',	'转出',	3.00,	'支出'),
(22,	2,	1,	-1.00,	'2020-09-15 09:27:27',	'转入',	11.00,	'收入'),
(23,	1,	2,	1.00,	'2020-09-16 07:20:16',	'转出',	2.00,	'支出'),
(24,	2,	1,	-1.00,	'2020-09-16 07:20:16',	'转入',	12.00,	'收入'),
(25,	1,	2,	1002.00,	'2020-09-16 08:39:18',	'转出',	1998998.00,	'支出'),
(26,	2,	1,	-1002.00,	'2020-09-16 08:39:18',	'转入',	1014.00,	'收入');

DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bankCode` varchar(32) DEFAULT NULL,
  `password` varchar(220) DEFAULT NULL,
  `balance` double(12,2) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `imagePath` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `t_user` (`id`, `bankCode`, `password`, `balance`, `status`, `imagePath`) VALUES
(1,	'111111',	'7220b4d9e0aba3fa4059af76ff5a289d',	1998998.00,	1,	'/upload/5b309899e74dc.jpg'),
(2,	'233',	'233',	1014.00,	2,	''),
(3,	'1111',	'1111',	1111.00,	1,	''),
(4,	'123456',	'9f3b2af6892110ca0dcce6064b2f8fcb',	NULL,	NULL,	NULL),
(5,	NULL,	'9f3b2af6892110ca0dcce6064b2f8fcb',	NULL,	NULL,	NULL),
(6,	NULL,	'9f3b2af6892110ca0dcce6064b2f8fcb',	NULL,	NULL,	NULL),
(7,	NULL,	'9f3b2af6892110ca0dcce6064b2f8fcb',	NULL,	NULL,	NULL),
(8,	NULL,	'9f3b2af6892110ca0dcce6064b2f8fcb',	NULL,	NULL,	NULL),
(9,	NULL,	'9f3b2af6892110ca0dcce6064b2f8fcb',	NULL,	NULL,	NULL),
(10,	'12345679',	'7220b4d9e0aba3fa4059af76ff5a289d',	NULL,	NULL,	NULL),
(11,	'123456789',	'7220b4d9e0aba3fa4059af76ff5a289d',	NULL,	NULL,	NULL);

-- 2020-10-06 13:12:30

