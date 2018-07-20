package net.canway.controller;

import io.swagger.annotations.ApiOperation;
import net.canway.feignService.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.core.MediaType;


/**
 * @author eltons
 */

@RestController
public class UserControl {

    //    @Autowired
//    private UserServiceImpl userService;


    @Autowired
    UserFeign userFeign;

    RestTemplate restTemplate = new RestTemplate();

    @ApiOperation(value = "获取用户列表", notes = "")

    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON)
    public String findAll() {
        return restTemplate.getForObject("http://localhost:7070/user", String.class);
    }

    @GetMapping(value = "/user1", produces = MediaType.APPLICATION_JSON)
    public String queryAll() {
        return restTemplate.getForObject("http://localhost:7070/user", String.class);
    }
}
