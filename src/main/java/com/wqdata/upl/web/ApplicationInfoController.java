package com.wqdata.upl.web;

import com.wqdata.upl.entity.ApplicationInfo;
import com.wqdata.upl.service.ApplicationInfoService;
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
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * com.upl.web
 * 作者      : 陈晓
 * 描述      :
 * 创建日期  : 2018/3/6
 * 修改日期  :
 */

@Controller
@RequestMapping("/applicationInfo")
public class ApplicationInfoController {

  @Resource
  private ApplicationInfoService applicationInfoService;

  private SqlUtil sqlUtil = new SqlUtil();

  private ExceptionInfoCollertUtil exceptionInfoCollertUtil = new ExceptionInfoCollertUtil();

  private StringBuilder stringBuilder;

  private String tableName = "t_application_info";

  private String primaryKey = "ISSERIALNO";


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
    stringBuilder = new StringBuilder("insert into t_application_info (");
    try {
      String urlDecoderString = sqlUtil.getURLDecoderString(body);
      System.out.println("=====applicationInfo的添加转码URL=====" + urlDecoderString);
      //获得执行的SQL语句
      String sql = sqlUtil.getAddSql(urlDecoderString, stringBuilder, primaryKey);
      if (StringUtil.isNotEmpty(sql)) {
        String primaryKeyValue = sqlUtil.getPrimaryKeyValue();
        Long count = applicationInfoService.getCount("'" + primaryKeyValue + "'");
        if (count > 0) {
          result.put("error", "主键ISSERIALNO不能重复");
        } else {
          int add = applicationInfoService.add(sql);
          System.out.println("============" + add);
          result.put("ok", add);
        }
      } else {
        result.put("error", "主键ISSERIALNO不可缺少或为空！！！");
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
    stringBuilder = new StringBuilder("UPDATE t_application_info SET ");
    try {
      String urlDecoderString = sqlUtil.getURLDecoderString(body);
      System.out.println("=====applicationInfo的修改转码URL=====" + urlDecoderString);
      //获得执行的SQL语句
      String sql = sqlUtil.getUpdateSql(urlDecoderString, stringBuilder, primaryKey, true);
      if (StringUtil.isEmpty(sql)) {
        result.put("error", "流水ISSERIALNO不能为空！！！");
      } else {
        Integer update = applicationInfoService.update(sql);
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
    String dateStr = "INPUTDATE,FINISHTIME";
    JSONObject result = new JSONObject();
    stringBuilder = new StringBuilder();
    try {
      //URL解码获得初始POST的值
      String urlDecoderString = sqlUtil.getURLDecoderString(str);
      System.out.println("====applicationInfo的查询转码URL======" + urlDecoderString);
      //获得执行的SQL语句
      String sql = sqlUtil.getSelectSql(urlDecoderString, stringBuilder, tableName);
      List<ApplicationInfo> list = applicationInfoService.list(sql);
      //  jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor("yyyy/MM/dd HH:mm:ss"));
      JSONArray array = JSONArray.fromObject(list);
      result.put("data", array);
    } catch (Exception e) {
      String s = exceptionInfoCollertUtil.errorOutput(response, result, e);
      e.printStackTrace();
    }
    ResponseUtil.write(response, result);
    return null;
  }


  /**
   * 将字符编码转化为GBK
   *
   * @param sql sql语句
   * @return
   */
  private String toGBK(String sql) {
    String gbk = this.changeCharset(sql, "GBK");
    System.out.println("==============改变为GBK编码格式的SQL语句==========" + gbk);
    return gbk;
  }

  /**
   * 字符串编码的转换方法
   *
   * @param sql        sql语句
   * @param newCharset 新的编码格式
   * @return
   */
  public String changeCharset(String sql, String newCharset) {
    if (sql != null) {
      byte[] bs = sql.getBytes();
      try {
        return new String(bs, newCharset);
      } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
      }
    }
    return null;
  }
}
