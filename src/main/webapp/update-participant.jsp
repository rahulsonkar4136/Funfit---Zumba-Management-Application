<%@ page import="java.util.List" %>
<%@ page import="com.funfit.models.Participant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Participants</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

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
            text-align: center;
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
        <h2>Participants Lists</h2>

        <% List<Participant> participants = (List<Participant>) request.getAttribute("participants");
        if (participants != null) { %>

            <!-- Display participants in a table -->
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Gender</th>
                        <th>Batch ID</th>
                        <th>Action</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Participant participant : participants) { %>
                        <tr>
                            <td><%= participant.getPid() %></td>
                            <td><%= participant.getName() %></td>
                            <td><%= participant.getGender() %></td>
                            <td><%= participant.getBatchId() %></td>
                            <td>
                                <a href="#" onclick="showUpdateForm('<%= participant.getPid() %>', '<%= participant.getName() %>', '<%= participant.getGender() %>', '<%= participant.getBatchId() %>')" class="btn btn-primary">Update</a>
                            </td>
                            <td>
                                <a href="#" onclick="deleteParticipant('<%= participant.getPid() %>')" class="btn btn-danger">Delete</a>
                            </td>
                        </tr>
                    <% } %>
                </tbody>
            </table>

            <!-- Update form -->
            <div id="updateForm" class="update-form" style="display: none;">
                <form action="update-participant" method="post">
                    <input type="hidden" id="updateId" name="updateId" value="">
                    <div class="form-group">
                        <label for="updateName">Name:</label>
                        <input type="text" id="updateName" name="updateName" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="updateGender">Gender:</label>
                        <select id="updateGender" name="updateGender" class="form-control" required>
                            <option value="Male">Male</option>
                            <option value="Female">Female</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="updateBatchId">Batch ID:</label>
                        <input type="number" id="updateBatchId" name="updateBatchId" class="form-control" required>
                    </div>
                    <button type="submit" class="btn btn-success">Update Participant</button>
                </form>
            </div>

        <% } else { %>
            <p>No participants found.</p>
        <% } %>
    </div>

    <!-- Bootstrap JS and Popper.js (for Bootstrap features) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <script>
        function showUpdateForm(pid, name, gender, batchId) {
            // Set values in the update form based on the participant ID
            document.getElementById("updateId").value = pid;
            document.getElementById("updateName").value = name;
            document.getElementById("updateGender").value = gender;
            document.getElementById("updateBatchId").value = batchId;

            // Display the update form
            document.getElementById("updateForm").style.display = "block";
        }

        function deleteParticipant(pid) {
            if (confirm("Are you sure you want to delete this participant?")) {
                
                window.location.href = "delete-participant?pid=" + pid;
            }
        }
    </script>

</body>
</html>
