<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.Order"%>

<html>

<head>

<title>管理者メニュー</title>

</head>
<body>

<%@ include file="/common/header2.jsp"%>

	<h2 style="text-align: center">
		<font>管理者メニュー</font>
	</h2>

	<hr style="height: 2; background-color: green;" />

	<ul style="text-align: center; list-style: none; padding: 0;">
		<li style="padding-top: 30px;"><a
			href="<%=request.getContextPath()%>/orderList">【注文一覧】</a></li>
		<li style="padding-top: 30px;"><a
			href="<%=request.getContextPath()%>/view/menu.jsp">【メニュー画面へ】</a></li>
	</ul>

	<p style="margin-bottom: 80px;"></p>
	<hr
		style="text-align: center; background-color: green; width: auto; height: 5px">
	<table
		style="margin: auto; width: 950px; text-align: left; margin-bottom: 80px;">
		<tr>
			<td>copyright (c) 2023 all rights reserved.</td>
		</tr>
	</table>

</body>
</html>