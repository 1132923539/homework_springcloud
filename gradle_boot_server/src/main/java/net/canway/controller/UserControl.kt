package net.canway.controller

import io.swagger.annotations.ApiImplicitParam
import io.swagger.annotations.ApiImplicitParams
import io.swagger.annotations.ApiOperation
import net.canway.pojo.tables.pojos.User
import net.canway.service.UserServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.ws.rs.core.MediaType


/**
 * @author eltons
 */

@RestController
@RequestMapping("/user")
class UserControl {

    @Autowired
    private val userService: UserServiceImpl? = null


    @ApiOperation(value = "获取用户列表", notes = "")
    //    @GET
    //    @Produces(MediaType.APPLICATION_JSON)
    //    @Path("/")
    @GetMapping(value = "", produces = arrayOf(MediaType.APPLICATION_JSON))
    fun findAll(): List<User> {

        return userService!!.findAllUser()
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
    @GetMapping(value = "/{id}", produces = arrayOf(MediaType.APPLICATION_JSON))
    fun findUserById(@PathVariable("id") id: Int?): User? {
        return userService!!.selectByPrimaryKey(id)
    }


    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    //    @POST
    //    @Path("/add")
    //    @Consumes(MediaType.APPLICATION_JSON)
    @PostMapping(value = "/add", consumes = arrayOf(MediaType.APPLICATION_JSON))
    fun addUser(user: User): String {
        val insert = userService!!.insert(user)
        return "success"
    }

    @ApiOperation(value = "更新用户详细信息", notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams(ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"), ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User"))
    //    @PUT
    //    @Path("/update")
    //    @Produces(MediaType.APPLICATION_JSON)
    //    @Consumes(MediaType.APPLICATION_JSON)
    @PutMapping(value = "/update", consumes = arrayOf(MediaType.APPLICATION_JSON), produces = arrayOf(MediaType.APPLICATION_JSON))
    fun updateUser(user: User): String {
        userService!!.updateByPrimaryKey(user)
        return "success"
    }

    @ApiOperation(value = "删除用户", notes = "根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    //    @DELETE
    //    @Path("/{id}")
    //    @Consumes(MediaType.APPLICATION_JSON)
    @DeleteMapping(value = "/{id}")
    fun deleteUser(@PathVariable("id") id: Int): String {
        val ids = ArrayList<Int>()
        ids.add(id)
        userService!!.deleteByPrimaryKey(ids)
        return "success"
    }
}
