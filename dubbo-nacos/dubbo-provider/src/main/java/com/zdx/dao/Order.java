package com.zdx.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Order {
    @Insert("insert into `order` (name) values ('3') ")
    int save();
}
