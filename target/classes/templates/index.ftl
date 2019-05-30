<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>笔记本</title>
</head>
<body>
	<h1>我的笔记本</h1>
	<form action="/book/newBook">
		<input type="text" name="name" placeholder="笔记名"/>
		<input type="submit" value="新建笔记" />
		<br />
	</form>
	<#list books as book>
	<a href="book/${book.id}">
		<ul>《${book.title}》 - [${book.modifyDatetime?datetime?string["yyyy/MM/dd hh:mm"]}]</ul>
	</a>
	</#list>
	<hr>
</body>
</html>