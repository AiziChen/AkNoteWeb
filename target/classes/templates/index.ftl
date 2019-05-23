<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>笔记本</title>
</head>
<body>
	<h1>我的笔记本</h1>
	<#list books as book>
	<a href="book/${book.id}">
		<ul>${book.title} - [${book.datetime?datetime?string["yyyy-MM-dd hh:mm"]}]</ul>
	</a>
	</#list>
</body>
</html>