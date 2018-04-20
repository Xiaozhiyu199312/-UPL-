package com.wqdata.upl.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseUtil {

	public static void write(HttpServletResponse response, Object o) {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.println(o.toString());
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
