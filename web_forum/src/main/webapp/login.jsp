<%@page contentType="text/html" pageEncoding="UTF-8"%>



<style type="text/css">
.article-meta-info span  {
	color: red;
}
.header-tool-btn a {
	color: green;
}
div {
	background: ivory;
	padding: 10px;
}
</style>

<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/gossip.css" type="text/css">
	<title>會員登入</title>
</head>
<body>
	<header>
		<h1><a class="logo" href="//www.forum.com">We will progress!</a></h1>
		<img src="../image/alpaca.png" width="144" height="256">
	</header>
	
	<div>
    	<h1>會員登入</h1>
		<form method='post' action='login'>
			<div>
				<input type='login' name='login-email-or-name' size='25' maxlength='100' placeholder="輸入電子信箱／使用者名稱">
				
			</div>
			<div>
				<input type='password' name='password' size='25' maxlength='16' placeholder="輸入密碼（8 到 16 字元）">
				
			</div>
			<div>
				<input type='submit' name="btn-login" value='登入'>
				
			</div>
			<div>
				<button type="button" name="btn-redirect-to-register">尚未註冊？</button>
				
			</div>
		</form>
	</div>

	<footer>
		Copyright © 2020 Progress, Inc. All rights reserved
	</footer>
</body>
</html>