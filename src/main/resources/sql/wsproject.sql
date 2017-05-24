CREATE DATABASE  IF NOT EXISTS `ws_project` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ws_project`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: ws_project
-- ------------------------------------------------------
-- Server version	5.7.12-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `enterprise`
--

DROP TABLE IF EXISTS `enterprise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enterprise` (
  `id` varchar(50) NOT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '执法检查（或复查）企业（场所）名称',
  `address` varchar(255) DEFAULT NULL COMMENT '企业地址',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enterprise`
--

LOCK TABLES `enterprise` WRITE;
/*!40000 ALTER TABLE `enterprise` DISABLE KEYS */;
INSERT INTO `enterprise` VALUES ('5e9ea738-6dc7-4223-bc5f-7d15fa51a33e','宝明发包装制品有限公司','合水口社区第四工业区1期1栋3,4层','2017-05-23 21:00:49');
/*!40000 ALTER TABLE `enterprise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rectification_link`
--

DROP TABLE IF EXISTS `rectification_link`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rectification_link` (
  `id` varchar(50) NOT NULL,
  `rectification_main_id` varchar(50) NOT NULL COMMENT '检查记录表ID',
  `situation_id` varchar(50) DEFAULT NULL COMMENT 'situation表对应ID，违法行为或隐患情况',
  `method` varchar(255) DEFAULT NULL COMMENT '整改落实情况或处置措施',
  `part` varchar(255) DEFAULT NULL COMMENT '违法行为或隐患所在部位',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='整改表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rectification_link`
--

LOCK TABLES `rectification_link` WRITE;
/*!40000 ALTER TABLE `rectification_link` DISABLE KEYS */;
/*!40000 ALTER TABLE `rectification_link` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rectification_main`
--

DROP TABLE IF EXISTS `rectification_main`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rectification_main` (
  `id` varchar(50) NOT NULL,
  `enterprise_id` varchar(50) NOT NULL COMMENT '企业ID',
  `check_date` varchar(50) DEFAULT NULL COMMENT '执法检查日期',
  `check_person` varchar(45) DEFAULT NULL COMMENT '执法检查人员',
  `duty_unit` varchar(255) DEFAULT NULL COMMENT '责任单位',
  `duty_person` varchar(255) DEFAULT NULL COMMENT '责任人',
  `finish_date` varchar(50) DEFAULT NULL COMMENT '整改完成期限',
  `reviewed` int(1) DEFAULT '0' COMMENT '是否复查',
  `recorded` int(1) DEFAULT '0' COMMENT '是否立案',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='检查记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rectification_main`
--

LOCK TABLES `rectification_main` WRITE;
/*!40000 ALTER TABLE `rectification_main` DISABLE KEYS */;
INSERT INTO `rectification_main` VALUES ('297b1196-03d8-4810-8555-d8efe5e709f5','5e9ea738-6dc7-4223-bc5f-7d15fa51a33e','2017-05-23',NULL,NULL,NULL,NULL,1,0,NULL);
/*!40000 ALTER TABLE `rectification_main` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `situation`
--

DROP TABLE IF EXISTS `situation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `situation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '违法行为或隐患情况',
  `sort` int(11) NOT NULL COMMENT '顺序，由低到高',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='违法行为或隐患情况维护表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `situation`
--

LOCK TABLES `situation` WRITE;
/*!40000 ALTER TABLE `situation` DISABLE KEYS */;
INSERT INTO `situation` VALUES (1,'烤线没有提供检测报告',1),(2,'未提供劳保用品发放记录签收表',2),(3,'未建立事故隐患排查治理记录档案',3),(4,'未提供2017年安全资金投入计划',4),(5,'未建立安全生产责任制',5),(6,'未健全应急演练制度',6),(7,'未提供员工三级教育培训档案',7);
/*!40000 ALTER TABLE `situation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-24 23:30:02
