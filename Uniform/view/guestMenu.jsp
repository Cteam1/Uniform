<%@page import="bean.MultiBuy"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.Order"%>

<%
//セッションからユーザー情報を取得
ArrayList<MultiBuy> multiBuys = (ArrayList<MultiBuy>)session.getAttribute("multiBuyList");
//セッション切れか確認
if(multiBuys == null){
	// セッション切れならerror.jspへフォワード
	request.setAttribute("error","セッション切れの為、メニュー画面が表示できませんでした。");
	request.setAttribute("cmd","menu");
	request.getRequestDispatcher("/view/error.jsp").forward(request, response);
	return;
}
%>

<html>

<head>

<title>購入者メニュー</title>

</head>
<body>

	<%@include file="/common/header.jsp"%>


	<table style="margin: auto; width: 850px; text-align: center;">
		<tr>
			<td style="width: 160px">
				<a href="<%=request.getContextPath()%>/view/menu.jsp">【メインメニュー】</a>
			</td>
			<td style="width: 508px; font-size: 24px">購入者メニュー</td>
			<td style="width: 160px"></td>
		</tr>
	</table>
	<hr style="text-align: center; background-color: blue; width:auto; height: 5px">
	<br>
	<br>
	<div style="text-align: center">


		<p><a href="<%= request.getContextPath() %>/uniformList">【商品一覧】</a></p>
		<p><a href="<%= request.getContextPath() %>/showCart">【カート一覧】</a></p>

	</div>

	<%@include file="/common/footer.jsp"%>

</body>
</html>
