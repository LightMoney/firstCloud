package cn.fan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Auth Mr.fgy
 * Date 2019/12/25 15:08
 **/
@SpringBootApplication
@EnableEurekaClient
@MapperScan("cn.fan.dao")
public class SecondProvider8002 {
    public static void main(String[] args) {
        SpringApplication.run(SecondProvider8002.class, args);
    }
}
