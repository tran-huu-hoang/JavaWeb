<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Product</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_navTop.jsp"></jsp:include>
	<section class="container border my-2" style="min-height:150px">
		<h3 class="my-5">Delete Product</h3>
		<p style="color: red">${errorString}</p>
		<a href="productList" class="btn btn-danger">Product List</a>
	</section>
	<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>