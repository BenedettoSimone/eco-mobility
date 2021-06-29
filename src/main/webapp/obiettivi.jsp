<%@ page import="com.example.eco_mobility.DTO.ObiettiviDTO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: SalernoDaniele
  Date: 14/06/21
  Time: 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List <ObiettiviDTO> obiettivi= (List<ObiettiviDTO>) request.getSession().getAttribute("obiettivi");
    if(obiettivi==null){
        response.sendRedirect("./RetriveObiettiviControl");
        return;
    }
%>
<html>
<head>
    <link rel="stylesheet" href="css/obiettivi.css">
    <!-- Boxicons CDN Link -->
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="js/ListaObiettiviResp.js"></script>
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
            <div id="titleContent">
                OBIETTIVI
            </div>

            <div id="list-responsive">

            </div>
            <div id="ContainerObiettivi">
                <!-- card SPESE -->
                <div id="cardKM" class="card">
                    <div class="cardALONE">

                        <form action="${pageContext.servletContext.contextPath}/ObiettivoControl" method="post">

                            <b>RIDUZIONE CHILOMETRI</b>

                            <div class="textCardUp">
                                Negli ultimi 7 giorni hai percorso in media 100km<br>

                            </div>

                            <div class="textCard">
                                quanti chilometri vuoi percorrere nei prossimi 7 giorni?<br>
                                <input type="text" name="obiettivo" class="formCard">
                                <input type="hidden" name="action" value="1">
                            </div>

                            <input class="buttonCard" type="submit" value="AGGIUNGI">

                            <!--<a class="buttonCard">Aggiungi</a>-->

                        </form>

                    </div>



                </div>





                <!-- card SPESE -->
                <div id="cardSPESE" class="card">
                    <div class="cardALONE">

                        <form action="${pageContext.servletContext.contextPath}/ObiettivoControl" method="post">
                            <b>RIDUZIONE SPESE CARBURANTE</b>

                            <div class="textCardUp">
                                Negli ultimi 7 giorni hai speso 200€<br>

                            </div>

                            <div class="textCard">
                                Quanto vuoi spendere nei prossimi 7 giorni?<br>
                                <input type="text" name="obiettivo" class="formCard">
                                <input type="hidden" name="action" value="2">
                            </div>

                            <input class="buttonCard" type="submit" value="AGGIUNGI">

                            <!--<a class="buttonCard">Aggiungi</a>-->

                        </form>

                    </div>



                </div>


                <!-- card UTILIZZO MEZZO ECO -->
                <div id="cardECO" class="card">
                    <div class="cardSX">
                        <form action="${pageContext.servletContext.contextPath}/ObiettivoControl" method="post">
                            <b>UTILIZZO MEZZO ECO-SOSTENIBILE</b>

                            <div class="textCardUp">
                                Negli ultimi 7 giorni hai utilizzato 0 volte un mezzo eco-sostenibile<br>
                            </div>

                            <div class="textCard">
                                Quante volte vuoi utilizzare un mezzo ecosostenibile nei prossimi 7 giorni?<br>
                                <input type="text" name="obiettivo" class="formCard">
                                <input type="hidden" name="action" value="3">

                            </div>

                            <input class="buttonCard" type="submit" value="AGGIUNGI">

                            <!--<a class="buttonCard">Aggiungi</a>-->

                        </form>

                    </div>


                    <div class="cardDX">
                        <img src="img/macchinaELE.webp"
                             class="imgCard"/></div>
                </div>
            </div>


        </div>
    </div>


    <div id="list">
        <!-- parte destra -->


        <div id="titleList">
            Lista Obiettivi
        </div>
        <br>

        <input type="text" class="textbox">

        <div class="listaSpese">

            <%
                if(obiettivi.isEmpty()){
            %>
            No obiettivi
            <%
                }else{
                    for (int i=0;i<obiettivi.size();i++){
            %>
            <div class="cardList">
                <div class="dataCard"><%=obiettivi.get(i).getScadenza()%></div>
                <div class="priceCard"><%=obiettivi.get(i).getTipoObiettivo()%>: <%=obiettivi.get(i).getObiettivo()%></div>
            </div>
            <%
                    }
                }
            %>

        </div>

    </div>


</div>

</body>
</html>
