package net.canway.feignService

import feign.Feign
import feign.Logger
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FeignConfig {

    val useFeign: UserFeign
        @Bean
        get() = Feign.builder()
                .logger(Logger.JavaLogger().appendToFile("D:/http.log"))
                .logLevel(Logger.Level.FULL)
                .target(UserFeign::class.java, "http://GradleBootApplicationServer")
}
