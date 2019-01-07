# 产品微服务

## 简介
## 安装说明
1. 初使化数据库

```
    docker exec -it some-mongo mongo admin
    use admin
    db.auth('admin','admin')
    use foxproduct
    db.createUser({ user: 'foxproduct', pwd: 'fox123456', roles: [ { role: "readWrite", db: "foxproduct" } ] });

````
2. 启动服务
```

```


