package cn.ipc.dao;

import cn.ipc.domain.Account;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AccountDao {
    @Select("select * from Account where uid=#{id}")
    public List<Account> findbyid(int id);
}
