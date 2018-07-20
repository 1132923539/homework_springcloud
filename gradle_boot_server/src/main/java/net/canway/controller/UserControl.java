package net.canway.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.canway.pojo.tables.pojos.User;
import net.canway.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;


/**
 * @author eltons
 */

@RestController
@RequestMapping("/user")
public class UserControl {

    @Autowired
    private UserServiceImpl userService;


    @ApiOperation(value = "获取用户列表", notes = "")
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/")
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON)
    public List<User> findAll() {

        List<User> list = userService.findAllUser();
        return list;
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/{id}")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON)
    public User findUserById(@PathVariable("id") Integer id) {
        User user = userService.selectByPrimaryKey(id);
        return user;
    }


    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
//    @POST
//    @Path("/add")
//    @Consumes(MediaType.APPLICATION_JSON)
    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON)
    public String addUser(User user) {
        int insert = userService.insert(user);
        return "success";
    }

    @ApiOperation(value = "更新用户详细信息", notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
//    @PUT
//    @Path("/update")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public String updateUser(User user) {
        userService.updateByPrimaryKey(user);
        return "success";
    }

    @ApiOperation(value = "删除用户", notes = "根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
//    @DELETE
//    @Path("/{id}")
//    @Consumes(MediaType.APPLICATION_JSON)
    @DeleteMapping(value = "/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        ArrayList ids = new ArrayList<Integer>();
        ids.add(id);
        userService.deleteByPrimaryKey(ids);
        return "success";
    }
}
