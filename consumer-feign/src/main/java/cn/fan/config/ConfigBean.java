package cn.fan.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean //boot -->spring   applicationContext.xml --- @Configuration配置   ConfigBean = applicationContext.xml
{
	//注入此类，用来消费者调用服务提供者提供的服务
	@Bean
	//@LoadBalanced  //Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端（默认轮询）
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}