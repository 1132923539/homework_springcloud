package net.canway.controller

import io.swagger.annotations.ApiOperation
import net.canway.feignService.UserFeign
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

import javax.ws.rs.core.MediaType


/**
 * @author eltons
 */

@RestController
class UserControl {

    //    @Autowired
    //    private UserServiceImpl userService;


    @Autowired
    internal var userFeign: UserFeign? = null

    internal var restTemplate = RestTemplate()

    @ApiOperation(value = "获取用户列表", notes = "")
    @GetMapping(value = "/user", produces = arrayOf(MediaType.APPLICATION_JSON))
    fun findAll(): String {
        return userFeign!!.queryAllUser()
    }

    @GetMapping(value = "/user1", produces = arrayOf(MediaType.APPLICATION_JSON))
    fun queryAll(): String? {
        return restTemplate.getForObject("http://localhost:7070/user", String::class.java)
    }
}
