<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.Order,util.*"%>

<%
	MyFormat obj = new MyFormat();

	ArrayList<Order> order_list = (ArrayList<Order>) request.getAttribute("order_list");
	ArrayList<Order> order_list_group = (ArrayList<Order>) request.getAttribute("order_list_group");
%>

<html>

<head>

<title>受注一覧</title>

</head>
<body>

<%@ include file="/common/header2.jsp"%>
	<h2 style="text-align: center">
		<font>注文状況一覧</font>
	</h2>

	<a style="margin-top: 50px; margin-left: 50px;"
		href="<%=request.getContextPath()%>/view/adminMenu.jsp">[管理者メニューへ戻る]</a>
	<a style="margin-top: 50px; margin-left: 50px;"
		"
		href="<%=request.getContextPath()%>/logout">[ログアウト]</a>

	<hr style="height: 2; background-color: green;" />


	<div style="text-align: center">

		<table style="margin: 0 auto">
			<tr>
				<th style="background-color: green; width: 300">No.</th>
				<th style="background-color: green; width: 300">氏名</th>
				<th style="background-color: green; width: 300">合計金額</th>
				<th style="background-color: green; width: 300">発注日</th>
				<th style="background-color: green; width: 300">入金状況</th>
				<th style="background-color: green; width: 300">発注状況</th>
				<th style="background-color: green; width: 300"></th>
			</tr>
			<%
				if (order_list != null) {
					for (int i = 0; i < order_list_group.size(); i++) {
			%>
			<tr style="text-align: center">
				<td><%=order_list.size() - i%></td>
				<td><%=order_list_group.get(i).getName()%></td>
				<td>
					<%
						int total = 0;
								for (int j = 0; j < order_list.size(); j++) {
									if (order_list_group.get(i).getDate().equals(order_list.get(j).getDate())
											&& order_list_group.get(i).getOrderTime().equals(order_list.get(j).getOrderTime())) {
										total += order_list.get(j).getPrice() * order_list.get(j).getQuantity();
									}
								}
					%> <%=obj.moneyFormat(total)%>
				</td>
				<td><%=order_list_group.get(i).getDate()%></td>
				<td><%=order_list_group.get(i).getPayment()%></td>
				<td><%=order_list_group.get(i).getSend()%></td>
				<td><a
					href="<%=request.getContextPath()%>/orderDetail?name=<%=order_list_group.get(i).getName()%>&order_time=<%=order_list_group.get(i).getOrderTime()%>">詳細</a></td>
			</tr>
			<%
				}
				}
			%>
		</table>

	</div>

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
