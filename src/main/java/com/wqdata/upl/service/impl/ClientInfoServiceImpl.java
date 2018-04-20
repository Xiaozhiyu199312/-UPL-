package com.wqdata.upl.service.impl;

import com.wqdata.upl.dao.ClientInfoMapper;
import com.wqdata.upl.entity.ClientInfo;
import com.wqdata.upl.service.ClientInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * com.upl.service.impl
 * 作者      : 陈晓
 * 描述      :
 * 创建日期  : 2clientInfoMapper18/3/6
 * 修改日期  :
 */

@Service("clientInfoService")
public class ClientInfoServiceImpl implements ClientInfoService {

  @Autowired
  private ClientInfoMapper clientInfoMapper;

  public int insert(ClientInfo record) {
    return clientInfoMapper.insert(record);
  }

  public int insertSelective(ClientInfo record) {
    return clientInfoMapper.insertSelective(record);
  }

  public int updateByPrimaryKeySelective(ClientInfo record) {
    return clientInfoMapper.updateByPrimaryKeySelective(record);
  }

  public int updateByPrimaryKey(ClientInfo record) {
    return clientInfoMapper.updateByPrimaryKey(record);
  }

  public List<ClientInfo> list(String sql) {
    return clientInfoMapper.list(sql);
  }

  public int add(String sql) {
    return clientInfoMapper.add(sql);
  }

  public int update(String sql) {
    return clientInfoMapper.update(sql);
  }

  public Long getCount(String mobile) {
    return clientInfoMapper.getCount(mobile);
  }

  @Override
  public long getSelectCount(String sql) throws Exception {
    return clientInfoMapper.getSelectCount(sql);
  }

  public List<ClientInfo> getPageInfo(String sql) {
    return clientInfoMapper.getPageInfo(sql);
  }
}
