package net.canway.cloud.cloud_client2.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient("GradleBootApplicationServer")
public interface UseFeign {


    @RequestMapping(value = "/user", method = RequestMethod.GET)
    String findUser();

}
