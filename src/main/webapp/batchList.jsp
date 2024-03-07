<%@page import="com.funfit.operations.BatchOperations"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="com.funfit.models.Batch" %>
<%@ page import="java.util.List" %>
<%@ page import="com.funfit.operations.BatchOperations" %>

<%
    BatchOperations batchOperations = null;
    List<Batch> batchList = null;

    try {
        batchOperations = new BatchOperations();
        batchList = batchOperations.viewAllBatches();
        pageContext.setAttribute("batchList", batchList);
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (batchOperations != null) {
           
        }
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Batch List</title>
    <!-- Include Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
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
        

        .table {
            border-collapse: separate;
            border-spacing: 0 15px;
        }

        .table th {
            background: #fff;
        }

        .table th, .table td {
            border: none;
        }

        .btn {
            margin-right: 5px;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>FunFit: Zumba Management System</h2>
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

<div class="container">
    <h2>Batch List</h2>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Batch ID</th>
            <th>Batch Name</th>
            <th>Batch Time</th>
            <th>Action</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="batch" items="${batchList}">
            <tr>
                <td><c:out value="${batch.bid}" /></td>
                <td><c:out value="${batch.name}" /></td>
                <td><c:out value="${batch.time}" /></td>
                <td>
                    <a href="#" class="btn btn-primary" onclick="showUpdateForm('${batch.bid}', '${batch.name}', '${batch.time}')">Update</a>
                </td>
                <td>
                    <a href="#" class="btn btn-danger" onclick="deleteBatch('${batch.bid}')">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<!-- Update form -->
<div id="updateForm" class="update-form" style="display: none;">
    <form action="update-batch" method="post">
        <input type="hidden" id="updateId" name="updateId" value="">
        <div class="form-group">
            <label for="updateName">Batch Name:</label>
            <input type="text" id="updateName" name="updateName" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="updateTime">Batch Time:</label>
            <input type="text" id="updateTime" name="updateTime" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-success">Update Batch</button>
    </form>
</div>

<!-- Bootstrap JS and Popper.js (for Bootstrap features) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script>
    function showUpdateForm(bid, Name, Time) {
        // Set values in the update form based on the batch ID
        document.getElementById("updateId").value = bid;
        document.getElementById("updateName").value = Name;
        document.getElementById("updateTime").value = Time;

        // Display the update form
        document.getElementById("updateForm").style.display = "block";
    }

    function deleteBatch(bid) {
        if (confirm("Are you sure you want to delete this batch?")) {
            // Redirect to the delete-batch servlet with the batchId parameter
            window.location.href = "delete-batch?bid=" + bid;
        }
    }
</script>

</body>
</html>
