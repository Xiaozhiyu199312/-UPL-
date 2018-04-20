package com.wqdata.upl.web;

import com.wqdata.upl.entity.ClientInfo;
import com.wqdata.upl.service.ClientInfoService;
import com.wqdata.upl.util.ExceptionInfoCollertUtil;
import com.wqdata.upl.util.ResponseUtil;
import com.wqdata.upl.util.SqlUtil;
import com.wqdata.upl.util.StringUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * com.upl.web
 * 作者      : 陈晓
 * 描述      :
 * 创建日期  : 2018/3/6
 * 修改日期  :
 */


@Controller
@RequestMapping("/clientInfo")
public class ClientInfoController {

  @Resource
  private ClientInfoService clientInfoService;

  private SqlUtil sqlUtil = new SqlUtil();

  private ExceptionInfoCollertUtil exceptionInfoCollertUtil = new ExceptionInfoCollertUtil();

  private StringBuilder stringBuilder;

  private String tableName = "t_client_info";

  private String primaryKey = "MOBILE";

  /**
   * 进行添加操作
   *
   * @param body
   * @param response
   * @return
   */
  @RequestMapping("/add")
  public String add(@RequestBody String body, HttpServletResponse response) {
    JSONObject result = new JSONObject();
    stringBuilder = new StringBuilder("insert into " + tableName + " (");
    try {
      String urlDecoderString = sqlUtil.getURLDecoderString(body);
      System.out.println("=====clientInfo的添加转码URL=====" + urlDecoderString);
      //获得执行的SQL语句
      String sql = sqlUtil.getAddSql(urlDecoderString, stringBuilder, primaryKey);
      if (StringUtil.isNotEmpty(sql)) {
        String primaryKeyValue = sqlUtil.getPrimaryKeyValue();
        Long count = clientInfoService.getCount(primaryKeyValue);
        if (count > 0) {
          result.put("error", "主键MOBILE不能重复");
        } else {
          int add = clientInfoService.add(sql);
          System.out.println("============" + add);
          result.put("ok", add);
        }
      } else {
        result.put("error", "主键MOBILE不可缺少或为空！！！");
      }
    } catch (Exception e) {
      exceptionInfoCollertUtil.errorOutput(response, result, e);
      e.printStackTrace();
    }
    ResponseUtil.write(response, result);
    return null;
  }

  /**
   * 对用户的数据进行更新
   *
   * @param body
   * @param response
   * @return
   */
  @RequestMapping("/update")
  public String update(@RequestBody String body, HttpServletResponse response) {
    JSONObject result = new JSONObject();
    stringBuilder = new StringBuilder("update " + tableName + " set ");
    try {
      String urlDecoderString = sqlUtil.getURLDecoderString(body);
      System.out.println("=====clientInfo的修改转码URL=====" + urlDecoderString);
      //获得执行的SQL语句
      String sql = sqlUtil.getUpdateSql(urlDecoderString, stringBuilder, primaryKey, false);
      if (StringUtil.isEmpty(sql)) {
        result.put("error", "主键MOBILE不能为空！！！");
      } else {
        Integer update = clientInfoService.update(sql);
        System.out.println("============" + update);
        result.put("ok", update);
      }
    } catch (Exception e) {
      exceptionInfoCollertUtil.errorOutput(response, result, e);
      e.printStackTrace();
    }
    ResponseUtil.write(response, result);
    return null;
  }

  /**
   * 根据查询字段和条件返回对应Json信息数据
   *
   * @param str
   * @param response
   * @return
   */
  @RequestMapping(value = "/search")
  public String search(@RequestBody String str, HttpServletResponse response) {
    JSONObject result = new JSONObject();
    stringBuilder = new StringBuilder();
    //URL解码获得初始POST的值
    try {
      String urlDecoderString = sqlUtil.getURLDecoderString(str);
      System.out.println("====clientInfo的查询转码URL======" + urlDecoderString);
      //获得执行的SQL语句
      String sql = sqlUtil.getSelectSql(urlDecoderString, stringBuilder, tableName);
      List<ClientInfo> list = clientInfoService.list(sql);
      JSONArray array = JSONArray.fromObject(list);
      result.put("data", array);
    } catch (Exception e) {
      exceptionInfoCollertUtil.errorOutput(response, result, e);
      e.printStackTrace();
    }
    ResponseUtil.write(response, result);
    return null;
  }


}
