package cn.fan;

import cn.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name="CLOULD-PROVIDER",configuration=MySelfRule.class)//指定自定义的ribbon配置类
@EnableFeignClients(basePackages= {"cn.fan"})
@ComponentScan("cn.fan")
@EnableCircuitBreaker
public class DeptFeignConsumer80
{
	public static void main(String[] args)
	{
		SpringApplication.run(DeptFeignConsumer80.class, args);
	}
}
