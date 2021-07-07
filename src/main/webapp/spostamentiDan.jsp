<%@ page import="com.example.eco_mobility.DTO.ObiettiviDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.eco_mobility.DTO.SpostamentiDTO" %><%--
  Created by IntelliJ IDEA.
  User: SalernoDaniele
  Date: 14/06/21
  Time: 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    List<SpostamentiDTO> spostamenti = (List<SpostamentiDTO>) request.getSession().getAttribute("retriveSpost");
    if(spostamenti==null){
        response.sendRedirect("./RetriveSpostamentiControl");
        return;
    }

%>
<html>
<head>
    <link rel="stylesheet" href="css/spostamenti.css">
    <!-- Boxicons CDN Link -->
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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


            <div id="alert">
                <span class="closebtn-error" onclick="this.parentElement.style.display='none';">&times;</span>
                <strong>Errore! </strong> Impossibile aggiungere due obiettivi dello stesso tipo in una settimana.
            </div>





              <div id="success">
                   <span class="closebtn-success" onclick="this.parentElement.style.display='none'; onDeleteMessage()">&times;</span>
                   <strong></strong>Obiettivo aggiunto con <strong>successo.</strong>
               </div>


            <div id="titleContent">
                SPOSTAMENTI
            </div>

            <div id="list-responsive">
                <!-- card UTILIZZO MEZZO ECO -->
                <div id="cardECO" class="card">
                    <div class="cardSX">
                        <form id="fMezzo" action="${pageContext.servletContext.contextPath}/AddSpostamentiControl" method="post">
                            <h4>NUOVO SPOSTAMENTO</h4>

                            <div class="textCard">
                                <p>Data</p>
                                <%@include file="calendarProva.jsp"%>
                                <label id="data_label"></label>
                                <input type="hidden" name="action" value="3">

                            </div>


                            <div class="textCard">
                                <p id="bottom_p">Chilometri Percorsi</p>

                                <input id="chilometri_input" type="text" name="km" class="formCard" required>
                                <label id="chilometri_label"></label>
                                <input type="hidden" name="action" value="3">

                            </div>

                            <div class="radioCard">
                                Tipologia mezzo utilizzato<br>
                                <div id="content-radio">
                                <div id="ecodiv">
                                <input id="eco" type="radio" name="mezzo" required checked value="eco">
                                <p>eco-sostenibile</p>
                                </div>
                                <div id="Notecodiv">
                                <input id="Noteco" type="radio" name="mezzo" value="Noteco" required>
                                    <p>non eco-sostenibile</p>
                                </div>
                                </div>


                            </div>

                            <input class="buttonCard" type="submit" value="AGGIUNGI">

                            <!--<a class="buttonCard">Aggiungi</a>-->

                        </form>

                    </div>


                    <div class="cardDX">
                        <img src="img/spostamenti.png"
                             class="imgCard"/></div>
                </div>
            </div>


        </div>
    </div>


    <div id="list">
        <!-- parte destra -->


        <div id="titleList">
            Lista Spostamenti
        </div>
        <br>


        <form id="cercaData"  action="" method="post">
            <%@include file="calendarProva1.jsp"%>
            <input class="buttonFilter" type="submit" value="Cerca">
        </form>

        <div class="listaSpese">
            <%
                if(!spostamenti.isEmpty()){
                    for(SpostamentiDTO sp : spostamenti){
                        String tipo=null;
                        if(sp.isTipoMezzo()){
                            tipo="ecosostenibile";
                        }else{
                            tipo="non ecosostenibile";
                        }
            %>
                        <div class="eco">
                            <h3><%=sp.getData()%></h3>
                            <p>Mezzo utilizzato: <%=tipo%></p>
                            <p>Km percorsi: <%=sp.getKmPercorsi()%></p>
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


</body>
</html>
