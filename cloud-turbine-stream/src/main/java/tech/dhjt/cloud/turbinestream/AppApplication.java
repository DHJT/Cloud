package tech.dhjt.cloud.turbinestream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

//@EnableHystrix
@EnableTurbineStream
@SpringBootApplication
public class AppApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AppApplication.class, args);
    }

}
