<%--
  Created by IntelliJ IDEA.
  User: benedettosimone
  Date: 13/06/21
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/home.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="css/navbar.css">
</head>
<body>

<div>
<span class="hamburger" id="HamburgerBTN" onclick="openNav()">
            <i class='bx bx-menu-alt-left'>
                <span id="menu">Menù</span>
            </i>
</span>

</div>

<div id="mySidenav" class="sidenav">
    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
    <div id="links_resp">
        <a href="#">Home</a>
        <a href="#">Spostamenti</a>
        <a href="#">Obiettivi</a>
        <a href="#">Spesa Carburante</a>
        <a href="#">Premi</a>
    </div>

    <div id="user_resp">
        <a class="user-name"> <i class='bx bxs-user'></i>
            <span class="links_name">Benedetto Simone</span>
        </a>

        <a class="logout-bottom"> <i class='bx bx-log-out'></i>
            <span class="links_name">Logout</span>
        </a>
    </div>
</div>

</body>
</html>
