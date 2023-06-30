<%@page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<meta charset="UTF-8">
<title>購入確認画面</title>
</head>
<body>
<header>
	<%@ include file="/common/header.jsp" %>
</header>
	<h2 style="margin:0 auto;width: 250px; height: 50px; margin-top: 30px;">購入確認画面</h2>
	<p><a href="<%=request.getContextPath()%>/view/guestMenu.jsp">【購入者メニューに戻る】</a></p>
	<hr style="text-align: center; background-color: blue; width: auto; height: 2px">

	<h2 style="margin:0 auto;width: 400px; height: 50px; margin-top: 30px;">ご注文ありがとうございます。</h2>
	<h2 style="margin:0 auto;width: 450px; height: 50px; margin-top: 30px;">ご入金をよろしくお願いいたします。</h2>

	<hr style="text-align: center; background-color: blue; width: auto; height: 2px">
	<h1 style="height: 50px"></h1>

<footer>
	<%@ include file="/common/footer.jsp" %>
</footer>
</body>
</html>
