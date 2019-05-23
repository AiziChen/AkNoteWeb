<#assign root=ctx.contextPath />
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>${bookName}</title>
</head>
<body>
<!-- bookName, note -->
<form action="${root}/note/newNote/${id}">
	标题：<input type="text" name="title" /> <br />
	作者：<input type="text" name="author" /> <br />
	内容：<input type="text" name="content" /> <br />
	<input type="submit" value="新建" /> <br />
</form>
	<#list notes as note>
	<a href="${root}/note/${note.id}">
		<ul>${note.title} (Author：${note.author}) [${note.datetime?datetime?string["yyyy-MM-dd hh:mm"]}]</ul>
	</a>
	</#list>
</body>
</html>