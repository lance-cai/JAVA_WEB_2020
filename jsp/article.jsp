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
	<title class="article-name"></title>
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
		<div class="user-name">Miochael</div>
		<div class="title">This is a sample Title</div>
		<div class="tags">ad, as, lksdf</div>
		<div class="article-meta-info">
			<span class="article-view"><img src="/image/view-icon" id="view-icon">20</span>
			<span class="article-likes"><img src="/image/like-icon" id="like-icon">100</span>
			<span class="article-n-of-replies"><img src="/image/n-replies-icon" id="n-replies-icon">2</span>
			<span class="post-datetime"><time>2020-11-07 03:12:32</time></span>
		</div>
		<div class="article-contents"></div>
		<div class="reply-section">
			<span class="user-name"><img src="" id="user-profile-picture">user-name</span>
			<span class="reply-contents">Hi!</span>
			<span class="reply-likes">13</span>
			<span class="reply-datetime"><time class="posted">2020-11-07 03:12:32</time></span>
		</div>
	</div>

	<div>
		<form>
			<input type="text" name="reply-bar" placeholder="新增回覆...">
			<input type="submit" name="confirm-btn">
		</form>
	</div>

	<footer>
		Copyright © 2020 Progress, Inc. All rights reserved
	</footer>
</body>
</html>