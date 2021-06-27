<%@ page import="java.time.LocalDate" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.eco_mobility.DTO.SpeseCarburanteDTO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: benedettosimone
  Date: 13/06/21
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%

    List <SpeseCarburanteDTO> spese= (List<SpeseCarburanteDTO>) request.getSession().getAttribute("spese");
    if(spese==null){
        response.sendRedirect("./RetriveSpeseControl");
        return;
    }
%>
<html>
<head>
    <link rel="stylesheet" href="css/speseCarburante.css">
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
        <div class="background-content">
            <div id="titleContent">
                SPESE CARBURANTE
            </div>
            <button onclick="myFunction()">Try it</button>
            <div id="list-responsive">

            </div>
            <div id="card">
                <div class="cardSX">

                    <b>NUOVA SPESA CARBURANTE</b>
                    <form action="${pageContext.servletContext.contextPath}/AddSpeseControl" method="post">
                        <div class="textCard">
                            Data<br>
                            <input type="date" name="data" class="formCard" max="<%=LocalDate.now()%>">
                        </div>

                        <div class="textCard">
                            Euro Spesi<br>
                            <input type="text" name="euro" class="formCard">
                        </div>
                        <input class="buttonCard" type="submit" value="AGGIUNGI">

                        <!-- <a class="buttonCard">Aggiungi</a> -->

                    </form>
                </div >



                <div class="cardDX">
                    <img src="../../../../eco-mobility1/src/main/webapp/img/Mar-Business_11_i@2x.png" class="imgCard"/></div>
            </div>
        </div>


    </div>



    <div id="list">
        <!-- parte destra -->


        <div id="titleList">
            Lista Spese
        </div><br>

        <input type="text" class="textbox">

        <div class="listaSpese">
            <%
                if(spese.isEmpty()==false){
                    for(int i=0; i<spese.size();i++){
            %>
                    <div class="cardList">
                        <div class="dataCard"><%=spese.get(i).getData()%></div>
                        <div class="priceCard"><%=spese.get(i).getEuroSpesi()%>€</div>
                    </div>
            <%
                 }
                }else{
            %>
                No Spese
            <%
                }
            %>
        </div>

    </div>


</div>

<script>
    function myFunction() {
        var div=document.getElementById("list-responsive");
        var list=document.getElementById("list");
        div.appendChild(list);
    }
</script>
</body>
</html>
