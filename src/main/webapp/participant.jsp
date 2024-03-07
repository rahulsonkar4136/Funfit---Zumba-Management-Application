<%@page import="com.funfit.models.Batch"%>
<%@page import="com.funfit.operations.BatchOperations"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.funfit.models.Batch" %>
<%@ page import="java.util.List" %>
<%@ page import="com.funfit.operations.BatchOperations" %>

<%
    // Fetching all batches for the dropdown
    BatchOperations batchOpr = new BatchOperations();
    List<Batch> batches = batchOpr.getAllBatches();

    // Set the list of batches as an attribute in the request
    request.setAttribute("batches", batches);
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Participant</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style></style>
     

<style>
        body {
            background-color: #f0f0f0;
            color: #333;
            padding: 20px;
            margin: 0;
            font-family: Arial, sans-serif;
        }
        h2 {
            color: #007bff;
        }
        form {
            max-width: 400px;
            margin: 0 auto;
        }
        label {
            margin-top: 10px;
            display: block;
        }
        input, select {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            margin-bottom: 15px;
            box-sizing: border-box;
        }
        button {
            background-color: #007bff;
            color: #fff;
            padding: 10px;
            border: none;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
        }
        .container {
            margin-top: 50px;
        }

        .navbar {
            background-color: #007bff;
            box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
        }

        .navbar-nav {
            margin-top: 10px;
        }

        .nav-item {
            margin-right: 20px;
        }

        .nav-link {
            color: #000;
            font-size: 16px;
        }

        .nav-link:hover {
            color: #333;
        }
        .nav-link:hover {
            color: #333;
        }
        
    </style>
</head>

<body>


	<div class="container">
        <h2>Funfit: Zumba Management System</h2>
<nav class="navbar navbar-expand-lg navbar-dark">
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="batch.html">Add Batch</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="participant.jsp">Add Participant</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="batchList.jsp">Batch List</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="update-participant">Participant</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Welcome.html">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp">Exit</a>
                </li>
            </ul>
        </div>
    </nav>
</div>
        
    </div>
    <div class="container">
        <h2>Add Participant</h2>

        <form action="participant" method="post">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" name="name" required><br>

            <label for="gender">Gender:</label>
            <select class="form-control" id="gender" name="gender" required>
                <option value="Male">Male</option>
                <option value="Female">Female</option>
                <!-- Add more options if needed -->
            </select><br>

            <label for="batchId">Batch:</label>
            <select class="form-control" id="batchId" name="batchId" required>
                <!-- Fetch batch IDs dynamically from the Batch table -->
                <c:forEach var="batch" items="${batches}">
                    <option value="${batch.bid}">${batch.bid} - ${batch.name}</option>
                </c:forEach><label for="batchId">Batch:</label>
            <select class="form-control" id="batchId" name="batchId" required>
                <!-- Fetch batch IDs dynamically from the Batch table -->
                <c:forEach var="batch" items="${batches}">
                    <option value="${batchId}"></option>
                </c:forEach>
            </select><br>
            </select><br>

            <button type="submit" class="btn btn-primary">Add Participant</button>
        </form>
    </div>

    <!-- Bootstrap JS and Popper.js (for Bootstrap features) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>
