INSERT INTO `hops_user`.`privilege` (`id`, `createtime`, `optimistic`, `updatetime`, `description`, `name`, `operation`) VALUES ('10001', '2019-01-04 05:30:25', '0', '2019-01-04 05:30:25', '测试模块1查看权限', '查看', 'MODULE_PRIVILEGE_READ');
INSERT INTO `hops_user`.`privilege` (`id`, `createtime`, `optimistic`, `updatetime`, `description`, `name`, `operation`) VALUES ('10002', '2019-01-04 05:30:25', '0', '2019-01-04 05:30:25', '测试模块1新增权限', '增加', 'MODULE_PRIVILEGE_ADD');

INSERT INTO `hops_user`.`role` (`id`, `createtime`, `optimistic`, `updatetime`, `description`, `name`) VALUES ('10001', '2019-01-04 06:29:41', '0', '2019-01-04 06:29:41', '普通用户角色', '普通用户');
INSERT INTO `hops_user`.`role_privileges` (`role_id`, `privileges_id`) VALUES ('10001', '10001');

INSERT INTO `hops_user`.`role` (`id`, `createtime`, `optimistic`, `updatetime`, `description`, `name`) VALUES ('10002', '2019-01-04 06:29:41', '0', '2019-01-04 06:29:41', '管理用户角色', '管理用户');
INSERT INTO `hops_user`.`role_privileges` (`role_id`, `privileges_id`) VALUES ('10002', '10001');
INSERT INTO `hops_user`.`role_privileges` (`role_id`, `privileges_id`) VALUES ('10002', '10002');

INSERT INTO `hops_user`.`user` (`id`, `createtime`, `optimistic`, `updatetime`, `last_update_password_time`, `locked`, `password`, `username`) VALUES ('10001', '2019-01-04 06:55:16', '1', '2019-01-04 06:57:25', '2019-01-04 06:55:16', '0', '123456', '13800138000');
INSERT INTO `hops_user`.`user_roles` (`user_id`, `roles_id`) VALUES ('10001', '10001');
