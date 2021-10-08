<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.io.File"%>
<%@ page import="net.sourceforge.tess4j.Tesseract"%>
<%@ page import="net.sourceforge.tess4j.TesseractException"%>
<%@ page import="java.lang.String"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.ufpa.edmilton.model.Ocr" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>OCR Project</title>
</head>
<body>
	<h1>Extracted Content:</h1>

	<% String text = (String) request.getAttribute("extractedText"); %>
	<% out.println(text); %>	
	
	
</body>
</html>