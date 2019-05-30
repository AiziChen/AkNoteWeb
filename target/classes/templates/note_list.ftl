<#assign root=ctx.contextPath />
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>《${bookName}》</title>
</head>
<body>
<!-- bookName, note -->
<h2>《${bookName}》</h2>
<hr />
<button onclick="deleteThisBook();" style="display: block;">删除本书</button>
<form action="${root}/note/newNote/${id}" method="post">
	标题：<input type="text" name="title" /> <br />
	作者：<input type="text" name="author" /> <br />
	内容：<input type="text" name="content" /> <br />
	<input type="submit" value="新建" /> <br />
</form>
<hr />
	<#list notes as note>
	<a href="${root}/note/${note.id}">
		<ul>${note.title} (Author：${note.author}) [${note.modifyDatetime?datetime?string["yyyy/MM/dd hh:mm"]}]</ul>
	</a>
	</#list>
	
	<script>
		function deleteThisBook() {
			let ok = confirm("删除书籍《${bookName}》？");
			if (ok) {
				location.replace("${root}/book/deleteBook?id=${id}");
			}
		}
	</script>
</body>
</html>