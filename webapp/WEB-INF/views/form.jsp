<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>file upload example</h1>
<form method="post" action="upload" enctype="multipart/form-data">
	<input type="hidden" name="deptNo" value="10">
	simple upload : <br><br>
	<input type="file" name="file"><br><br>
	<input type="submit" value="upload">
</form>
</body>
</html>