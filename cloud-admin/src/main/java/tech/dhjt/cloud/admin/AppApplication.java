package tech.dhjt.cloud.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

//@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableAdminServer
@EnableDiscoveryClient
public class AppApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(AppApplication.class, args);
	}

}
