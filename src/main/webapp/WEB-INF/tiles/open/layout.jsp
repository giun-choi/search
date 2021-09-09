<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta property="og:title" content="미니 검색엔진">
	<meta property="og:description" content="네이버 검색정보의 일부를 가져온 작은 검색사이트">
	<meta property="og:image" content="/resources/img/forest.jpg">
	<link rel="shortcut icon" href="/resources/img/favicon.ico">
	<link rel="icon" href="/resources/img/favicon.ico">
	<%@ include file="/WEB-INF/jsplink/cssOpenLink.jsp"%>
	<%@ include file="/WEB-INF/jsplink/jsLink.jsp"%>
	<title>WOONI</title>
</head>
<body>
	<tiles:insertAttribute name="center" ignore="true" />
</body>
</html>
