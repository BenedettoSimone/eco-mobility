<%--
  Created by IntelliJ IDEA.
  User: benedettosimone
  Date: 13/06/21
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="template.css">
    <link rel="stylesheet" href="navbar.css">
    <!-- Boxicons CDN Link -->
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>
<body>

<div class="row">

    <div id="navbar">
        <%@include file="navbar.jsp"%>
    </div>

    <div id="navbar_responsive">
        <%@include file="navbar-resp.jsp"%>
    </div>


    <div id="content">
        <div class="logo_resp_visible">
            <a href=""><img id="logo-resp" src="img/logo.png"></a>
        </div>
        <div class="background-content">
            <!--inserire qui-->
        </div>

    </div>
</div>
</body>
</html>
