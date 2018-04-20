package com.wqdata.upl.service.impl;

import com.wqdata.upl.dao.CreditAuthMapper;
import com.wqdata.upl.entity.CreditAuth;
import com.wqdata.upl.service.CreditAuthService;
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

@Service("creditAuthService")
public class CreditAuthServiceImpl implements CreditAuthService {

  @Autowired
  private CreditAuthMapper creditAuthMapper;

  public int insert(CreditAuth record) {
    return creditAuthMapper.insert(record);
  }

  public int insertSelective(CreditAuth record) {
    return creditAuthMapper.insertSelective(record);
  }

  public int updateByPrimaryKeySelective(CreditAuth record) {
    return creditAuthMapper.updateByPrimaryKeySelective(record);
  }

  public int updateByPrimaryKey(CreditAuth record) {
    return creditAuthMapper.updateByPrimaryKey(record);
  }

  public List<CreditAuth> getPageInfo(String sql) {
    return creditAuthMapper.getPageInfo(sql);
  }

  public List<CreditAuth> list(String sql) {
    return creditAuthMapper.list(sql);
  }

  public int add(String sql) {
    return creditAuthMapper.add(sql);
  }

  public int update(String sql) {
    return creditAuthMapper.update(sql);
  }

  public Long getCount(String idcard) {
    return creditAuthMapper.getCount(idcard);
  }

  @Override
  public long getSelectCount(String sql) throws Exception {
    return creditAuthMapper.getSelectCount(sql);
  }
}
