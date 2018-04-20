package com.wqdata.upl.service;

import com.wqdata.upl.entity.ClientInfo;

import java.util.List;

public interface ClientInfoService {

    int insert(ClientInfo record);

    int insertSelective(ClientInfo record);

    int updateByPrimaryKeySelective(ClientInfo record);

    int updateByPrimaryKey(ClientInfo record);

    List<ClientInfo> list(String sql)throws Exception;

    int add(String sql)throws Exception;

    int update(String sql)throws Exception;

    Long getCount(String mobile);

    long getSelectCount(String sql)throws Exception;

    List<ClientInfo> getPageInfo(String sql);
}