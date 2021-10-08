<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="com.ufpa.edmilton.model.Ocr" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>OCR Project</title>
</head>
<body>
<h4>Submit a file for conversion:</h4>
<form action="OcrController" method="post" enctype="multipart/form-data">
	File: <input type="file" name="fileUpload"/>
	<br/>
	<input type="submit" value="Submit"/>
</form>
</body>
</html>