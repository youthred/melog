/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 50525
 Source Host           : localhost:3306
 Source Schema         : melog

 Target Server Type    : MySQL
 Target Server Version : 50525
 File Encoding         : 65001

 Date: 05/02/2020 12:35:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `id` bigint(20) NOT NULL COMMENT '时间戳',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `content_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文章存储相对路径，/resources/articles/*',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `like_count` bigint(20) DEFAULT NULL,
  `views` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES (1579419763333, 'asd', 'admin@add1s.net', 'D:\\code_resource\\workspace_all\\idea\\melog\\target\\classes\\articles\\1579419763333.txt', '2020-01-19 15:42:43', NULL, 0, 1);
INSERT INTO `article` VALUES (1579420460463, 'asdaaa', 'admin@add1s.net', 'D:\\code_resource\\workspace_all\\idea\\melog\\target\\classes\\articles\\1579420460463.txt', '2020-01-19 15:54:20', '2020-01-19 15:58:30', 0, 2);
INSERT INTO `article` VALUES (1579422131819, '123', 'admin@add1s.net', 'D:\\code_resource\\workspace_all\\idea\\melog\\target\\classes\\articles\\1579422131819.txt', '2020-01-19 16:22:11', NULL, 58, 84);
INSERT INTO `article` VALUES (1579426334029, 'asdas', 'admin@add1s.net', 'D:\\code_resource\\workspace_all\\idea\\melog\\target\\classes\\articles\\1579426334029.txt', '2020-01-19 17:32:14', '2020-01-19 17:44:14', 6, 181);
INSERT INTO `article` VALUES (1579434324778, '123', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579434324778.txt', '2020-01-19 19:45:24', NULL, 0, 2);
INSERT INTO `article` VALUES (1579506518335, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506518335.txt', '2020-01-20 15:48:38', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506519061, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506519061.txt', '2020-01-20 15:48:39', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506519525, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506519525.txt', '2020-01-20 15:48:39', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506519706, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506519706.txt', '2020-01-20 15:48:39', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506519862, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506519862.txt', '2020-01-20 15:48:39', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506520046, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506520046.txt', '2020-01-20 15:48:40', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506520219, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506520219.txt', '2020-01-20 15:48:40', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506520372, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506520372.txt', '2020-01-20 15:48:40', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506520551, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506520551.txt', '2020-01-20 15:48:40', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506520722, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506520722.txt', '2020-01-20 15:48:40', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506520874, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506520874.txt', '2020-01-20 15:48:40', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506521045, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506521045.txt', '2020-01-20 15:48:41', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506521226, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506521226.txt', '2020-01-20 15:48:41', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506521410, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506521410.txt', '2020-01-20 15:48:41', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506521591, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506521591.txt', '2020-01-20 15:48:41', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506522037, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506522037.txt', '2020-01-20 15:48:42', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506523024, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506523024.txt', '2020-01-20 15:48:43', NULL, 0, 1);
INSERT INTO `article` VALUES (1579506523204, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506523204.txt', '2020-01-20 15:48:43', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506523380, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506523380.txt', '2020-01-20 15:48:43', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506523556, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506523556.txt', '2020-01-20 15:48:43', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506523734, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506523734.txt', '2020-01-20 15:48:43', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506523907, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506523907.txt', '2020-01-20 15:48:43', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506524083, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506524083.txt', '2020-01-20 15:48:44', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506524251, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506524251.txt', '2020-01-20 15:48:44', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506524418, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506524418.txt', '2020-01-20 15:48:44', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506524582, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506524582.txt', '2020-01-20 15:48:44', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506524754, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506524754.txt', '2020-01-20 15:48:44', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506524918, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506524918.txt', '2020-01-20 15:48:44', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506525269, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506525269.txt', '2020-01-20 15:48:45', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506525782, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506525782.txt', '2020-01-20 15:48:45', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506526345, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506526345.txt', '2020-01-20 15:48:46', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506526528, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506526528.txt', '2020-01-20 15:48:46', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506526699, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506526699.txt', '2020-01-20 15:48:46', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506526867, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506526867.txt', '2020-01-20 15:48:46', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506527035, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506527035.txt', '2020-01-20 15:48:47', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506527189, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506527189.txt', '2020-01-20 15:48:47', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506527352, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506527352.txt', '2020-01-20 15:48:47', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506527520, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506527520.txt', '2020-01-20 15:48:47', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506527686, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506527686.txt', '2020-01-20 15:48:47', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506527862, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506527862.txt', '2020-01-20 15:48:47', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506528039, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506528039.txt', '2020-01-20 15:48:48', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506528398, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506528398.txt', '2020-01-20 15:48:48', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506528553, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506528553.txt', '2020-01-20 15:48:48', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506529007, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506529007.txt', '2020-01-20 15:48:49', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506529756, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506529756.txt', '2020-01-20 15:48:49', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506529928, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506529928.txt', '2020-01-20 15:48:49', NULL, 0, 1);
INSERT INTO `article` VALUES (1579506530108, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506530108.txt', '2020-01-20 15:48:50', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506530275, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506530275.txt', '2020-01-20 15:48:50', NULL, 0, 0);
INSERT INTO `article` VALUES (1579506530440, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506530440.txt', '2020-01-20 15:48:50', NULL, 11, 10);
INSERT INTO `article` VALUES (1579506530588, '1', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579506530588.txt', '2020-01-20 15:48:50', NULL, 0, 2);
INSERT INTO `article` VALUES (1579507564078, '徽章样式的使用、数字提示扩展样式以及小规', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579507564078.txt', '2020-01-20 16:06:04', NULL, 3, 10);
INSERT INTO `article` VALUES (1579691001882, 'new 中文', 'admin@add1s.net', 'D:\\BaiduNetdiskDownload\\_temp\\articles\\1579691001882.txt', '2020-01-22 19:03:21', '2020-01-22 19:35:30', 3, 3);

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES (1, '/admin/*', 'admin:*', '\r\n管理员所有权限', 6);
INSERT INTO `sys_permission` VALUES (2, '/common/*', 'common:*', '\r\n普通用户所有权限', 7);
INSERT INTO `sys_permission` VALUES (3, '/article/save', 'article:save', '添加文章', 5);
INSERT INTO `sys_permission` VALUES (4, '/article/update', 'article:update', '跳转到更新文章页面', 5);
INSERT INTO `sys_permission` VALUES (5, '/article', 'article:sup', '文章父级', 0);
INSERT INTO `sys_permission` VALUES (6, '/admin', 'admin:sup', '管理员父级', 0);
INSERT INTO `sys_permission` VALUES (7, '/common', 'common:sup', '普通用户父级', 0);
INSERT INTO `sys_permission` VALUES (8, '/article/delete/*', 'article:delete:*', '删除文章', 5);
INSERT INTO `sys_permission` VALUES (9, '/article/update/*', 'article:update:*', '更新文章', 5);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'ADMIN');
INSERT INTO `sys_role` VALUES (2, 'USER');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission`  (
  `role_id` bigint(20) DEFAULT NULL,
  `permission_id` bigint(20) DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES (1, 1);
INSERT INTO `sys_role_permission` VALUES (2, 2);
INSERT INTO `sys_role_permission` VALUES (1, 3);
INSERT INTO `sys_role_permission` VALUES (1, 4);
INSERT INTO `sys_role_permission` VALUES (1, 8);
INSERT INTO `sys_role_permission` VALUES (1, 9);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin@add1s.net', 'e10adc3949ba59abbe56e057f20f883e', 'admin');
INSERT INTO `sys_user` VALUES (2, 'user@add1s.net', 'e10adc3949ba59abbe56e057f20f883e', 'user');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `user_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1);
INSERT INTO `sys_user_role` VALUES (1, 2);
INSERT INTO `sys_user_role` VALUES (2, 2);

SET FOREIGN_KEY_CHECKS = 1;
