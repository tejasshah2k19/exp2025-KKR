<%@page import="com.bean.ExpenseBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Expense</title>
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


	<div class="main-container">
		<jsp:include page="Header.jsp"></jsp:include>

		<!-- Page Content -->
		<div class="content">
			<div class="container mt-5">
				<h2 class="mb-4">List Expenses</h2>

				<a href="AddExpense.jsp" class="btn btn-primary mb-3">Add New
					Expense</a>

				<table class="table table-bordered table-hover table-striped">
					<thead class="table-dark">
						<tr>
							<th>Title</th>
							<th>Amount</th>
							<th>Expense Date</th>
							<th>Category</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="e">
							<tr>
								<td>${e.title}</td>
								<td>&#8377;${e.amount }</td>
								<td>${e.expenseDate }</td>
								<td>${e.category}</td>
								<td><a
									href="DeleteExpenseController?expenseId=${e.expenseId}">Delete</a>
									| <a
									href="ViewExpenseController?expenseId=${e.expenseId}">View</a>
									| <a href="">Edit</a></td>

							</tr>
						</c:forEach>
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
