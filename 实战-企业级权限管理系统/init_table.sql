-- ----------------------------
--  Table structure for `sys_acl`
-- ----------------------------
DROP TABLE
IF
	EXISTS `sys_acl`;
CREATE TABLE `sys_acl` (
	`id` INT ( 11 ) NOT NULL AUTO_INCREMENT COMMENT '权限id',
	`code` VARCHAR ( 20 ) NOT NULL DEFAULT '' COMMENT '权限码',
	`name` VARCHAR ( 20 ) NOT NULL DEFAULT '' COMMENT '权限名称',
	`acl_module_id` INT ( 11 ) NOT NULL DEFAULT '0' COMMENT '权限所在的权限模块id',
	`url` VARCHAR ( 100 ) NOT NULL DEFAULT '' COMMENT '请求的url, 可以填正则表达式',
	`type` INT ( 11 ) NOT NULL DEFAULT '3' COMMENT '类型，1：菜单，2：按钮，3：其他',
	`status` INT ( 11 ) NOT NULL DEFAULT '1' COMMENT '状态，1：正常，0：冻结',
	`seq` INT ( 11 ) NOT NULL DEFAULT '0' COMMENT '权限在当前模块下的顺序，由小到大',
	`remark` VARCHAR ( 200 ) DEFAULT '' COMMENT '备注',
	`operator` VARCHAR ( 20 ) NOT NULL DEFAULT '' COMMENT '操作者',
	`operate_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
	`operate_ip` VARCHAR ( 20 ) NOT NULL DEFAULT '' COMMENT '最后一个更新者的ip地址',
	PRIMARY KEY ( `id` ) 
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4;-- ----------------------------
--  Records of `sys_acl`
-- ----------------------------
-- ----------------------------
--  Table structure for `sys_acl_module`
-- ----------------------------
DROP TABLE
IF
	EXISTS `sys_acl_module`;
CREATE TABLE `sys_acl_module` (
	`id` INT ( 11 ) NOT NULL AUTO_INCREMENT COMMENT '权限模块id',
	`name` VARCHAR ( 20 ) NOT NULL DEFAULT '' COMMENT '权限模块名称',
	`parent_id` INT ( 11 ) NOT NULL DEFAULT '0' COMMENT '上级权限模块id',
	`level` VARCHAR ( 200 ) NOT NULL DEFAULT '' COMMENT '权限模块层级',
	`seq` INT ( 11 ) NOT NULL DEFAULT '0' COMMENT '权限模块在当前层级下的顺序，由小到大',
	`status` INT ( 11 ) NOT NULL DEFAULT '1' COMMENT '状态，1：正常，0：冻结',
	`remark` VARCHAR ( 200 ) DEFAULT '' COMMENT '备注',
	`operator` VARCHAR ( 20 ) NOT NULL DEFAULT '' COMMENT '操作者',
	`operate_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次操作时间',
	`operate_ip` VARCHAR ( 20 ) NOT NULL DEFAULT '' COMMENT '最后一次更新操作者的ip地址',
	PRIMARY KEY ( `id` ) 
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 ROW_FORMAT = DYNAMIC;-- ----------------------------
--  Records of `sys_acl_module`
-- ----------------------------
-- ----------------------------
--  Table structure for `sys_dept`
-- ----------------------------
DROP TABLE
IF
	EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
	`id` INT ( 11 ) NOT NULL AUTO_INCREMENT COMMENT '部门id',
	`name` VARCHAR ( 20 ) NOT NULL DEFAULT '' COMMENT '部门名称',
	`parent_id` INT ( 11 ) NOT NULL DEFAULT '0' COMMENT '上级部门id',
	`level` VARCHAR ( 200 ) NOT NULL DEFAULT '' COMMENT '部门层级',
	`seq` INT ( 11 ) NOT NULL DEFAULT '0' COMMENT '部门在当前层级下的顺序，由小到大',
	`remark` VARCHAR ( 200 ) DEFAULT '' COMMENT '备注',
	`operator` VARCHAR ( 20 ) NOT NULL DEFAULT '' COMMENT '操作者',
	`operate_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次操作时间',
	`operate_ip` VARCHAR ( 20 ) NOT NULL DEFAULT '' COMMENT '最后一次更新操作者的ip地址',
	PRIMARY KEY ( `id` ) 
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4;-- ----------------------------
--  Records of `sys_dept`
-- ----------------------------
-- ----------------------------
--  Table structure for `sys_log`
-- ----------------------------
DROP TABLE
IF
	EXISTS `sys_log`;
CREATE TABLE `sys_log` (
	`id` INT ( 11 ) NOT NULL AUTO_INCREMENT,
	`type` INT ( 11 ) NOT NULL DEFAULT '0' COMMENT '权限更新的类型，1：部门，2：用户，3：权限模块，4：权限，5：角色，6：角色用户关系，7：角色权限关系',
	`target_id` INT ( 11 ) NOT NULL COMMENT '基于type后指定的对象id，比如用户、权限、角色等表的主键',
	`old_value` text COMMENT '旧值',
	`new_value` text COMMENT '新值',
	`operator` VARCHAR ( 20 ) NOT NULL DEFAULT '' COMMENT '操作者',
	`operate_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新的时间',
	`operate_ip` VARCHAR ( 20 ) NOT NULL DEFAULT '' COMMENT '最后一次更新者的ip地址',
	`status` INT ( 11 ) NOT NULL DEFAULT '0' COMMENT '当前是否复原过，0：没有，1：复原过',
	PRIMARY KEY ( `id` ) 
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4;-- ----------------------------
--  Records of `sys_log`
-- ----------------------------
-- ----------------------------
--  Table structure for `sys_role`
-- ----------------------------
DROP TABLE
IF
	EXISTS `sys_role`;
CREATE TABLE `sys_role` (
	`id` INT ( 11 ) NOT NULL AUTO_INCREMENT COMMENT '角色id',
	`name` VARCHAR ( 20 ) NOT NULL,
	`type` INT ( 11 ) NOT NULL DEFAULT '1' COMMENT '角色的类型，1：管理员角色，2：其他',
	`status` INT ( 11 ) NOT NULL DEFAULT '1' COMMENT '状态，1：可用，0：冻结',
	`remark` VARCHAR ( 200 ) DEFAULT '' COMMENT '备注',
	`operator` VARCHAR ( 20 ) NOT NULL DEFAULT '' COMMENT '操作者',
	`operate_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新的时间',
	`operate_ip` VARCHAR ( 20 ) NOT NULL DEFAULT '' COMMENT '最后一次更新者的ip地址',
	PRIMARY KEY ( `id` ) 
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4;-- ----------------------------
--  Records of `sys_role`
-- ----------------------------
-- ----------------------------
--  Table structure for `sys_role_acl`
-- ----------------------------
DROP TABLE
IF
	EXISTS `sys_role_acl`;
CREATE TABLE `sys_role_acl` (
	`id` INT ( 11 ) NOT NULL AUTO_INCREMENT,
	`role_id` INT ( 11 ) NOT NULL COMMENT '角色id',
	`acl_id` INT ( 11 ) NOT NULL COMMENT '权限id',
	`operator` VARCHAR ( 20 ) NOT NULL DEFAULT '' COMMENT '操作者',
	`operate_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新的时间',
	`operate_ip` VARCHAR ( 200 ) NOT NULL DEFAULT '' COMMENT '最后一次更新者的ip',
	PRIMARY KEY ( `id` ) 
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4;-- ----------------------------
--  Records of `sys_role_acl`
-- ----------------------------
-- ----------------------------
--  Table structure for `sys_role_user`
-- ----------------------------
DROP TABLE
IF
	EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user` (
	`id` INT ( 11 ) NOT NULL AUTO_INCREMENT,
	`role_id` INT ( 11 ) NOT NULL COMMENT '角色id',
	`user_id` INT ( 11 ) NOT NULL COMMENT '用户id',
	`operator` VARCHAR ( 20 ) NOT NULL DEFAULT '' COMMENT '操作者',
	`operate_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新的时间',
	`operate_ip` VARCHAR ( 20 ) NOT NULL DEFAULT '' COMMENT '最后一次更新者的ip地址',
	PRIMARY KEY ( `id` ) 
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4;-- ----------------------------
--  Records of `sys_role_user`
-- ----------------------------
-- ----------------------------
--  Table structure for `sys_user`
-- ----------------------------
DROP TABLE
IF
	EXISTS `sys_user`;
CREATE TABLE `sys_user` (
	`id` INT ( 11 ) NOT NULL AUTO_INCREMENT COMMENT '用户id',
	`username` VARCHAR ( 20 ) NOT NULL DEFAULT '' COMMENT '用户名称',
	`telephone` VARCHAR ( 13 ) NOT NULL DEFAULT '' COMMENT '手机号',
	`mail` VARCHAR ( 20 ) NOT NULL DEFAULT '' COMMENT '邮箱',
	`password` VARCHAR ( 40 ) NOT NULL DEFAULT '' COMMENT '加密后的密码',
	`dept_id` INT ( 11 ) NOT NULL DEFAULT '0' COMMENT '用户所在部门的id',
	`status` INT ( 11 ) NOT NULL DEFAULT '1' COMMENT '状态，1：正常，0：冻结状态，2：删除',
	`remark` VARCHAR ( 200 ) DEFAULT '' COMMENT '备注',
	`operator` VARCHAR ( 20 ) NOT NULL DEFAULT '' COMMENT '操作者',
	`operate_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
	`operate_ip` VARCHAR ( 20 ) NOT NULL DEFAULT '' COMMENT '最后一次更新者的ip地址',
	PRIMARY KEY ( `id` ) 
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4;-- ----------------------------
--  Records of `sys_user`
-- ----------------------------