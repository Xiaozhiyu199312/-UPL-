package com.wqdata.upl.dao;


import com.wqdata.upl.entity.CreditAuth;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CreditAuthMapper {
    int insert(CreditAuth record);

    int insertSelective(CreditAuth record);

    int updateByPrimaryKeySelective(CreditAuth record);

    int updateByPrimaryKey(CreditAuth record);

    List<CreditAuth> list(@Param(value = "sqlStr") String sqlStr);

    List<CreditAuth> getPageInfo(@Param(value = "sqlStr") String sqlStr);

    int add(@Param(value = "sqlStr") String sqlStr);

    int update(@Param(value = "sqlStr") String sqlStr);

    long getCount(@Param(value = "idcard") String idcard);

    long getSelectCount(@Param(value = "sqlStr") String sqlStr);
}