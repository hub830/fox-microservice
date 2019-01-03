# 用户管理模块
用于处理所有微服务中涉及到的用户认证及授权请求


# 登录
用户可以通过验证码方式或短信方式来获取 TOKEN
## 验证码登录
第一步：获取验证码图片

    curl -X GET \
    http://127.0.0.1:7001/code/image \
    -H 'cache-control: no-cache' \
    -H 'deviceid: 007'
第二步：使用验证码登录

    curl -i -X POST \
    'http://127.0.0.1:7001/authentication/form' \
    -H "Content-Type:application/x-www-form-urlencoded" \
    -H "Authorization:Basic Zm94OmZveHNlY3JldA==" \
    -H 'deviceid: 007' \
    -d "username=aaaa" \
    -d "password=123456" \
    -d 'imageCode=9365'

_imageCode_ 验证码

## 短信登录
基本步骤同验证码登录
第一步：发送短信验证码

    curl -X GET \
    'http://127.0.0.1:7001/code/sms?mobile=13800138000' \
    -H 'cache-control: no-cache' \
    -H 'deviceid: 007'
第二步：使用短信验证码登录

    curl -X POST \
    http://127.0.0.1:7001/authentication/mobile \
    -H 'authorization: Basic Y2xpZW50OnNlY3JldA==' \
    -H 'cache-control: no-cache' \
    -H 'deviceid: 007' \
    -d mobile=13800138000 \
    -d smsCode=443625

_deviceid_ 发送请求的设备ID，由客户端生成，同一设备多次请求设备ID相同，不同设备之间设备ID不能重复
_authorization_ clientId:clientSecret Base64编码 由后端提供
# 配置

# 部署
## 发布到docker仓库并启动
发布

启动

查看日志
