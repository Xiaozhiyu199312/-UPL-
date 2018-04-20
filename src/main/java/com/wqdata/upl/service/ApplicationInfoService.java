package com.wqdata.upl.service;

import com.wqdata.upl.entity.ApplicationInfo;

import java.util.List;

public interface ApplicationInfoService {

    //添加
    int insert(ApplicationInfo record);
    //添加
    int insertSelective(ApplicationInfo record);
    //修改
    int updateByPrimaryKeySelective(ApplicationInfo record);
    //修改
    int updateByPrimaryKey(ApplicationInfo record);
    //获得模糊查询列表信息
    List<ApplicationInfo> getSearchList(ApplicationInfo record);

    List<ApplicationInfo> list(String sql)throws Exception;
    //String list(String sql)throws Exception;
    //获得模糊查询列表总数
    Long getSearchCount(ApplicationInfo record);

    Long getCount(String isserialno)throws Exception;

    long getSelectCount(String sql)throws Exception;

    int add(String sql)throws Exception;

    int update(String sql)throws Exception;

    List<ApplicationInfo> getPageInfo(String sql);
}