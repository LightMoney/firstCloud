package cn.fan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * Auth Mr.fgy
 * Date 2019/12/25 15:08
 **/
@SpringBootApplication
@EnableEurekaClient  //高版本可能还需EnableDiscoveryClient来发现服务
@MapperScan("cn.fan.dao")
@EnableCircuitBreaker  //对hystrixR熔断机制的支持
public class HystrixProvider8001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixProvider8001.class, args);
    }
}
