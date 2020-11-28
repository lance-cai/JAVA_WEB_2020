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
table {
	border: 2px box rgb(190, 190, 190)
}
td,
th {
    border: 1px solid rgb(190, 190, 190);
    padding: 10px;
}

</style>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/gossip.css" type="text/css">
	<title>會員註冊</title>
</head>
<body>
	<header>
		<div>
			<a class="logo" href="//www.forum.com">We will progress!</a>
			<span><a href="login.html">login-status</a></span>
			<img src="../image/alpaca.png" width="144" height="256">
		</div>
		<div>
			<a class="header-tool-btn" href="search.html">search</a>
			<a class="header-tool-btn" href="new-post.html">ask</a>
			<a class="header-tool-btn" href="my-questions.html">my questions</a>
		</div>
	</header>
	
	<div>
	    <h1>會員註冊</h1>
		<form method='post' action='register'>
			<div>
				<input type='text' name='email' size='25' maxlength='100' placeholder="輸入電子信箱">
				
			</div>
			<div>
				<input type='text' name='username' size='25' maxlength='16' placeholder="輸入使用者名稱（最大 16 字元）">
				
			</div>
			<div>
				<input type='password' name='password' size='25' maxlength='16' placeholder="輸入密碼（8 到 16 字元）">
				
			</div>
			<div>
				<input type='password' name='password2' size='25' maxlength='16' placeholder="確認密碼：">
				
			</div>
			<div>
				<input type='submit' value='註冊'>
				
			</div>
		</form>
	</div>

	<footer>
		Copyright © 2020 Progress, Inc. All rights reserved
	</footer>
</body>
</html>