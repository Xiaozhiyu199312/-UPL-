package com.wqdata.upl.util;


import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletResponse;

/**
 * com.wqdata.upl.util
 * 作者      : 陈晓
 * 描述      : 用于精确定位异常信息的发生的地址
 * 创建日期  : 2018/3/8
 * 修改日期  :
 */
public class ExceptionInfoCollertUtil {

  /**
   * 获得异常信息
   *
   * @return
   */
  public String getTraceInfo() {
    StringBuffer stringBuffer = new StringBuffer();
    StackTraceElement[] stacks = new Throwable().getStackTrace();
    stringBuffer.append("Exception in [class: ")
            .append(stacks[1].getClassName()).append("][method: ")
            .append(stacks[1].getMethodName()).append("][line: ")
            .append(stacks[1].getLineNumber() + "]");
    return stringBuffer.toString();
  }

  /**
   * 返回异常信息
   *
   * @param response
   * @param result
   * @param e
   * @return
   */
  public String errorOutput(HttpServletResponse response, JSONObject result, Exception e) {
    try {
      result.put("error", "===错点类型===" + e.getCause().getClass() +  "  ===错点信息===" + e.getCause().getMessage());
    } catch (Exception e1) {
      e1.printStackTrace();
    }
    ResponseUtil.write(response, result);
    return null;
  }
}
