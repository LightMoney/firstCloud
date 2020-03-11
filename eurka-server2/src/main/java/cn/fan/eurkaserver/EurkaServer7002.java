package cn.fan.eurkaserver;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurkaServer7002 {

    public static void main(String[] args) {
        SpringApplication.run(EurkaServer7002.class, args);
    }

}
