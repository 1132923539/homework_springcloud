package net.canway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class GradleBootApplicationClient {

//    @RequestMapping("/test")
//    public String tt() {
//        return "test";
//    }

    //第一种配置方式
    /*@Bean
    public ResourceConfig resourceConfig() {
        ResourceConfig config = new ResourceConfig();
        config.register(UserControl.class);
        return config;
    }*/


    public static void main(String[] args) {
        SpringApplication.run(GradleBootApplicationClient.class, args);
    }
}
