
<%@page import="java.time.LocalDate" isELIgnored="false"%>
<%
LocalDate date = LocalDate.now();
%>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" />

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container-fluid">
		<a class="navbar-brand" href="index.jsp"><b>Expense Tracker</b></a>
		<span class="text-white">${user.firstName}</span>
		<span class="text-white"><a href="LogoutController">Logout</a></span>
	</div>
	
	
	
	
	
	
	
</nav>