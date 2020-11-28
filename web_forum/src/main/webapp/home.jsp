<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
<style type="text/css">
.article-meta-info span  {
	color: red;
}
.header-tool-btn a {
	color: green;
}

</style>

<head>
	<title>home</title>
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
		<article>
			<div class="article-meta-info">
				<h2><a href="">Sample Article</a></h2>
				<span class="article-view"><img src="/image/view-icon" id="view-icon">20</span>
				<span class="article-likes"><img src="/image/like-icon" id="like-icon">100</span>
				<span class="article-n-of-replies"><img src="/image/n-replies-icon" id="n-replies-icon">2</span>
				<span class="post-datetime"><time>2020-11-07 03:12:32</time></span>
				</div>
		</article>
		<article>
			<div>
				<h2><a href=""></a></h2>
				<span class="article-meta-info">
					<img src="/image/view-icon" id="view-icon"></span>
				<span class="article-meta-info"><img src="/image/like-icon" id="like-icon"></span>
				<span class="article-meta-info"><img src="/image/n-replies-icon" id="n-replies-icon"></span>
				<span class="post-datetime"><time></time></span>
			</div>

		</article>
		<article>
			<div>
				<h2><a href=""></a></h2>
				<span class="article-meta-info">
					<img src="/image/view-icon" id="view-icon"></span>
				<span class="article-meta-info"><img src="/image/like-icon" id="like-icon"></span>
				<span class="article-meta-info"><img src="/image/n-replies-icon" id="n-replies-icon"></span>
				<span><time class="posted"></time></span>
			</div>

		</article>
	</div>

	<ul>
		<li>
			<a href="/list/">first</a>
		</li>
		<li>
			<a href="/list/">previous</a>
		</li>
		<li>
			<a href="/list/">1</a>
		</li>
		<li>
			<a href="/list/?page=2">2</a>
		</li>
		<li>
			<a href="/list/?page=3">3</a>
		</li>
		<li>
			<a href="/list/">next</a>
		</li>
		<li>
			<a href="/list/">last</a>
		</li>
	</ul>
	<footer>
		Copyright © 2020 Progress, Inc. All rights reserved
	</footer>
</body>
</html>