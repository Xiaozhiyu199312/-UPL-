package com.wqdata.upl.service.impl;


import com.wqdata.upl.dao.ApplicationInfoMapper;
import com.wqdata.upl.entity.ApplicationInfo;
import com.wqdata.upl.service.ApplicationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * com.upl.service.impl
 * 作者      : 陈晓
 * 描述      :
 * 创建日期  : 2018/3/6
 * 修改日期  :
 */

@Service("applicationInfoService")
public class ApplicationInfoServiceImpl implements ApplicationInfoService {

  @Autowired
  private ApplicationInfoMapper applicationInfoMapper;

  public int insert(ApplicationInfo record) {
    return applicationInfoMapper.insert(record);
  }

  public int insertSelective(ApplicationInfo record) {
    return applicationInfoMapper.insertSelective(record);
  }

  public int updateByPrimaryKeySelective(ApplicationInfo record) {
    return applicationInfoMapper.updateByPrimaryKeySelective(record);
  }

  public int updateByPrimaryKey(ApplicationInfo record) {
    return applicationInfoMapper.updateByPrimaryKey(record);
  }

  public List<ApplicationInfo> getSearchList(ApplicationInfo record) {
    return applicationInfoMapper.getSearchList(record);
  }

  public List<ApplicationInfo> list(String sql) {
    return applicationInfoMapper.list(sql);
  }

  public Long getSearchCount(ApplicationInfo record) {
    return applicationInfoMapper.getSearchCount(record);
  }

  public Long getCount(String certid) {
    return applicationInfoMapper.getCount(certid);
  }


  @Override
  public long getSelectCount(String sql) throws Exception {
    return applicationInfoMapper.getSelectCount(sql);
  }

  public int add(String sql) {
    return applicationInfoMapper.add(sql);
  }

  public int update(String sql) {
    return applicationInfoMapper.update(sql);
  }

  public List<ApplicationInfo> getPageInfo(String sql) {
    return applicationInfoMapper.getPageInfo(sql);
  }
}
