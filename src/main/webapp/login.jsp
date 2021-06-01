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
            <h1>benvenuto in ecomobility, l'app pensata per te e per l'ambiente</h1>
        </div>
        <div id="contentRight">

            <div id="formContent">
                <div id="formSwitch">

                    <a href="#">Accedi</a>
                    <a href="#">Registrati</a>
                </div>

                <form id="fLogin"action="#">
                    <p>email</p>
                    <input type="text" name="email"><br>
                    <p>password</p>
                    <input type="password" name="password"><br>

                    <input class="btn" type="submit" value="ACCEDI">
                </form>

                <form id="fRegi"action="#">
                    <p>nome</p>
                    <input type="text" name="nome">
                    <p>cognome</p>
                    <input type="text" name="cognome"><br>
                    <p>email</p>
                    <input type="text" name="email"><br>
                    <p>password</p>
                    <input type="password" name="password"><br>
                    <input class="btn" type="submit" onclick="selectRegi()" value="REGISTRATI">
                </form>
            </div>

        </div>
    </div>

<script type="text/javascript">

    function selectRegi(){
        document.getElementById("fLogin").style.display="none";
        document.getElementById("fRegi").style.display="block";

    }
</script>
</body>
</html>
