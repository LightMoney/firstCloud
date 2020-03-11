package cn.fan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard//监控启动
public class DeptConsumer_DashBoard9001
{
	public static void main(String[] args)
	{
		SpringApplication.run(DeptConsumer_DashBoard9001.class, args);
	}
}
