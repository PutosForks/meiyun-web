<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="description" content="">
<meta name="viewport" content="width=device-width">
<title>添加产品</title>
<%@ include file="../snippets/style.jsp" %>
</head>
<body>
	<%@ include file="../header.jsp"%>
	
	<div class="toolbar">
		<div class="container">
			<h3>分享产品</h3>
		</div>
	</div>

	<div class="container">
		<div class="panel panel-default">
			<div class="panel-body">
				<%@ include file="snippets/add_form.jsp"%>
			</div>
		</div>
	</div>
	
<%@ include file="../snippets/scripts.jsp" %>
<script src="/assets/js/product/add.js"></script>
</body>
</html>
