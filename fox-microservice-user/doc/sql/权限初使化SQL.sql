#超级管理员角色
INSERT INTO `hops_user`.`role` (`id`, `createtime`, `optimistic`, `updatetime`, `description`, `name`) VALUES ('10001', '2019-01-04 06:29:41', '0', '2019-01-04 06:29:41', '超级管理员角色,拥有所有权限', '超级管理员');

#超级管理员用户 初使密码 123456
INSERT INTO `hops_user`.`user` (`id`, `createtime`, `optimistic`, `updatetime`, `last_update_password_time`, `locked`, `password`, `username`) VALUES ('10001', '2019-01-04 06:55:16', '1', '2019-01-04 06:57:25', '2019-01-04 06:55:16', '0', '$10$CBVuGYGmDPxxCwRrbHJGDOWHtHWnYBNq33GIPCVgKut7GKut.z6ia', '超级管理员');

#超级管理员用户 授予超级管理员角色
INSERT INTO `hops_user`.`user_roles` (`user_id`, `roles_id`) VALUES ('10001', '10001');

#系统涉及到的所有权限
#产品 产品分类 模块编号 101 
INSERT INTO `hops_user`.`privilege` (`id`, `createtime`, `optimistic`, `updatetime`, `description`, `name`, `operation`) 
VALUES ('10100001', '2019-01-04 05:30:25', '0', '2019-01-04 05:30:25', '产品分类查看', '查看', 'PRIVILEGE_PRODUCT_CATEGORY_READ');

INSERT INTO `hops_user`.`privilege` (`id`, `createtime`, `optimistic`, `updatetime`, `description`, `name`, `operation`) 
VALUES ('10100002', '2019-01-04 05:30:25', '0', '2019-01-04 05:30:25', '产品分类新增', '增加', 'PRIVILEGE_PRODUCT_CATEGORY_ADD');

INSERT INTO `hops_user`.`privilege` (`id`, `createtime`, `optimistic`, `updatetime`, `description`, `name`, `operation`) 
VALUES ('10100003', '2019-01-04 05:30:25', '0', '2019-01-04 05:30:25', '产品分类修改', '修改', 'PRIVILEGE_PRODUCT_CATEGORY_UPDATE');

INSERT INTO `hops_user`.`privilege` (`id`, `createtime`, `optimistic`, `updatetime`, `description`, `name`, `operation`) 
VALUES ('10100004', '2019-01-04 05:30:25', '0', '2019-01-04 05:30:25', '产品分类删除', '删除', 'PRIVILEGE_PRODUCT_CATEGORY_DEL');


#给超级管理员角色授予所有权限
INSERT INTO `hops_user`.`role_privileges` (`role_id`, `privileges_id`) VALUES ('10001', '10100001');
INSERT INTO `hops_user`.`role_privileges` (`role_id`, `privileges_id`) VALUES ('10001', '10100002');
INSERT INTO `hops_user`.`role_privileges` (`role_id`, `privileges_id`) VALUES ('10001', '10100003');
INSERT INTO `hops_user`.`role_privileges` (`role_id`, `privileges_id`) VALUES ('10001', '10100004');

