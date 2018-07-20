package net.canway.service;

import net.canway.pojo.Tables;
import net.canway.pojo.tables.pojos.User;
import org.jooq.DSLContext;
import org.jooq.types.UInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private DSLContext dslContext;

    /**
     * 定义表
     */
    net.canway.pojo.tables.User table = Tables.USER;

    @Override
    public List<User> findAllUser() {

        //查询所有数据
        List<User> users = dslContext
                .selectFrom(table)
                .fetchInto(User.class);

        return users;

    }

    @Override
    /**
     * 通过id删除
     */
    public int deleteByPrimaryKey(ArrayList<Integer> tIds) {
        for (Integer id :
                tIds) {
            dslContext
                    .deleteFrom(table)
                    .where(table.T_ID.eq(UInteger.valueOf(id)))
                    .execute();
        }

        return 1;
    }

    @Override
    /**
     * 插入
     */
    public int insert(User record) {
        dslContext.insertInto(table, table.T_ID, table.T_NAME, table.T_AGE, table.T_DEPT)
                .values(record.getTId(), record.getTName(), record.getTAge(), record.getTDept())
                .execute();

        return 1;
    }

    @Override
    public int insertSelective(User record) {
//        UpdateQuery updateQuery = dslContext.updateQuery(table);
//        updateQuery.addValues();
//        dslContext
//                .update(table)
//                .set(table.T_ID)

        return 0;
    }

    @Override
    /**
     * 通过id查询数据
     */
    public User selectByPrimaryKey(Integer tId) {
        List<User> users = dslContext
                .selectFrom(table)
                .where(table.T_ID.eq(UInteger.valueOf(tId)))
                .fetchInto(User.class);
        if (users != null) {
            return users.get(0);
        }
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {

        return 0;
    }

    @Override
    /**
     * 更新数据
     */
    public int updateByPrimaryKey(User record) {
        dslContext
                .update(table)
                .set(table.T_NAME, record.getTName()).set(table.T_AGE, record.getTAge()).set(table.T_DEPT, record.getTDept())
                .where(table.T_ID.eq(record.getTId()))
                .execute();
        return 0;
    }
}
