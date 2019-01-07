# 订单管理模块
用于普通购买请求

# 依赖的项目
user 依赖用户模块做用户校验与授权
product 依赖产品模块做产品管理与库存管理

## 安装说明
1. 初使化数据库

```
    docker exec -it hops-mongo mongo admin
    use admin
    db.auth('admin','admin')
    use foxorder
    db.createUser({ user: 'foxorder', pwd: 'fox123456', roles: [ { role: "readWrite", db: "foxorder" } ] });
```

# 部署
## 发布到docker仓库并启动
发布

启动

查看日志
