package cn.fan.txclient2;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication//(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
@EnableDistributedTransaction
@EnableFeignClients
@MapperScan("cn.fan.txclient2.banka")
public class TxClient2Application {

    public static void main(String[] args) {
        SpringApplication.run(TxClient2Application.class, args);
    }

}
