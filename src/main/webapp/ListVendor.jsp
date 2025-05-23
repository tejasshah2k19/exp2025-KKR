<%@page import="com.bean.VendorBean"%>
<%@page import="com.bean.ExpenseBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Vendor</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body, html {
	height: 100%;
}

.main-container {
	display: flex;
	flex-direction: column;
	min-height: 100vh;
}

.content {
	flex: 1;
}
</style>
</head>
<body>

	<%
	ArrayList<VendorBean> list = (ArrayList<VendorBean>) request.getAttribute("list");
	%>

	<div class="main-container">
		<jsp:include page="Header.jsp"></jsp:include>

		<!-- Page Content -->
		<div class="content">
			<div class="container mt-5">
				<h2 class="mb-4">List Vendors</h2>

				<a href="NewVendor.jsp" class="btn btn-primary mb-3">Add New
					Vendor</a>

				<table class="table table-bordered table-hover table-striped">
					<thead class="table-dark">
						<tr>
							<th>Id</th>
							<th>Name</th>
						</tr>
					</thead>
					<tbody>
						<%
						for (VendorBean bean : list) {
						%>
						<tr>
							<td><%=bean.getVendorId()%></td>
							<td><%=bean.getVendorName()%></td>

						</tr>
						<%
						}
						%>
					</tbody>
				</table>
			</div>
		</div>

		<%@include file="Footer.jsp"%>


	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
