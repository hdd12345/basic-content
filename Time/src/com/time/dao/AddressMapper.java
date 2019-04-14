package com.time.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.time.entity.Address;

@Repository("addressDao")
public interface AddressMapper {
    int deleteByPrimaryKey(Long adrId);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Long adrId);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
    
    //查询用户地址
    List<Address> selectByuId(@Param("uId")Long uId);
}