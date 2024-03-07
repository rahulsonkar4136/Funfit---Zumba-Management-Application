<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FunFit</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            
            background-size: cover;
            background-position: center;
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            color: #fff;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            text-align: center;
        }

        #welcomeContainer {
            background: rgba(0, 0, 0, 0.8); 
            padding: 20px;
            border-radius: 10px;
        }

        h1 {
            margin-bottom: 20px;
        }

        #startButton {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            font-size: 16px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        #startButton:hover {
            background-color: #0056b3;
        }
    </style>
</head>

<body>
    <div id="welcomeContainer">
        <h1>Welcome to the FunFit Application</h1>
        <button id="startButton" onclick="openWelcomePage()">Start</button>
    </div>

    <script>
        function openWelcomePage() {
            window.location.href = "Welcome.html";
        }
    </script>
</body>

</html>
