<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="_navTop.jsp"></jsp:include>
	<section class="container border my-2" style="min-height:150px">
		<h3 class="my-5">Delete Department</h3>
		<p style="color: red">${errorString}</p>
		<a href="productList" class="btn btn-danger">Product List</a>
	</section>
</body>
</html>