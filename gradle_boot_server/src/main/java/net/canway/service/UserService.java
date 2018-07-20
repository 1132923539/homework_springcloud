package net.canway.service;

import net.canway.pojo.tables.pojos.User;

import java.util.ArrayList;
import java.util.List;

public interface UserService {
    List findAllUser();

    int deleteByPrimaryKey(ArrayList<Integer> tIds);


    int insert(User record);

    int insertSelective(User record);


    User selectByPrimaryKey(Integer tId);


    int updateByPrimaryKeySelective(User record);


    int updateByPrimaryKey(User record);
}
