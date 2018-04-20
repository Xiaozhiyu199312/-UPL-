package com.wqdata.upl.dao;


import com.wqdata.upl.entity.ClientInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClientInfoMapper {
    int insert(ClientInfo record);

    int insertSelective(ClientInfo record);

    int updateByPrimaryKeySelective(ClientInfo record);

    int updateByPrimaryKey(ClientInfo record);

    List<ClientInfo> list(@Param(value = "sqlStr") String sqlStr);

    List<ClientInfo> getPageInfo(@Param(value = "sqlStr") String sqlStr);

    int add(@Param(value = "sqlStr") String sqlStr);

    int update(@Param(value = "sqlStr") String sqlStr);

    long getCount(@Param(value = "mobile") String mobile);

    long getSelectCount(@Param(value = "sqlStr") String sqlStr);

}