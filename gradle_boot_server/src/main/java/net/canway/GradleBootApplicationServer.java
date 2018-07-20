package net.canway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
//@MapperScan("net.canway.mapper")
public class GradleBootApplicationServer {

//    @RequestMapping("/aa")
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
        SpringApplication.run(GradleBootApplicationServer.class, args);
    }
}
