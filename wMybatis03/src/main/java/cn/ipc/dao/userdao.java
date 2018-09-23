package cn.ipc.dao;

import cn.ipc.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@CacheNamespace(blocking = true)
public interface userdao {
    @Update("update user set username=#{username},sex=#{sex} where id=#{id} ")
    public void findall(User us);



    @Select("select * from user")
    @Results(id="user",value={
        @Result(id=true,column = "id" ,property = "id"),
        @Result(column = "username",property = "username"),
        @Result(column = "birthday",property = "birthday"),
        @Result(column = "sex",property = "sex"),
        @Result(column = "address",property = "address"),
        @Result(property ="accounts",column ="id", many =
        @Many(select = "cn.ipc.dao.AccountDao.findbyid",fetchType =FetchType.EAGER ))

    })
    public List<User> findbyusers();

}
