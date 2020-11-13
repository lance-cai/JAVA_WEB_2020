<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
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


<head>
	<title>new-post</title>
</head>
<body>
	<header>
		<div>
			<a class="logo" href="//www.progress.com">We will progress!</a>
			<span><a href="login.jsp">login-status</a></span>
			<img src="../image/alpaca.png" width="144" height="256">
		</div>
		<div class="header-tool-btn"> 
			<a href="search.jsp">search</a>
			<a href="new-post.jsp">ask</a>
			<a href="my-questions.jsp">my questions</a>
		</div>
	</header>
	
	<div>
		<form method="post" action="new-post">
			<div><input type="text" name="add-title-bar" placeholder="新增文章標題..."></div>
			<div><input type="text" name="add-contents-bar" placeholder="想問些什麼？"></div>
			<div><input type="text" name="add-tags-bar" placeholder="新增主題標籤，幫助你更快找到相關的解答！" size="100px"></div>
			<div>
				<span><a href="home.html">取消</a></span>
				<span><input type="submit" name="confirm-btn" value="發布"></span>
			</div>
		</form>
	</div>



	<footer>
		Copyright © 2020 Progress, Inc. All rights reserved
	</footer>
</body>
</html>