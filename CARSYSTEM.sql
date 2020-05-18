
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `carmessage`
-- ----------------------------
DROP TABLE IF EXISTS `carmessage`;
CREATE TABLE `carmessage` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `carName` varchar(100) NOT NULL,
  `carType` varchar(100) NOT NULL,
  `price` varchar(100) NOT NULL,
  `carSeries` varchar(100) NOT NULL,
  `carNum` int(100) NOT NULL,
`purchaseNum` int(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of carmessage
-- ----------------------------
INSERT INTO `carmessage` VALUES ('2', '奥迪', '中型车', '28.5-70.0万', 'A级','200','10');
INSERT INTO `carmessage` VALUES ('3', '宝马', 'SUV', '30.8-56.3万', 'X1','200','210');
INSERT INTO `carmessage` VALUES ('7', '奔驰', '中型车', '28.5-70.0万', 'C级','200','10');
INSERT INTO `carmessage` VALUES ('11', '宾利', '轿车', '128.5-170.0万', '高级','200','10');
INSERT INTO `carmessage` VALUES ('12', '奥迪', '轿车', '28.5-70.0万', 'A级','200','10');


