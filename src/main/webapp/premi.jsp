<%--
  Created by IntelliJ IDEA.
  User: benedettosimone
  Date: 14/06/21
  Time: 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta charset="UTF-8">
<title>Title</title>
<link rel="stylesheet" href="css/premi.css">
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
            <h1>Premi</h1>
            <div id="premi-content">
                <div class="scroll-bar">
                    <div class="row-premi">
                        <div class="column-premi">
                            <div class="card-premi">
                                <h3>Riduzione spesa</h3>
                                <p>Status: in corso</p>
                                <p>Km percorsi: 30 &nbsp &nbsp &nbsp Km massimi: 400</p>
                            </div>
                        </div>

                        <div class="column-premi">
                            <div class="card-premi">
                                <h3>Riduzione spesa</h3>
                                <p>Status: in corso</p>
                                <p>Km percorsi: 30 &nbsp &nbsp &nbsp Km massimi: 400</p>
                            </div>
                        </div>

                        <div class="column-premi">
                            <div class="card-premi">
                                <h3>Riduzione spesa</h3>
                                <p>Status: in corso</p>
                                <p>Km percorsi: 30 &nbsp &nbsp &nbsp Km massimi: 400</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div id="obiettivi-content">

                <h5>Obiettivi riduzione km</h5>

                <div class="scroll-bar">
                    <div class="row-obiettivi">
                        <div class="column-obiettivi">
                            <div class="card-obiettivi">
                                <h3>Riduzione spesa</h3>
                                <p>Status: in corso</p>
                                <p>Km percorsi: 30 &nbsp &nbsp &nbsp Km massimi: 400</p>
                            </div>
                        </div>

                        <div class="column-obiettivi">
                            <div class="card-obiettivi">
                                <h3>Card 2</h3>
                                <p>Some text</p>
                                <p>Some text</p>
                            </div>
                        </div>

                        <div class="column-obiettivi">
                            <div class="card-obiettivi">
                                <h3>Card 3</h3>
                                <p>Some text</p>
                                <p>Some text</p>
                            </div>
                        </div>


                    </div>
                </div>
            </div>

        </div>
    </div>
</div>


</body>
</html>