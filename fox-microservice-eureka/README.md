# 配置
开发环境中，配置关闭自我保护，并按需配置Eureka Server清理无效节点的时间间隔。更改Eureka更新频率将打破服务器的自我保护功能，生产环境下不建议自定义这些配置。

    ureka.server.enable-self-preservation	# 设为false，关闭自我保护
    eureka.server.eviction-interval-timer-in-ms # 清理间隔（单位毫秒，默认是60*1000）
# 部署
## 发布到docker仓库并启动
发布

    git pull # 在安装了docker的机器上从git服务器上拉取最新代码
    cd fox-microservice-eureka/ # 进入到eureka项目目录
    gradle clear build docker # 将eureka生成镜像 
启动

    docker run --name eureka-server \
    --publish 8761:8761 -d  \
    --restart=always  \
    fox-microservice/eureka-server:0.1.1-SNAPSHOT
查看日志

    docker logs -f eureka-server
