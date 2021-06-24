<%--
  Created by IntelliJ IDEA.
  User: Michele
  Date: 31/05/2021
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String errore = (String) request.getAttribute("invalidAccess");
    String message = (String) request.getAttribute("messageRegistrazione");
%>


<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="css/login.css">
    <!-- Boxicons CDN Link -->
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body id="bod">
    <div id="content">

            <div class="logo_content">
                <a href=""><img id="logo" src="img/logo.png"></a>
            </div>

            <label class="switch">
                <input type="checkbox" name="switch" id="checkbox" onclick="darkMode()">
                <span class="switch-svg"></span>
            </label>

            <div id="motto">
                <h1>Benvenuto in</h1><h1 id="particolareH1"> ecomobility</h1><h1>,<br>
                l'app pensata per te e per l'ambiente</h1>
            </div>


            <!-- per messaggi di errore e cose del genere -->
            <div id="message">

                <!--message error login-->
                <%
                    if (errore == "true") {
                %>
                <div id="alert">
                    <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
                    <strong>Errore! </strong> Username e/o password non validi.
                </div>
                <%
                    }
                %>

                <!--message registrazione-->

                <%
                    if (message == "false") {
                %>
                <div id="alert1">
                    <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
                    <strong>Errore!</strong> Email già esistente.
                </div>
                <%
                    }else if(message=="true"){
                %>
                <div id="success">
                    <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
                    <strong></strong> Registrazione effettuata con  <strong>successo.</strong>
                </div>
                <%
                    }
                %>

            </div>


            <div id="formContent">
                <div id="formSwitch">
                    <a id="selectLogin" href="#" onclick="selectLogin()">Accedi</a>
                    <a id="selectRegi" href="#" onclick="selectRegi()">Registrati</a>
                </div>

                <form id="fLogin" action="${pageContext.servletContext.contextPath}/LoginControl" method="post">
                    <p>Email</p>
                    <input type="text" name="email" required><br>
                    <p>Password</p>
                    <input type="password" name="password" required><br>
                    <input class="btn" type="submit" value="ACCEDI">
                </form>

                <form id="fRegi"action="${pageContext.servletContext.contextPath}/UtentiControl">
                    <div id="nomeRegi">
                        <p>Nome</p>
                        <input type="text" name="nome" required>
                    </div>
                    <div id="cognomeRegi">
                        <p>Cognome</p>
                        <input type="text" name="cognome" required>
                    </div>
                    <p>Email</p>
                    <input type="text" name="email" required><br>
                    <p>Password</p>
                    <input type="password" name="password" required><br>
                    <input class="btn" type="submit" value="REGISTRATI">
                </form>
            </div>


    </div>

<script type="text/javascript" src="js/login.js"></script>


</body>
</html>
