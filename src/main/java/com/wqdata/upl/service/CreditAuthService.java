package com.wqdata.upl.service;

import com.wqdata.upl.entity.CreditAuth;

import java.util.List;

public interface CreditAuthService {


    int insert(CreditAuth record);

    int insertSelective(CreditAuth record);

    int updateByPrimaryKeySelective(CreditAuth record);

    int updateByPrimaryKey(CreditAuth record);

    List<CreditAuth> getPageInfo(String sql);

    List<CreditAuth> list(String sql)throws Exception;

    int add(String sql)throws Exception;

    int update(String sql)throws Exception;

    Long getCount(String idcard);

    long getSelectCount(String sql)throws Exception;
}