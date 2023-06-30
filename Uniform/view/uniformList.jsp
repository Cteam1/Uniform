<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList, bean.Uniform,util.*"%>

<%
	MyFormat obj = new MyFormat();
	ArrayList<Uniform> uniform_list = (ArrayList<Uniform>) request.getAttribute("uniform_list");
%>

<html>
<head>
<title>商品一覧</title>
</head>

<body>

	<%@include file="/common/header.jsp"%>

	<table style="margin: auto; width: 850px; text-align: center;">
		<tr>
			<td style="width: 160px">
				<a href="<%=request.getContextPath()%>/view/guestMenu.jsp">【購入者メニュー】</a>
			</td>
			<td style="width: 508px; font-size: 24px">商品一覧</td>
			<td style="width: 160px"></td>
		</tr>
	</table>
	<hr style="text-align: center; background-color: blue; width:auto; height: 5px">
	<br>
	<br>
	<div style="margin: 0 auto; width: 1000">
		<form action="<%=request.getContextPath()%>/insertCart">
		<table border="2" style="margin: 0 auto; margin-bottom:10px">

		<tr>
		<th>ユニフォームA</th>
		<th>ユニフォームB</th>
		<th>ユニフォームC</th>
		</tr>
		<tr>
		<td><img src="<%= request.getContextPath() %>/pic/uniformA.jpg" alt="A"></td>
		<td><img src="<%= request.getContextPath() %>/pic/uniformB.jpg" alt="B"></td>
		<td><img src="<%= request.getContextPath() %>/pic/uniformC.jpg" alt="C"></td>
		</tr>

		</table>
			<table border="1">
				<tr>
					<th style="background-color: #dcdcdc; width: 300">種類</th>
					<th style="background-color: #dcdcdc; width: 300">価格</th>
					<th style="background-color: #dcdcdc; width: 300">在庫数</th>
					<th style="background-color: #dcdcdc; width: 100">購入数</th>
				</tr>
				<%
					if (uniform_list != null) {
						for (int i = 0; i < uniform_list.size(); i++) {
				%>

				<tr>
					<td style="text-align: center"><%=uniform_list.get(i).getUniformType()%></td>
					<td style="text-align: center"><%=obj.moneyFormat(uniform_list.get(i).getPrice())%></td>
					<td style="text-align: center"><%=uniform_list.get(i).getStock()%></td>
					<td>
						<input type="text" name="quantity<%=i%>" value="0">
						<input type="hidden" name="uniform<%=i%>" value="<%=uniform_list.get(i).getUniformid()%>">
					</td>
				</tr>

				<%
					}
					}
				%>

			</table>

			<input type="submit" value="カートに追加"
				style="margin: 30 460; width: 100">
		</form>
	</div>

	<%@include file="/common/footer.jsp"%>

</body>
</html>