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
    <link rel="stylesheet" href="css/login.css">
    <!-- Boxicons CDN Link -->
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>
    <div id="content">
        <div class="logo_content">
            <a href=""><img id="logo" src="img/logo.png"></a>
        </div>
        <div id="contentLeft">
            <div id="motto">
                <h1>Benvenuto in</h1><h1 id="particolareH1"> ecomobility</h1><h1>,<br>
                l'app pensata per te e per l'ambiente</h1>
            </div>
        </div>
        <div id="contentRight">
            <!-- per messaggi di errore e cose del genere -->
            <div id="message"></div>

            <div id="formContent">
                <div id="formSwitch">
                    <a id="selectLogin" href="#" onclick="selectLogin()">Accedi</a>
                    <a id="selectRegi" href="#" onclick="selectRegi()">Registrati</a>
                </div>

                <form id="fLogin"action="#">
                    <p>email</p>
                    <input type="text" name="email"><br>
                    <p>password</p>
                    <input type="password" name="password"><br>

                    <input class="btn" type="submit" value="ACCEDI">
                </form>

                <form id="fRegi"action="#">
                    <div id="nomeRegi">
                        <p>nome</p>
                        <input type="text" name="nome">
                    </div>
                    <div id="cognomeRegi">
                        <p>cognome</p>
                        <input type="text" name="cognome">
                    </div>
                    <p>email</p>
                    <input type="text" name="email"><br>
                    <p>password</p>
                    <input type="password" name="password"><br>
                    <input class="btn" type="submit" value="REGISTRATI">
                </form>
            </div>

        </div>
    </div>

<script type="text/javascript" src="js/login.js"></script>
</body>
</html>
