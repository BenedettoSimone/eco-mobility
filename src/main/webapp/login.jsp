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
    <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.2/dist/jquery.validate.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
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


        <div id="left-side">
            <!-- per messaggi di errore e cose del genere -->
            <div id="message">

                <!--message error login-->
                <%
                    if( errore!=null && errore.equalsIgnoreCase("true")){
                %>
                <div id="alert">
                    <span class="closebtn-error" onclick="this.parentElement.style.display='none';">&times;</span>
                    <strong>Errore! </strong> Username e/o password non validi.
                </div>
                <%
                    }
                %>

                <!--message registrazione-->

                <%
                    if (message!=null && message.equalsIgnoreCase("false")) {
                %>
                <div id="alert1">
                    <span class="closebtn-error" onclick="this.parentElement.style.display='none'; onDeleteMessage()">&times;</span>
                    <strong>Errore!</strong> Email già esistente.
                </div>
                <%
                    }else if(message!=null && message.equalsIgnoreCase("true")){
                %>
                <div id="success">
                    <span class="closebtn-success" onclick="this.parentElement.style.display='none'; onDeleteMessage()">&times;</span>
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
                        <p id="nome_l">Nome</p>
                        <input type="text" id="nome" name="nome" required onchange="nomeObserver()">
                    </div>
                    <div id="cognomeRegi">
                        <p id="cognome_l">Cognome</p>
                        <input type="text" id="cognome" name="cognome" required onchange="cognomeObserver()">
                    </div>
                    <p id="email_l">Email</p>
                    <input type="text" id="email" name="email" required onchange="emailObserver()"><br>
                    <p id="password_l">Password</p>
                    <input type="password" id="password" name="password" required onchange="passwordObserver()"><br>
                    <input class="btn" type="submit" value="REGISTRATI">
                </form>
            </div>
        </div>

    </div>
<script>
    /*vedo se ci vuole la dark mode*/
    window.onload = function provaDark(){
        let name = "darkmode=";
        let decodedCookie = decodeURIComponent(document.cookie);
        let ca = decodedCookie.split(';');
        for(let i = 0; i <ca.length; i++) {
            let c = ca[i];
            while (c.charAt(0) == ' ') {
                c = c.substring(1);
            }
            if (c.indexOf(name) == 0) {
                alert(c.substring(name.length, c.length)+" cookie recuperato");
                return;
            }
        }

        alert("cookie non recuperato");

    }
</script>
<script type="text/javascript" src="js/login.js"></script>
    <script type="text/javascript" src="js/dark.js"></script>


</body>
</html>
