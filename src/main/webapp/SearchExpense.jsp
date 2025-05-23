<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Search Expense</title>
    <!-- Bootstrap CSS CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
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
            <h2 class="mb-4">Search Expense</h2>
            <form action="SearchExpenseController" method="post" class="p-4 border rounded shadow-sm bg-light">

               

               
                <div class="mb-3">
                    <label for="category" class="form-label">Category</label>
                    <input type="text" class="form-control" id="category" name="category" required>
                </div>
 

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>

            <div class="mt-3">
                <a href="ListExpenseController" class="btn btn-outline-secondary">View All Expenses</a>
            </div>
        </div>
    </div>

  <%@include file="Footer.jsp" %>

</div>

<!-- Bootstrap JS Bundle -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
