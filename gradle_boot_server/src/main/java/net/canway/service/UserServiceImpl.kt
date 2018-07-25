package net.canway.service

import net.canway.pojo.Tables
import net.canway.pojo.tables.pojos.User
import net.canway.pojo.tables.records.UserRecord
import org.jooq.DSLContext
import org.jooq.types.UInteger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl : UserService {

    @Autowired
    private val dslContext: DSLContext? = null

    /**
     * 定义表
     */
    internal var table: net.canway.pojo.tables.User = Tables.USER

    override fun findAllUser(): List<User> {

        //查询所有数据

        return dslContext!!
                .selectFrom<UserRecord>(table)
                .fetchInto(User::class.java)

    }

    override
            /**
             * 通过id删除
             */
    fun deleteByPrimaryKey(tIds: ArrayList<Int>): Int {
        for (id in tIds) {
            dslContext!!
                    .deleteFrom(table)
                    .where(table.T_ID.eq(UInteger.valueOf(id)))
                    .execute()
        }

        return 1
    }

    override
            /**
             * 插入
             */
    fun insert(record: User): Int {
        dslContext!!.insertInto<UserRecord, UInteger, String, Int, String>(table, table.T_ID, table.T_NAME, table.T_AGE, table.T_DEPT)
                .values(record.tId, record.tName, record.tAge, record.tDept)
                .execute()

        return 1
    }

    override fun insertSelective(record: User): Int {
        //        UpdateQuery updateQuery = dslContext.updateQuery(table);
        //        updateQuery.addValues();
        //        dslContext
        //                .update(table)
        //                .set(table.T_ID)

        return 0
    }

    override
            /**
             * 通过id查询数据
             */
    fun selectByPrimaryKey(tId: Int?): User? {
        val users = dslContext!!
                .selectFrom<UserRecord>(table)
                .where(table.T_ID.eq(UInteger.valueOf(tId!!)))
                .fetchInto(User::class.java)
        return if (users != null) {
            users[0]
        } else null
    }

    override fun updateByPrimaryKeySelective(record: User): Int {

        return 0
    }

    override
            /**
             * 更新数据
             */
    fun updateByPrimaryKey(record: User): Int {
        dslContext!!
                .update<UserRecord>(table)
                .set(table.T_NAME, record.tName).set(table.T_AGE, record.tAge).set(table.T_DEPT, record.tDept)
                .where(table.T_ID.eq(record.tId))
                .execute()
        return 0
    }
}
