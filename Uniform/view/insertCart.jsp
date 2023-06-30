
<%@page import="java.util.ArrayList,bean.*,dao.*"%>
<%@page contentType= "text/html; charset=UTF-8" %>

<%
UniformDAO uniformDao = new UniformDAO();
ArrayList<MultiBuy> tempList = (ArrayList<MultiBuy>)request.getAttribute("tempList");
ArrayList<Uniform> uniform_list = uniformDao.selectAll();
%>

<html>
	<head>
		<title>カート追加確認</title>
	</head>

	<body>

		<%@ include file="/common/header.jsp"%>
		<!-- 各機能へのリンク -->
		<table style="margin: auto; width: 850px; text-align: center;">
		<tr>
			<td style="width: 160px">
				<a href="<%=request.getContextPath()%>/guestMenu">【購入者メニュー】</a>
			</td>
			<td style="width: 508px; font-size: 24px">カート追加確認</td>
			<td style="width: 160px"></td>
		</tr>
	</table>
	<hr style="text-align: center; background-color: blue; width:auto; height: 5px">
	<br>
	<br>

		<!-- カートに入れた書籍を示すテーブル -->
		<div style= "text-align:center">

		<h3>下記の商品をカートに追加しました。</h3>
		<table style="margin:0 auto; text-align:center;" border="1">
			<% if (tempList != null) {
				for (int i = 0; i < tempList.size(); i++) {
					for(int j = 0;j < uniform_list.size();j++){ %>
			<tr>
				<%
					if (tempList.get(i).getQuantity() > 0) {

						if(tempList.get(i).getUniformid().equals(uniform_list.get(j).getUniformid())){
				%>
				<th style="background-color: #dcdcdc; width: 150"><%= uniform_list.get(j).getUniformType() %></th>
				<td style="width: 150"><%=tempList.get(i).getQuantity()%>&nbsp;着</td>
				<%

								}
							}
						}
					}
				}
			%>
			</tr>
		</table>
		<br>
		<br>
		<form action="<%= request.getContextPath() %>/showCart">
				<input type="submit" value="カート確認">
		</form>
		</div>

		<%@ include file="/common/footer.jsp"%>


	</body>
</html>
