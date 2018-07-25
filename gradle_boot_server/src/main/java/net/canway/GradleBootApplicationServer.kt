package net.canway

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
open class GradleBootApplicationServer

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


fun main(args: Array<String>) {
    SpringApplication.run(GradleBootApplicationServer::class.java, *args)
}

