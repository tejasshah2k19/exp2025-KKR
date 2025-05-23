<%@page import="com.bean.ExpenseBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Expense</title>
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
	ExpenseBean bean = (ExpenseBean) request.getAttribute("bean");
	%>

	<div class="main-container">

		<jsp:include page="Header.jsp"></jsp:include>

		<!-- Page Content -->
		<div class="content">
			<div class="container mt-5">
				<h2 class="mb-4 text-center">View Expense</h2>

				<div class="d-flex justify-content-center">
					<div class="card shadow" style="width: 24rem;">
						<div class="card-body">
							<h5 class="card-title"><%=bean.getTitle()%></h5>
							<h6 class="card-subtitle mb-2 text-muted"><%=bean.getCategory()%></h6>
							<p class="card-text">
								<strong>Amount:</strong> ₹<%=bean.getAmount()%><br> <strong>Date:</strong>
								<%=bean.getExpenseDate()%>
							</p>
							<a href="AddExpense.jsp" class="btn btn-primary">Add New
								Expense</a>
						</div>
					</div>
				</div>

			</div>
		</div>

		<%@include file="Footer.jsp"%>

	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
