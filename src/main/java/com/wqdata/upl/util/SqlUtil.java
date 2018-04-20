package com.wqdata.upl.util;

import net.sf.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;

/**
 * com.wqdata.upl.util
 * 作者      : 陈晓
 * 描述      :
 * 创建日期  : 2018/3/7
 * 修改日期  :
 */
public class SqlUtil {

  private final static String ENCODE = "UTF-8";

  private String primaryKeyValue;


  /**
   * 获得添加SQL
   *
   * @param s
   * @return
   */
  public String getAddSql(String s, StringBuilder sb, String primaryKey) {
    String fieldName = s.substring(s.indexOf("=") + 1, s.indexOf("&")).trim();
    String str = s.substring(s.indexOf("{"), s.indexOf("}") + 1);
    if (str.indexOf(primaryKey) != -1) {
      sb.append(fieldName + ") values(");
      System.out.println(str);
      JSONObject result = JSONObject.fromObject(str);
      Iterator it = result.keys();
      while (it.hasNext()) {
        String key = (String) it.next();
        System.out.println("key:" + key);
        String value = result.get(key).toString();
        if (primaryKey.equals(key)) {
          if (StringUtil.isEmpty(value)) {//主键为空添加失败
            return null;
          }
          setPrimaryKeyValue(value);
        }
        if (isInteger(key))//判断字段是否为整型
          //sb.append(key + " = " + value + ",");
          sb.append(value + ",");
        else
          sb.append("'" + value + "'" + ",");
      }
      System.out.println("=========" + sb.toString());
      // sb.deleteCharAt(sb.length() - 1);
      String substring = sb.substring(0, sb.length() - 1) + ")";
      //sb.append(")");
      System.out.println("===applicationAdd SQL语句===" + substring);
      return substring;
    }
    return null;
  }

  /**
   * 获得数据的SQL语句
   *
   * @param s          POST提交的URL
   * @param sb         sql的拼接
   * @param primaryKey 更新主键字段
   * @param flag       是否进行整型判断
   * @return
   */
  public String getUpdateSql(String s, StringBuilder sb, String primaryKey, boolean flag) {
    //StringBuilder sb = new StringBuilder("update t_application_info set ");
    String str = s.substring(s.indexOf("{"), s.indexOf("}") + 1);
    System.err.println("====getUpdateSql====" + str);
    if (str.indexOf(primaryKey) != -1) {
      JSONObject result = JSONObject.fromObject(str);
      Iterator it = result.keys();
      while (it.hasNext()) {
        String key = (String) it.next();
        System.out.println("key:" + key);
        String value = result.get(key).toString();
        if (primaryKey.equals(key)) {
          //若是主键进行操作
          continue;
        } else {
          if (flag) {//用于区分applicationInfo表和其他表
            if (isInteger(key))//判断是否为整型，是不用添加双引号，否则添加
              sb.append(key + " = " + value + ",");
            else
              sb.append(key + " = " + "'" + value + "'" + ",");
          } else {
            sb.append(key + " = " + "'" + value + "'" + ",");
          }
        }
      }
      //删除最后一个逗号(,)
      sb.deleteCharAt(sb.length() - 1);
      //sb.append(" where " + primaryKey + " = " + "'" + result.get(primaryKey) + "'" + ";");
      //ORACLE数据进行更新时候,不能添加";"为结束符(尚未弄清其原因)
      sb.append(" WHERE " + primaryKey + " = " + "'" + result.get(primaryKey) + "'");
      return sb.toString();
    }
    return null;
  }


  /**
   * 获得查询SQL
   *
   * @param s
   * @return
   */
  public String getSelectSql(String s, StringBuilder sb, String tableName) {
    String fieldName = s.substring(s.indexOf("=") + 1, s.indexOf("&"));
    String str = s.substring(s.indexOf("{"), s.indexOf("}") + 1);
    sb.append("select " + fieldName + "  from " + tableName + " where ");
    //sb.append("select * from "+tableName+" where ");
    System.out.println(sb.toString());
    System.out.println("====getSelectSql====" + str);
    net.sf.json.JSONObject result = net.sf.json.JSONObject.fromObject(str);
    Iterator it = result.keys();
    String sql = getSql(it, result, sb);
    return sql;
  }

  /**
   * 获得sql条件
   *
   * @param it
   * @param result
   * @param sb
   * @return
   */
  private String getSql(Iterator it, JSONObject result, StringBuilder sb) {
    Integer i = 0;
    while (it.hasNext()) {
      String key = (String) it.next();
      System.out.println("key:" + key);
      String value = result.get(key).toString();
      if (StringUtil.isEmpty(value))
        continue;
      else if (i == 0) {
        String judge = judge(value);
        sb.append(key + judge);
      } else {
        String judge = judge(value);
        sb.append(" and " + key + judge);
      }
      i++;
    }
    System.out.println(sb.toString() + " ;");
    return sb.toString();
  }

  /**
   * 判断是否存在%
   *
   * @param value
   * @return
   */
  private String judge(String value) {
    if (value.toString().indexOf("%") != -1)
      return " LIKE " + "'" + value + "'";
    else
      return " = " + "'" + value + "'";
  }

  /**
   * 判断是否字段是否是整型
   *
   * @param str
   * @return
   */
  private static boolean isInteger(String str) {
    String s = "ISSERIALNO,MOBILETELEPHONE,OPERATEUSERID,BUSINESSTYPE,BUSINESSSUM,TERMMONTH,MONTHINCOME,INPUTORGID,INPUTUSERID,CYCLETIME,STATUS,";
    if (s.indexOf(str) != -1)
      return true;
    else
      return false;
  }

  /**
   * URL 解码
   *
   * @param str
   * @return String
   */
  public static String getURLDecoderString(String str) {
    String result = "";
    if (null == str) {
      return "";
    }
    try {
      result = java.net.URLDecoder.decode(str, ENCODE);
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return result;
  }

  public String getPrimaryKeyValue() {
    return primaryKeyValue;
  }

  public void setPrimaryKeyValue(String primaryKeyValue) {
    this.primaryKeyValue = primaryKeyValue;
  }

  public static void main(String[] args) {
    boolean businesstype = isInteger("BUSINESSTYPE");
    System.out.println(businesstype);
  }
}
