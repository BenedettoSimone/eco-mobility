<%@ page import="com.example.eco_mobility.DTO.ObiettiviDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="com.example.eco_mobility.DTO.SpeseCarburanteDTO" %><%--
  Created by IntelliJ IDEA.
  User: SalernoDaniele
  Date: 14/06/21
  Time: 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%

    String message= (String) request.getAttribute("addSpesa");

    List <SpeseCarburanteDTO> spese= (List<SpeseCarburanteDTO>) request.getSession().getAttribute("spese");
    if(spese==null){
        response.sendRedirect("./RetriveSpeseControl");
        return;
    }

%>

<html>

    <link rel="stylesheet" href="css/speseCarburante.css">
    <!-- Boxicons CDN Link -->
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>
    <script src="js/ListaObiettiviResp.js"></script>
    <script src="js/obiettivi.js"></script>


<body>


<%@ include file="ListaObResp.jsp" %>



<div class="row" id="myrow">

    <div id="navbar">
        <%@include file="navbar.jsp"%>
    </div>

    <div id="navbar_responsive">
        <%@include file="navbar-resp.jsp"%>
    </div>


    <div id="content">
        <div class="background-content">
            <span id="obiettIcon" style="font-size:35px;cursor:pointer" onclick="openBar()"><i class='bx bx-list-ol'></i></span>

            <%
                if(message!=null && message.equalsIgnoreCase("fallito")){
            %>

            <div id="alert">
                <span class="closebtn-error" onclick="this.parentElement.style.display='none';">&times;</span>
                <strong>Errore! </strong> La spesa non è stata aggiunta correttamente. Riprova!
            </div>

            <%
                }
            %>

            <%
                if(message!=null && message.equalsIgnoreCase("successo")){

                  System.out.println("cane");

            %>

            <div id="success">
                <span class="closebtn-success" onclick="this.parentElement.style.display='none'; onDeleteMessage()">&times;</span>
                <strong></strong>Nuova spesa aggiunta con <strong>successo.</strong>
            </div>
            <%

                }
            %>

            <div id="titleContent">
                SPESE CARBURANTE
            </div>

            <div id="list-responsive">
                <!-- card UTILIZZO MEZZO ECO -->
                <div id="cardSPESA" class="card">
                    <div class="cardSX">
                        <form id="fSpesa" action="${pageContext.servletContext.contextPath}/AddSpeseControl" method="post">
                            <h4>NUOVA SPESA CARBURANTE</h4>
                        <div class="textCard">
                                <p>Data</p>


                            <%@include file="calendarProva.jsp"%>

                            <p id="bottom_p">Euro spesi</p>
                                <input id="euro_input" type="text" name="euro" class="formCard" required onchange="euroObserver()">
                                <label id="euro_label"></label>



                            </div>

                            <input class="buttonCard" type="submit" value="AGGIUNGI">
                        </form>

                    </div>


                    <div class="cardDX">
                        <img src="img/speseForm.png"
                             class="imgCard"/></div>
                </div>
            </div>


        </div>
    </div>


    <div id="list">
        <!-- parte destra -->


        <div id="titleList">
            Lista Spese
        </div>
        <br>

        <%@include file="calendarProva1.jsp"%>

        <div class="listaSpese">

            <%
                if(spese.isEmpty()==false){
                    for(int i=0; i<spese.size();i++){
            %>

            <div class="card-spesa ">
                <h3><%=spese.get(i).getData()%></h3>
                <p>Euro spesi: <%=spese.get(i).getEuroSpesi()%>€</p>
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

<script src="js/speseCarb.js"></script>
</body>
</html>
