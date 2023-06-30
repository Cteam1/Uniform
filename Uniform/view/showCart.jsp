<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.*,util.*"%>

<%


	MyFormat obj = new MyFormat();

	ArrayList<MultiBuy> cart_list = (ArrayList<MultiBuy>) request.getAttribute("multiBuyList");
	ArrayList<Uniform> uniform_list = (ArrayList<Uniform>) request.getAttribute("uniform_list");
	int sum = 0;

%>

<html>

<head>

<title>showCart</title>

</head>
<body>

	<%@include file="/common/header.jsp"%>


<table style="margin: 0 auto">
		<tr>
			<td style="text-align: center">
				<a href="<%=request.getContextPath()%>/view/guestMenu.jsp">【購入者メニューに戻る】</a>
			</td>
			<td style="text-align: center; width: 508px; font-size: 24px">カート内容</td>
			<td style="width: 160px"></td>
		</tr>
	</table>



	<hr style="height: 2; background-color:blue">
	<br>
	<div style="text-align: center">

		<table style="margin: 0 auto" border="1">
			<tr>
				<th style="background-color: #6666FF; width: 100">No.</th>
				<th style="background-color: #6666FF; width: 350px">商品名</th>
				<th style="background-color: #6666FF; width: 100">個数</th>
				<th style="background-color: #6666FF; width: 100">金額</th>
				<th style="background-color: #6666FF; width: 100">削除</th>
			</tr>
			<%
				if (cart_list != null) {
					for (int i = 0; i < cart_list.size(); i++) {
						for(int j = 0;j < uniform_list.size();j++){
			%>
			<tr style="text-align: center">
				<%
						if(cart_list.get(i).getUniformid().equals(uniform_list.get(j).getUniformid())){
				%>
				<td><%= i + 1 %></td>
				<td><%= uniform_list.get(j).getUniformType() %></td>
				<td><%= cart_list.get(i).getQuantity() %></td>
				<td><%= obj.moneyFormat(cart_list.get(i).getQuantity() * uniform_list.get(j).getPrice()) %></td>
				<td><a href="<%= request.getContextPath() %>/showCart?delno=<%= i %>">削除</a></td>

			<%
							sum += cart_list.get(i).getQuantity() * uniform_list.get(j).getPrice();
							}
						}
					}
				}
			%>
			</tr>
		</table>

		<br>

		<table style="margin: 0 auto">
		<tr>
			<th style="background-color: #6666FF; width: 100">合計金額</th>
			<td style="text-align: center; width: 100"><%= obj.moneyFormat(sum) %></td>
		</tr>
	</table>

	</div>
	<br>
		<div style="text-align: center">

	<hr style="height: 2; background-color:blue">
		<a style="font-size: 24px">購入者情報入力</a>
	<hr style="height: 2; background-color:blue">
		<br>

		<form action="<%= request.getContextPath() %>/orderForm" method="post">

		<table style="margin: 0 auto" border="1">
			<tr>
				<th style="background-color: #6666FF; width: 150">名前</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th style="background-color: #6666FF; width: 150">メールアドレス</th>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<th style="background-color: #6666FF; width: 150">住所</th>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<th style="background-color: #6666FF; width: 150">電話番号</th>
				<td><input type="text" name="telNumber"></td>
			</tr>
			<tr>
				<th style="background-color: #6666FF; width: 150">備考欄<br>(200文字まで)</th>
				<td><textarea name="message" rows="10"  cols="22" maxlength="200"></textarea></td>
			</tr >
		</table>
		<br>
		<input type="submit" value="購入確定">
		</form>

		</div>


	<%@include file="/common/footer.jsp"%>

</body>
</html>
