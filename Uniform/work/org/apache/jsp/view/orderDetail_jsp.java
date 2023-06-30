/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.32
 * Generated at: 2023-06-28 08:52:13 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import bean.Order;
import util.MyFormat;

public final class orderDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("util.MyFormat");
    _jspx_imports_classes.add("bean.Order");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	ArrayList<Order> order_list = (ArrayList<Order>) request.getAttribute("order_list");
	MyFormat format = new MyFormat();
	int total = 0;
	for (int i = 0; i < order_list.size(); i++) {
		total += order_list.get(i).getPrice() * order_list.get(i).getQuantity();
	}

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>注文詳細情報</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<!-- ヘッダー部分 -->\r\n");
      out.write("\t<div style=\"margin-top: 30px\">\r\n");
      out.write("\t\t<h1 style=\"text-align: center;\">ユニフォーム受注管理システム</h1>\r\n");
      out.write("\t\t<hr\r\n");
      out.write("\t\t\tstyle=\"text-align: center; background-color: green; width: auto; height: 5px\">\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<!-- 注文詳細情報コンテンツ部分 -->\r\n");
      out.write("\t\r\n");
      out.write("\t\t<h2 style=\"text-align: center\">\r\n");
      out.write("\t\t\t<font>注文状況詳細</font>\r\n");
      out.write("\t\t</h2>\r\n");
      out.write("\t\t<!-- ナビゲーション  -->\r\n");
      out.write("\t\t<a style=\"margin-top: 50px; margin-left: 50px;\"\r\n");
      out.write("\t\t\thref=\"");
      out.print(request.getContextPath());
      out.write("/orderList\">[受注状況一覧へ戻る]</a> <a\r\n");
      out.write("\t\t\tstyle=\"margin-top: 50px; margin-left: 50px;\"\r\n");
      out.write("\t\t\thref=\"");
      out.print(request.getContextPath());
      out.write("/view/adminMenu.jsp\">[管理者メニューへ戻る]</a>\r\n");
      out.write("\t\t<a style=\"margin-top: 50px; margin-left: 50px;\"\r\n");
      out.write("\t\t\thref=\"");
      out.print(request.getContextPath());
      out.write("/logout\">[ログアウト]</a>\r\n");
      out.write("\r\n");
      out.write("\t\t<hr style=\"height: 2; background-color: green;\" />\r\n");
      out.write("\t\r\n");
      out.write("\t<div style=\"margin: auto; width: 600px\">\r\n");
      out.write("\t\t<form action=\"");
      out.print(request.getContextPath());
      out.write("/payment\" id=\"payment\"\r\n");
      out.write("\t\t\tid=\"send\">\r\n");
      out.write("\t\t\t<table border=\"1\" style=\"width: 400px; margin:0 auto\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t");

					if (order_list != null) {
						for (int i = 0; i < 1; i++) {
							Order order = (Order) order_list.get(i);
				
      out.write("\r\n");
      out.write("\t\t\t\t<tr style=\"text-align:center\">\r\n");
      out.write("\t\t\t\t\t<th>No.</th>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(order.getOrderid());
      out.write("</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<tr style=\"text-align:center\">\r\n");
      out.write("\t\t\t\t\t<th>氏名</th>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(order.getName());
      out.write("</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<tr  style=\"text-align:center\">\r\n");
      out.write("\t\t\t\t\t<th>Mail</th>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(order.getEmail());
      out.write("</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<tr style=\"text-align:center\">\r\n");
      out.write("\t\t\t\t\t<th>住所</th>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(order.getAddress());
      out.write("</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t");

					}
					}
				
      out.write("\r\n");
      out.write("\t\t\t\t<tr style=\"text-align:center\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<th rowspan=\"");
      out.print(order_list.size());
      out.write("\" >購入内容</th>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t");

					for(int i=0; i < order_list.size();i++){
						Order order = (Order) order_list.get(i);

					
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align:center\">");
      out.print(order.getUniformType());
      out.write('×');
      out.print(order.getQuantity());
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("\t\t\t\t\t");

					}
						
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t");

					for (int i = 0; i < 1; i++) {
						Order order = (Order) order_list.get(i);
				
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<tr style=\"text-align:center\">\r\n");
      out.write("\t\t\t\t\t<th>会計金額</th>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(order.getPrice());
      out.write("</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<tr style=\"text-align:center\">\r\n");
      out.write("\t\t\t\t\t<th>発注日</th>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(order.getDate());
      out.write("</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<tr style=\"text-align:center\">\r\n");
      out.write("\t\t\t\t\t<th>入金状況</th>\r\n");
      out.write("\t\t\t\t\t<td>");
if(order.getPayment().equals("入金済み")){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<select name=\"payment\" id=\"payment\">\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"入金済み\">入金済み</option>\r\n");
      out.write("\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t");
}else if(order.getPayment().equals("入金待ち")){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<select name=\"payment\" id=\"payment\">\r\n");
      out.write("\t\t\t\t\t\t\t<option>");
      out.print(order.getPayment());
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"入金済み\">入金済み</option>\r\n");
      out.write("\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t");
}
      out.write("\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<tr style=\"text-align:center\">\r\n");
      out.write("\t\t\t\t\t<th>発送状況</th>\r\n");
      out.write("\t\t\t\t\t<td>");
if(order.getSend().equals("発送済み")){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<select name=\"payment\" id=\"payment\">\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"発送済み\">発送済み</option>\r\n");
      out.write("\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t");
}else if(order.getSend().equals("発送準備中")){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<select name=\"send\" id=\"send\">\r\n");
      out.write("\t\t\t\t\t\t\t<option>");
      out.print(order.getSend());
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"発送済み\">発送済</option>\r\n");
      out.write("\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t");
}else if(order.getSend().equals("未発送")) {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<select name=\"send\" id=\"send\">\r\n");
      out.write("\t\t\t\t\t\t\t<option>");
      out.print(order.getSend());
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"発送済み\">発送済</option>\r\n");
      out.write("\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<tr style=\"text-align:center\">\r\n");
      out.write("\t\t\t\t\t<th>備考欄</th>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(order.getMessage());
      out.write("</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");

					}
				
      out.write("\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t<div style=\"width: 950px; text-align: left; margin-left: 300px; margin-top: 30px\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"name\"value=\"");
      out.print(order_list.get(0).getName());
      out.write("\">\r\n");
      out.write("\t\t\t\t <input type=\"hidden\" name=\"orderTime\" value=\"");
      out.print(order_list.get(0).getOrderTime());
      out.write("\">\r\n");
      out.write("\t\t\t\t");

					for (int i = 0; i < 1; i++) {
						Order order = (Order) order_list.get(i);
						if (order.getSend().equals("未発送") || order.getSend().equals("発送準備中")) {
				
      out.write("\r\n");
      out.write("\t\t\t\t<input type=\"submit\" value=\"更新\">\r\n");
      out.write("\t\t\t\t");

					}
					}
				
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div style=\"margin: 50 auto; width: 50\"></div>\r\n");
      out.write("\r\n");
      out.write("\t<!-- フッター部分 -->\r\n");
      out.write("\t<p style=\"margin-bottom: 80px;\"></p>\r\n");
      out.write("\t<hr\r\n");
      out.write("\t\tstyle=\"text-align: center; background-color: green; width: auto; height: 5px\">\r\n");
      out.write("\t<table\r\n");
      out.write("\t\tstyle=\"margin: auto; width: 950px; text-align: left; margin-bottom: 80px;\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>copyright (c) 2023 all rights reserved.</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}