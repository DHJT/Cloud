package tech.dhjt.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
@EnableConfigServer
public class ConfigServerApp {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApp.class, args);
	}

}
