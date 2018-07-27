package net.canway.service

import net.canway.pojo.tables.pojos.User
import java.util.*

interface UserService {
    fun findAllUser(): List<*>

    fun deleteByPrimaryKey(tIds: ArrayList<Int>): Int


    fun insert(record: User): Int

    fun insertSelective(record: User): Int


    fun selectByPrimaryKey(tId: Int?): User?


    fun updateByPrimaryKeySelective(record: User): Int


    fun updateByPrimaryKey(record: User): Int
}
