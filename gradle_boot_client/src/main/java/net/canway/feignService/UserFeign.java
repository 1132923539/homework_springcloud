package net.canway.feignService;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author eltons
 */

@FeignClient(value = "GradleBootApplicationServer", url = "http://localhost:7070")
public interface UserFeign {
    @LoadBalanced
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    String queryAllUser();

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    String findUser();
}
