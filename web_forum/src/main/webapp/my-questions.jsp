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

	<div class="content-board">
		<div>
			<h3 class="my-questions-space-header">My space</h3>
			<label>Filter</label>
			<form class="filter">
				<label>by Title</label>
				<input type="checkbox" id="title" name="filter">
				<input type="text" id="title">
				<label>by Tags</label>
				<input type="checkbox" id="tags" name="filter">
				<input type="text" id="tags">
				<label>by View</label>
				<input type="checkbox" id="view" name="filter">
				<input type="text" id="view">
				<input type="submit" name="confirm-btn">
			</form>
			<label>Sort</label>
			<form class="sort">
				<label>by Title</label>
				<input type="checkbox" id="title" name="sort">
				<input type="text" id="title">
				<label>by Tags</label>
				<input type="checkbox" id="tags" name="sort">
				<input type="text" id="tags">
				<label>by View</label>
				<input type="checkbox" id="view" name="sort">
				<input type="text" id="view">
				<input type="submit" name="confirm-btn">
			</form>
		</div>
		<div class="my-questions-table">
			<table>
				<tr id="my-questions-table-header">
					<th>Title</th>
					<th>Tags</th>
					<th>Top Reply</th>
					<th>View</th>
					<th>Likes</th>
					<th>Number of Replies</th>
				</tr>
				<tr>
					<td class="title-text">This is a sample title</td>
					<td class="tags-text">java, jsp, servlet</td>
					<td class="top-reply-text">This is a sample reply</td>
					<td class="view-text">120938</td>
					<td class="likes-text">123</td>
					<td class="n-of-replies-text">23</td>
				</tr>
				<tr>
					<td class="title-text"></td>
					<td class="tags-text"></td>
					<td class="top-reply-text"></td>
					<td class="view-text"></td>
					<td class="likes-text"></td>
					<td class="n-of-replies-text"></td>
				</tr>
				<tr>
					<td class="title-text"></td>
					<td class="tags-text"></td>
					<td class="top-reply-text"></td>
					<td class="view-text"></td>
					<td class="likes-text"></td>
					<td class="n-of-replies-text"></td>
				</tr>
			</table>
		</div>
		<div class="my-info-table">
			<div class="profile-picture">Mikey's pic</div>
			<div class="user-name">Mikey</div>
			<div class="email">mikey@goodmail.com</div>
			<div class="user-intro">Hi, I'm Mike.</div>
		</div>
	</div>


	<footer>
		Copyright © 2020 Progress, Inc. All rights reserved
	</footer>
</body>
</html>