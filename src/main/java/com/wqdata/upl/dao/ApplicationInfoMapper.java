package com.wqdata.upl.dao;


import com.wqdata.upl.entity.ApplicationInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApplicationInfoMapper {

  int insert(ApplicationInfo record);

  int insertSelective(ApplicationInfo record);

  int updateByPrimaryKeySelective(ApplicationInfo record);

  int updateByPrimaryKey(ApplicationInfo record);

  List<ApplicationInfo> getSearchList(ApplicationInfo record);


  //String list(@Param(value = "sqlStr") String sqlStr);

  List<ApplicationInfo> list(@Param(value = "sqlStr") String sqlStr);

  List<ApplicationInfo> getPageInfo(@Param(value = "sqlStr") String sqlStr);

  Long getSearchCount(ApplicationInfo record);

  int add(@Param(value = "sqlStr") String sqlStr);

  int update(@Param(value = "sqlStr") String sqlStr);

  long getCount(@Param(value = "isserialno") String isserialno);

  long getSelectCount(@Param(value = "sqlStr") String sqlStr);

}