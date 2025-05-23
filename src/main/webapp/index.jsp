<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Expense Tracker</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" />
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
      <!-- Hero Section -->
      <section class="bg-light text-center p-5">
        <div class="container">
          <h1 class="display-5 fw-bold">Welcome to Expense Tracker</h1>
          <p class="lead mt-3">Track your daily, weekly, and monthly expenses effortlessly. Stay on top of your budget and build better financial habits.</p>
          <div class="d-flex justify-content-center mt-4 gap-3">
            <a href="AddExpense.jsp" class="btn btn-primary btn-lg">Add Expense</a>
            <a href="ListExpenseController" class="btn btn-secondary btn-lg">List Expenses</a>
            <a href="CategoryWiseSumController" class="btn btn-danger btn-lg">Category Wise Expenses Sum</a>

            <a href="SearchExpense.jsp" class="btn btn-success btn-lg">Search By Category</a>
            
          </div>
        </div> 
      </section>

      <!-- Info Section -->
      <section class="container mt-5">
        <div class="row text-center">
          <div class="col-md-4">
            <h4>Simple Input</h4>
            <p>Just enter your expense amount, category, and date. It's quick and easy.</p>
          </div>
          <div class="col-md-4">
            <h4>Organized Lists</h4>
            <p>All your expenses are listed by date with filters and summaries.</p>
          </div>
          <div class="col-md-4">
            <h4>Insightful Reports</h4>
            <p>Coming soon: charts and summaries to give you clear financial insights!</p>
          </div>
        </div>
      </section>
    </div>

  <%@include file="Footer.jsp" %>

  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
