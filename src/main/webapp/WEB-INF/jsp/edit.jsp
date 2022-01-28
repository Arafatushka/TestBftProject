<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Книга</title>
<style>
	form fieldset {
		width : 40%;
	} 
	form fieldset label {
		display : block;
		/*width : 50%;
		float :left;*/
	}
	form fieldset input, form fieldset textarea {
		width : 100%;
	}
</style>
</head>
<body>
	<h1>Книга</h1>
	<h1>Книга</h1>
	<form method="POST">
		<fieldset>
			<div>
				<label>Название: </label>
				<input  type="text" name="name" value="${book.name}">
			</div>
			<div>
				<label>Год: </label>
				<input  type="number" name="author" value="${book.author}">
			</div>
			<div>
				<label>Описание: </label>
				<textarea name="description" rows="7">${book.description}</textarea>
			</div>
			<div>
				<input type="submit" value="Сохранить">
			</div>
		</fieldset>
	</form>
</body>
</html>