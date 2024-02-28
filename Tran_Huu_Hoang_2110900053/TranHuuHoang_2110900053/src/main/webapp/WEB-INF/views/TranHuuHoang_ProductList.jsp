<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<section class="container">
		<h3>Product List</h3>
		<p style="color: red;">${errorString}</p>
		
		<table class="table table-bordered">
			<thead style="background: #f1f1f1">
				<tr>
					<th>Mã SP</th>
					<th>Tên SP</th>
					<th>Số Lượng</th>
					<th>Đơn giá</th>
					<th>Ảnh</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listProduct}" var="product" >
					<tr>
						<td>${product.maSP_2110900053}</td>
						<td>${product.tenSP_2110900053}</td>
						<td>${product.soLuong_2110900053}</td>
						<td>${product.donGia_2110900053}</td>
						<td><img src="./imgs/${product.anh_2110900053}" alt="${product.tenSP_2110900053}" style="width: 150px"></td>
						<td>
							<a href="TranHuuHoang_ProductEdit?code=${product.maSP_2110900053}">Edit</a>
						</td>
						<td>
							<a href="TranHuuHoang_ProductDelete?code=${product.maSP_2110900053}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="TranHuuHoang_ProductCreate" >Create Product</a>
	</section>
</body>
</html>