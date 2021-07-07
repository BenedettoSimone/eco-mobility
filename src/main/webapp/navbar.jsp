<%@ page import="com.example.eco_mobility.DTO.UtentiDTO" %><%--
  Created by IntelliJ IDEA.
  User: benedettosimone
  Date: 01/06/21
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    UtentiDTO ut = (UtentiDTO) request.getSession().getAttribute("utente");

    if(ut==null){
        response.sendRedirect("/LoginControl");
        return;
    }

    //media chilometri settimana corrente
    int mediaKm = (int) request.getSession().getAttribute("mediaSet");

    //media spesa carburante settimana corrente
    int mediaCarburante=(int) request.getSession().getAttribute("mediaSpCarburante");

    int count=(int) request.getSession().getAttribute("countMezzo");


%>

<html>
<head>
    <title>Title</title>
    <!-- Boxicons CDN Link -->
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="css/navbar.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>



<div class="sidebar active">
    <div class="logo_content">
        <a href="./SpostamentiControl"><img id="logo" src="img/logo.png"></a>
    </div>
    <ul class="nav_list">
        <li>
            <a id="home" class="top" href="./SpostamentiControl">
                <i class='bx bxs-home'></i>
                <span class="links_name">Home</span>
            </a>
        </li>
        <li>
            <a id="spostamenti" class="top" href="spostamenti.jsp">
                <i class='bx bxs-car'></i>
                <span class="links_name">Spostamenti</span>
            </a>
        </li>
        <li>
            <a id="spesa" class="top" href="speseCarb.jsp">
                <i class='bx bxs-wallet'></i>
                <span class="links_name">Spesa carburante</span>
            </a>
        </li>
        <li>
            <a id="obiettivi" class="top" href="obiettivi.jsp">
                <i class='bx bxs-trophy'></i>
                <span class="links_name">Obiettivi</span>
            </a>
        </li>
        <li>
            <a id="premi" class="top" href="premi.jsp">
                <i class='bx bxs-medal'></i>
                <span class="links_name">Premi</span>
            </a>
        </li>
    </ul>

    <div id="user">
        <ul>
            <li>
                <a class="user-name"> <i class='bx bxs-user'></i>
                    <span class="links_name"><%=ut.getNome()%> <%=ut.getCognome()%></span>
                </a>
            </li>

            <li>
                <a class="logout-bottom" href="${pageContext.servletContext.contextPath}/LogoutControl"><i class='bx bx-log-out'></i>
                    <span class="links_name">Logout</span>
                </a>
            </li>
        </ul>
    </div>
</div>

</body>
<script src="js/navbar.js">
</script>

<script>
    function checkResolution() {

        if ($(window).innerWidth() > 1520) {

            $img = $('#logo');
            $img.attr('src', 'img/logo.png');

        }

        else if ($(window).innerWidth() >1081 && $(window).innerWidth() <= 1520) {
            $img = $('#logo');
            $img.attr('src', 'img/logo-short.png');
        }

        else if ($(window).innerWidth() <= 1080) {
            $img = $('#logo');
            $img.attr('src', 'img/logo.png');

        }
    }

    $(window).resize(function() {
        checkResolution();
    });

    $(document).ready(function() {
        checkResolution();
    });


</script>

</body>
</html>

