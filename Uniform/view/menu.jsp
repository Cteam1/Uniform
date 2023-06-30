<%@page import="bean.MultiBuy"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>メインメニュー</title>
</head>
<body>
	<%@ include file="/common/header.jsp" %>

	<table style="margin: auto; width: 850px">
		<tr style="text-align: center;">
			<td style="font-size: 24px">メインメニュー</td>
		</tr>
	</table>
	<hr style="text-align: center; background-color: blue; width:auto; height: 5px">
	<br>
	<br>

	<p style="text-align: center;"><a href="<%=request.getContextPath() %>/guestMenu">【購入者メニューへ】</a></p>
	<p style="text-align: center;"><a href="<%=request.getContextPath() %>/view/login.jsp">【管理者ログインへ】</a></p>



	<%@ include file="/common/footer.jsp" %>
</body>
</html>
