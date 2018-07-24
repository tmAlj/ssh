/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : jpa

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2018-07-24 14:53:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `claid` int(11) NOT NULL AUTO_INCREMENT COMMENT '班级ID',
  `claname` varchar(255) DEFAULT NULL COMMENT '班级名称',
  PRIMARY KEY (`claid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('1', '一班');
INSERT INTO `class` VALUES ('2', '二班');
INSERT INTO `class` VALUES ('3', '三班');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `couid` int(11) NOT NULL AUTO_INCREMENT COMMENT '课程ID',
  `couname` varchar(255) DEFAULT NULL COMMENT '课程名称',
  PRIMARY KEY (`couid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '语文');
INSERT INTO `course` VALUES ('2', '数学');
INSERT INTO `course` VALUES ('3', '英语');

-- ----------------------------
-- Table structure for leader
-- ----------------------------
DROP TABLE IF EXISTS `leader`;
CREATE TABLE `leader` (
  `leaid` int(11) NOT NULL AUTO_INCREMENT COMMENT '班主任id',
  `leaname` varchar(255) DEFAULT NULL COMMENT '班主任名称',
  `leasex` varchar(255) DEFAULT NULL COMMENT '班主任姓名',
  `claid` int(11) DEFAULT NULL COMMENT '班级ID',
  `leader` int(11) DEFAULT NULL,
  PRIMARY KEY (`leaid`),
  KEY `fk_leader_claid` (`claid`),
  KEY `FK29xwf5o1v48ub9f2lwornfis7` (`leader`),
  CONSTRAINT `FK29xwf5o1v48ub9f2lwornfis7` FOREIGN KEY (`leader`) REFERENCES `class` (`claid`),
  CONSTRAINT `fk_leader_claid` FOREIGN KEY (`claid`) REFERENCES `class` (`claid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of leader
-- ----------------------------
INSERT INTO `leader` VALUES ('1', '小王', '1', '1', null);
INSERT INTO `leader` VALUES ('2', '小李', '1', '2', null);
INSERT INTO `leader` VALUES ('3', '小陈', '0', '3', null);

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `stuid` int(11) NOT NULL COMMENT '学生ID',
  `couid` int(11) DEFAULT NULL COMMENT '课程ID',
  `scores` double DEFAULT NULL COMMENT '分数',
  `scoid` int(11) NOT NULL AUTO_INCREMENT COMMENT '成绩ID',
  `score` int(11) DEFAULT NULL,
  PRIMARY KEY (`scoid`),
  KEY `fk_scored_couid` (`couid`),
  KEY `fk_score_stuid` (`stuid`),
  KEY `FKmwt54icvmclrk7puob1sn77bc` (`score`),
  CONSTRAINT `FKmwt54icvmclrk7puob1sn77bc` FOREIGN KEY (`score`) REFERENCES `course` (`couid`),
  CONSTRAINT `fk_score_stuid` FOREIGN KEY (`stuid`) REFERENCES `student` (`stuid`),
  CONSTRAINT `fk_scored_couid` FOREIGN KEY (`couid`) REFERENCES `course` (`couid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('1', '1', '76', '1', null);
INSERT INTO `score` VALUES ('1', '2', '87', '2', null);
INSERT INTO `score` VALUES ('1', '3', '66', '3', null);
INSERT INTO `score` VALUES ('2', '1', '99', '4', null);
INSERT INTO `score` VALUES ('2', '2', '88', '5', null);
INSERT INTO `score` VALUES ('2', '3', '65', '6', null);
INSERT INTO `score` VALUES ('3', '1', '75', '7', null);
INSERT INTO `score` VALUES ('3', '2', '66', '8', null);
INSERT INTO `score` VALUES ('3', '3', '70', '9', null);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `stuid` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生ID',
  `stuname` varchar(255) DEFAULT NULL COMMENT '姓名',
  `stuage` int(11) DEFAULT NULL COMMENT '年龄',
  `stusex` int(11) DEFAULT NULL COMMENT '性别',
  `claid` int(11) DEFAULT NULL COMMENT '班级ID',
  `student` int(11) DEFAULT NULL,
  PRIMARY KEY (`stuid`),
  KEY `FKrn5igp0n02hu6fi4hkt71jiry` (`claid`),
  KEY `FK4ukhuxy1ohnvm8bykvugeu93q` (`student`),
  CONSTRAINT `FK4ukhuxy1ohnvm8bykvugeu93q` FOREIGN KEY (`student`) REFERENCES `class` (`claid`),
  CONSTRAINT `FKrn5igp0n02hu6fi4hkt71jiry` FOREIGN KEY (`claid`) REFERENCES `class` (`claid`),
  CONSTRAINT `fk_student_claid` FOREIGN KEY (`claid`) REFERENCES `class` (`claid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '张三', '12', '1', '1', null);
INSERT INTO `student` VALUES ('2', '李四', '15', '1', '2', null);
INSERT INTO `student` VALUES ('3', '王五', '12', '0', '3', null);
INSERT INTO `student` VALUES ('4', '狗蛋', '11', '0', '1', null);

-- ----------------------------
-- Table structure for teach
-- ----------------------------
DROP TABLE IF EXISTS `teach`;
CREATE TABLE `teach` (
  `couid` int(11) DEFAULT NULL COMMENT '课程ID',
  `teaid` int(11) NOT NULL COMMENT '教师ID',
  `teacid` int(11) NOT NULL AUTO_INCREMENT COMMENT '授课主键',
  `stuid` int(11) NOT NULL,
  PRIMARY KEY (`teacid`),
  KEY `fk_teach_couid` (`couid`),
  KEY `FKiqm2xb4elmdex24goughlyctl` (`teaid`),
  CONSTRAINT `FKiqm2xb4elmdex24goughlyctl` FOREIGN KEY (`teaid`) REFERENCES `teacher` (`teaid`),
  CONSTRAINT `fk_teach_couid` FOREIGN KEY (`couid`) REFERENCES `course` (`couid`),
  CONSTRAINT `fk_teach_teaid` FOREIGN KEY (`teaid`) REFERENCES `teacher` (`teaid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teach
-- ----------------------------
INSERT INTO `teach` VALUES ('1', '1', '1', '0');
INSERT INTO `teach` VALUES ('2', '2', '2', '0');
INSERT INTO `teach` VALUES ('3', '3', '3', '0');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teaid` int(11) NOT NULL AUTO_INCREMENT COMMENT '教师ID',
  `teaname` varchar(255) DEFAULT NULL COMMENT '教师名称',
  `teasex` int(11) DEFAULT NULL COMMENT '教师性别',
  PRIMARY KEY (`teaid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '谢逊', '1');
INSERT INTO `teacher` VALUES ('2', '周芷若', '0');
INSERT INTO `teacher` VALUES ('3', '赵敏', '0');
