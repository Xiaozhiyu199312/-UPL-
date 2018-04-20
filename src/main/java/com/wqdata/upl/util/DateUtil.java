package com.wqdata.upl.util;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * com.wqdata.upl.util
 * 作者      : 陈晓
 * 描述      :
 * 创建日期  : 2018/3/7
 * 修改日期  :
 */
public class DateUtil extends PropertyEditorSupport {

  public static String formatDate(Date date, String format) {
    String result = "";
    SimpleDateFormat sdf = new SimpleDateFormat(format);
    if (date != null) {
      result = sdf.format(date);
    }
    return result;
  }

  public static Date formatString(String str, String format) {
    if (StringUtil.isEmpty(str)) {
      return null;
    }
    SimpleDateFormat sdf = new SimpleDateFormat(format);
    try {
      return sdf.parse(str);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static String getCurrentDateStr() throws Exception {
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");
    return sdf.format(date);
  }

  @Override
  public void setAsText(String text) throws IllegalArgumentException {
    super.setAsText(text);
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = null;
    try {
      date = format.parse(text);
    } catch (ParseException e) {
      format = new SimpleDateFormat("yyyy-MM-dd");
      try {
        date = format.parse(text);
      } catch (ParseException e1) {
        e1.printStackTrace();
      }
    }
    setValue(date);
  }
}
