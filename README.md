# README
<!-- @author DHJT 2020-09-07 -->
微服务测试

### 注册中心：
http://eureka7001.com:40000/

### 网关：
http://myzuul.com:9527/dhjt/cloud-dept/dept/list
http://myzuul.com:9527/dhjt/mydept/dept/list
http://myzuul.com:9527/actuator/info

### 配置中心：
http://config-3344.com:7010
http://localhost:7010/application-dev.yml
http://localhost:7010/cloud-config-dept-client/dev
http://config-3344.com:3344/application-dev.yml
http://config-3344.com:3344/application-test.yml

### Admin-Server
http://localhost:8788

### 服务提供者-Dept
40020
`http://localhost:40020/dept/list`
服务的熔断器仪表盘 `http://localhost:40020/hystrix` 需要访问由`@HystrixCommand`注解的方法，这样才能产生服务调用数据，才能出来界面，否则界面一致在loading
`http://localhost:40020/dept/get/2`

### turbine
40030

### 管理端点
http://169.254.250.162:40010/actuator


3.spring boot2.0以后，不提供 hystrix.stream节点，需要自己添加【
[java.lang.IllegalStateException: Calling [asyncError()] is not valid for a request with Async state](https://blog.csdn.net/l1161558158/article/details/86569748)
[SpringCloud Config使用本地仓库](https://www.cnblogs.com/wangxuejian/p/13622035.html)