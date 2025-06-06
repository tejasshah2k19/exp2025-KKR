<%@page import="com.bean.ExpenseBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chartjs-plugin-datalabels@2"></script>

<style>
/* canvas {
	max-width: 600px;
	margin: 40px auto;
	font-family: Arial, sans-serif;
}
 */
body {
	min-height: 600px;
}

canvas {
	background: #f9f9f9;
	border: 1px solid #ccc;
	padding: 10px;
	max-width: 800px;
	min-height: 500px;
	margin: 40px auto;
	font-family: Arial, sans-serif;
	margin: 40px auto;
}
</style>

</head>
<body>

	<div class="main-container" style="min-height: 92vh">

		<jsp:include page="Header.jsp"></jsp:include>

		<!-- Page Content -->

		<div class="content">


			<canvas id="barChart" width="400" height="300"></canvas>

		</div>



	</div>
	<%@include file="Footer.jsp"%>
	<%
	ArrayList<ExpenseBean> list = (ArrayList<ExpenseBean>) request.getAttribute("list");
	%>


	<script>
		const ctx = document.getElementById('barChart').getContext('2d');

		const barChart = new Chart(ctx, {
			type : 'bar',
			data : {
				labels : [ <%for(ExpenseBean b:list){%>  '<%=b.getCategory()%>', <%}%> ],
				datasets : [ {
					label : 'Expenses (in ₹)',
					data : [ <%for(ExpenseBean b:list){%>  '<%=b.getAmount()%>', <%}%>],
					backgroundColor : [ 'rgba(75, 192, 192, 0.6)',
							'rgba(153, 102, 255, 0.6)',
							'rgba(255, 159, 64, 0.6)',
							'rgba(255, 99, 132, 0.6)',
							'rgba(54, 162, 235, 0.6)' ],
					borderColor : '#ddd',
					borderWidth : 1
				} ]
			},
			 options: {
			        plugins: {
			          datalabels: {
			            anchor: 'end',
			            align: 'top',
			            formatter: Math.round,
			            font: {
			              weight: 'bold',
			              size: 14
			            }
			          }
			        },
			        responsive: true,
			        scales: {
			          y: {
			            beginAtZero: true,
			            title: {
			              display: true,
			              text: 'Amount in ₹'
			            }
			          },
			          x: {
			            title: {
			              display: true,
			              text: 'Categories'
			            }
			          }
			        }
			      },
			      plugins: [ChartDataLabels]
			    });
	</script>

</body>
</html>