package cn.fan;

import cn.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="CLOULD-PROVIDER",configuration=MySelfRule.class)//指定自定义的ribbon配置类
public class DeptConsumer8089
{
	public static void main(String[] args)
	{
		SpringApplication.run(DeptConsumer8089.class, args);
	}
}
