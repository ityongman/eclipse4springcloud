1. springcloud-day01是eureka 服务注册中心
2. springcloud-day-1-eureka-client是 服务提供者, 分别以port=2222 , service-name=compute-service-A  和 port=3333 , service-name=compute-service-B 提供
一共提供两个服务

3. 本工程(服务网关)包含服务路由, 权限校验功能