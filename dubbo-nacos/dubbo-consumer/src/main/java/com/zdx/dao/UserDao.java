package com.zdx.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    @Insert("insert into `user` (name) values ('2')  ")
    int save();
}
