package net.canway

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
object GradleBootApplicationClient {

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


    @JvmStatic
    fun main(args: Array<String>) {
        SpringApplication.run(GradleBootApplicationClient::class.java, *args)
    }
}
