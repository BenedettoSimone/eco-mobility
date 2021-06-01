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

<script type="text/javascript">

    /* cosa succede quando premo registrati */
    function selectRegi(){
        /*il form di login non si vede più*/
        document.getElementById("fLogin").style.display="none";
        /*il form di registrazione diventa visibile*/
        document.getElementById("fRegi").style.display="block";

        /*cambio i colori al bottone cliccato*/
        document.getElementById("selectRegi").style.color="#5a87e8"
        document.getElementById("selectRegi").style.backgroundColor="#f1f6ff"
        document.getElementById("selectRegi").style.borderRadius="25px";

        /*cambio i colori al bottone non cliccato*/
        document.getElementById("selectLogin").style.color="#494848"
        document.getElementById("selectLogin").style.backgroundColor="#fff"
        document.getElementById("selectLogin").style.borderRadius="0px";
    }

    /* cosa succede quando premo registrati */
    function selectLogin(){
        /*il form di login diventa visibile*/
        document.getElementById("fLogin").style.display="block";
        /*il form di registrazione non si vede più*/
        document.getElementById("fRegi").style.display="none";

        /*cambio i colori al bottone cliccato*/
        document.getElementById("selectLogin").style.color="#5a87e8"
        document.getElementById("selectLogin").style.backgroundColor="#f1f6ff"
        document.getElementById("selectLogin").style.borderRadius="25px";

        /*cambio i colori al bottone non cliccato*/
        document.getElementById("selectRegi").style.color="#494848"
        document.getElementById("selectRegi").style.backgroundColor="#fff"
        document.getElementById("selectRegi").style.borderRadius="0px";
    }
</script>
</body>
</html>
