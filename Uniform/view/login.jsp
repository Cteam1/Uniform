<%@ page contentType="text/html; charset=UTF-8"%>
<%
String message =(String)request.getAttribute("message");
%>

<html>
<head>
<title>ユニフォーム受注管理システム</title>
</head>
<body>
	<!-- ここでヘッダー読み込み -->
	<%@ include file="/common/header2.jsp"%>

	<div style="margin: 50 auto;">
		<h2 style="text-align: center">
			<font>管理者ログイン</font>
		</h2>
		<!-- ナビゲーション  -->
			<a style="margin-top: 50px; margin-left: 50px;" href="<%=request.getContextPath()%>/view/menu.jsp">[メニュー画面へ戻る]</a>
			<a style="margin-top: 50px; margin-left: 50px;" href="<%=request.getContextPath()%>/logout">[ログアウト]</a>

		<hr style="height: 2; background-color:green;" />
	</div>

	<div style="margin-top:50px;">
		<form action="<%=request.getContextPath()%>/login" method="post">
			<table style="margin: auto;">
				<tr>
					<td style="text-align: center; background-color: #6495ed; width: 100px">管理者ID</td>
					<td><input type="text" name="admin" size="30"></input></td>
				</tr>
				<tr>
					<td style="text-align: center; background-color: #6495ed;">パスワード</td>
					<td><input type="password" name="pass" size="30"></input></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;">
					<input	type="submit" value="ログイン"></input></td>
				</tr>
			</table>
		</form>
	</div>
	<!-- ここでフッダー読み込み -->
	<p style=" margin-bottom: 80px;"></p>
	<hr style="text-align: center; background-color: green; width: auto; height: 5px">
	<table style="margin: auto; width: 950px; text-align: left; margin-bottom: 80px;">
	<tr>
		<td>copyright (c) 2023 all rights reserved.</td>
	</tr>
</table>
</body>
</html>
