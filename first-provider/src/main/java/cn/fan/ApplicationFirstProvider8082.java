package cn.fan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import sun.applet.Main;

/**
 * Auth Mr.fgy
 * Date 2019/12/25 15:08
 **/
@SpringBootApplication
@EnableEurekaClient
@MapperScan("cn.fan.dao")
public class ApplicationFirstProvider8082 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationFirstProvider8082.class, args);
    }
}
