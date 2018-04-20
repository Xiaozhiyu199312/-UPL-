package com.wqdata.upl.web;

import com.wqdata.upl.service.ApplicationInfoService;
import com.wqdata.upl.service.ClientInfoService;
import com.wqdata.upl.service.CreditAuthService;
import com.wqdata.upl.util.ExceptionInfoCollertUtil;
import com.wqdata.upl.util.ResponseUtil;
import com.wqdata.upl.util.SqlUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * com.wqdata.upl.web
 * 作者      : 陈晓
 * 描述      :
 * 创建日期  : 2018/3/9
 * 修改日期  :
 */
@Controller
@RequestMapping("/pageInfo")
public class PageController {

  @Resource
  private CreditAuthService creditAuthService;

  @Resource
  private ApplicationInfoService applicationInfoService;

  @Resource
  private ClientInfoService clientInfoService;

  private String table1 = "t_application_info";
  private String table2 = "t_client_info";
  private String table3 = "t_credit_auth";
  private String sqlStr = "sql=";
  private String sqlStr1 = "&countSql=";

  private SqlUtil sqlUtil = new SqlUtil();

  private ExceptionInfoCollertUtil exceptionInfoCollertUtil = new ExceptionInfoCollertUtil();


  @RequestMapping("/page")
  public String page(@RequestBody String body, HttpServletResponse response) {
    JSONObject result = new JSONObject();
    JSONArray array = null;
    List<?> pageInfo = null;
    long selectCount = 0;
    long sum = 0;
    try {
      String urlDecoderString = sqlUtil.getURLDecoderString(body);
      System.out.println("=====applicationInfo的添加转码URL=====" + urlDecoderString);
      if (urlDecoderString.indexOf(sqlStr) != -1 && urlDecoderString.indexOf(sqlStr1) != -1) {
        String substring = urlDecoderString.substring(0, urlDecoderString.indexOf("&countSql="));
        String substring1 = urlDecoderString.substring(urlDecoderString.indexOf("&countSql=") + 1, urlDecoderString.length());
        String sql = substring.replaceAll("sql=", "");
        String countSql = substring1.replaceAll("countSql=", "");
        String sumSql = "select count(*) from ";
        if (sql.indexOf(table1) != -1) {
          sumSql += table1;
          pageInfo = applicationInfoService.getPageInfo(sql);
          selectCount = applicationInfoService.getSelectCount(countSql);
          sum = applicationInfoService.getSelectCount(sumSql);
        }
        if (sql.indexOf(table2) != -1) {
          sumSql += table2;
          pageInfo = clientInfoService.getPageInfo(sql);
          selectCount = clientInfoService.getSelectCount(countSql);
          sum = clientInfoService.getSelectCount(sumSql);
        }
        if (sql.indexOf(table3) != -1) {
          sumSql += table3;
          pageInfo = creditAuthService.getPageInfo(sql);
          selectCount = creditAuthService.getSelectCount(countSql);
          sum = creditAuthService.getSelectCount(sumSql);
        }
        array = JSONArray.fromObject(pageInfo);
        //表中总条数
        result.put("sum", sum);
        //满足条件的总条数
        result.put("selectCount", selectCount);
        //满足条件的返回数据
        result.put("data", array);
        System.out.println("===获得SQL语句===" + sql);
      } else {
        result.put("error", "查询的语句不符合规范！！！");
      }

    } catch (Exception e) {
      exceptionInfoCollertUtil.errorOutput(response, result, e);
      e.printStackTrace();
    }
    ResponseUtil.write(response, result);
    return null;
  }
}

