<%--
  Created by IntelliJ IDEA.
  User: Michele
  Date: 31/05/2021
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="login.css">
    <!-- Boxicons CDN Link -->
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>
    <div id="content">
        <div id="contentLeft">
            benvenuto in ecomobility, l'app pensata per te e per l'ambiente
        </div>
        <div id="contentRight">

            <div id="formLogin">
                <div id="formSwitch">

                    <a href="#">Accedi</a>
                    <a href="#">Registrati</a>
                </div>

                <form action="#">
                    email <br>
                    <input type="text" name="email"><br>
                    password <br>
                    <input type="password" name="password"><br>

                    <input type="submit" value="accedi">
                </form>
            </div>
            <div id="formRegistrazione">

            </div>

        </div>
    </div>
</body>
</html>
