package net.canway.feignService

import feign.RequestLine

/**
 * @author eltons
 */

interface UserFeign {

    @RequestLine("GET /user")
    fun queryAllUser(): String

}
