package com.wqdata.upl.util;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * com.nytalk.ssm.util
 * 作者      : 陈晓
 * 描述      : list中的日期类型转化为JsonObject输出到页面
 * 创建日期  : 2017/12/13
 * 修改日期  :
 */
public class JsonDateValueProcessor implements JsonValueProcessor {

  // 定义转换日期类型的输出格式
  private String format = "yyyy-MM-dd";

  public JsonDateValueProcessor() {

  }

  public JsonDateValueProcessor(String format) {
    this.format = format;
  }

  public Object processArrayValue(Object o, JsonConfig jsonConfig) {
    return o;
  }

  public Object processObjectValue(String s, Object o, JsonConfig jsonConfig) {
    if (o instanceof Date) {
      String str = new SimpleDateFormat(format).format((Date) o);
      return str;
    }
    if (null != o) {
      return o.toString();
    }
    return "";
  }
}
