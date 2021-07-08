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
    List <ObiettiviDTO> obiettivi= (List<ObiettiviDTO>) request.getAttribute("obiettivi");
    if(obiettivi==null){
        response.sendRedirect("./RetriveObiettiviControl");
        return;
    }

    int count=(int) request.getSession().getAttribute("countMezzo");

    String error= (String) request.getAttribute("ErrObiettivo");
    String success= (String) request.getAttribute("SuccessObiettivo");
    


%>
<html>
<head>
    <title>Obiettivi</title>
    <link rel="stylesheet" href="css/obiettivi.css">
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

            <%
                if(error!=null && error.equalsIgnoreCase("true")){
            %>
            <div id="alert">
                <span class="closebtn-error" onclick="this.parentElement.style.display='none';">&times;</span>
                <strong>Errore! </strong> Impossibile aggiungere due obiettivi dello stesso tipo in una settimana.
            </div>
        <%
            }
        %>

            <%
                if(success!=null && success.equalsIgnoreCase("true")){
            %>
              <div id="success">
                   <span class="closebtn-success" onclick="this.parentElement.style.display='none'; onDeleteMessage()">&times;</span>
                   <strong></strong>Obiettivo aggiunto con <strong>successo.</strong>
               </div>

            <%
                }
            %>
            <div id="titleContent">
                OBIETTIVI
            </div>

            <div id="list-responsive">

            </div>
            <div id="ContainerObiettivi">
                <!-- card SPESE -->
                <div id="cardKM" class="card">
                    <div class="cardALONE">

                        <form id="fChilometri" action="${pageContext.servletContext.contextPath}/ObiettivoControl" method="post">

                            <h4>RIDUZIONE CHILOMETRI</h4>

                            <div class="textCardUp">
                                <h6>Negli ultimi 7 giorni hai percorso in media <%=mediaKm%> km</h6><br>

                            </div>

                            <div class="textCard">
                                Quanti chilometri vuoi percorrere nei prossimi 7 giorni?<br>
                                <input id="chilometri_input" type="text" name="obiettivo" class="formCard" required onchange="kmObserver()">
                                <label id="km_l"></label>
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

                        <form id="fSpese" action="${pageContext.servletContext.contextPath}/ObiettivoControl" method="post">
                            <h4>RIDUZIONE SPESE CARBURANTE</h4>

                            <div class="textCardUp">
                                <h6>Negli ultimi 7 giorni hai speso in media <%=mediaCarburante%> euro.</h6><br>

                            </div>

                            <div class="textCard">
                                Quanto vuoi spendere nei prossimi 7 giorni?<br>
                                <input id="spese_input" type="text" name="obiettivo" class="formCard" required onchange="spesaObserver()">
                                <label id="spese_l"></label>
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
                        <form id="fMezzo" action="${pageContext.servletContext.contextPath}/ObiettivoControl" method="post">
                            <h4>UTILIZZO MEZZO ECO-SOSTENIBILE

                                <i class='bx bx-question-mark tooltip'>

                                <span class="tooltiptext">

                                    <strong>Quali sono i mezzi eco-sostenibili?</strong><br><br>
                                    -treno<br>
                                    -metro<br>
                                    -pullman<br>
                                    -qualsiasi mezzo privo di motore<br>
                                    -qualsiasi mezzo con motore elettrico<br>
                                    </span>
                                 </i>
                            </h4>

                            <div class="textCardUp">
                                <h6>Negli ultimi 7 giorni hai utilizzato <%=count%> volte un mezzo eco-sostenibile</h6><br>
                            </div>

                            <div class="textCard">
                                Quante volte vuoi utilizzare un mezzo ecosostenibile nei prossimi 7 giorni?<br>
                                <input id="mezzo_input" type="text" name="obiettivo" class="formCard" required onchange="mezzoObserver()">
                                <label id="mezzo_label"></label>
                                <input type="hidden" name="action" value="3">

                            </div>

                            <input class="buttonCard" type="submit" value="AGGIUNGI">

                            <!--<a class="buttonCard">Aggiungi</a>-->

                        </form>

                    </div>


                    <div class="cardDX">
                        <img src="img/ecoForm.png"
                             class="imgCard"/></div>
                </div>
            </div>


        </div>
    </div>


    <div id="list">
        <!-- parte destra -->


        <div id="titleList">
            Lista obiettivi
        </div>
        <br>

        <div class="dropdown">
            <button class="dropbtn">Filtra obiettivi per...</button>
            <div class="dropdown-content">
                <a href="${pageContext.servletContext.contextPath}/FiltroControl?filter=chilometri">Riduzione chilometri</a>
                <a href="${pageContext.servletContext.contextPath}/FiltroControl?filter=spesa">Riduzione spesa</a>
                <a href="${pageContext.servletContext.contextPath}/FiltroControl?filter=mezzo">Utilizzo mezzo eco </a>
                <a href="${pageContext.servletContext.contextPath}/FiltroControl?filter=allObb">Tutti</a>
            </div>
        </div>

        <div class="listaSpese">

            <%
                if(obiettivi.isEmpty()){
            %>
            No obiettivi
            <%
                }else{
                    for (int i=0;i<obiettivi.size();i++){

                        if(obiettivi.get(i).getTipoObiettivo().equalsIgnoreCase("Riduzione chilometri")){
            %>

                <div class="card-obiettivi <%=obiettivi.get(i).getStatus()%>">
                    <h3><%=obiettivi.get(i).getTipoObiettivo()%></h3><i class='bx bxs-down-arrow'></i>
                    <p>Status: <%=obiettivi.get(i).getStatus()%></p>
                    <p>Km percorsi: <%=obiettivi.get(i).getProgresso()%> &nbsp &nbsp &nbsp Km massimi: <%=obiettivi.get(i).getObiettivo()%></p>
                    <hr>
                    <p class="scadenza">Scadenza obiettivo: <%=obiettivi.get(i).getScadenza()%></p>
                </div>

            <%
            }else if(obiettivi.get(i).getTipoObiettivo().equalsIgnoreCase("Utilizzo mezzo eco")) {

            %>

                <div class="card-obiettivi <%=obiettivi.get(i).getStatus()%>">
                    <h3><%=obiettivi.get(i).getTipoObiettivo()%></h3><i class='bx bxs-down-arrow'></i>
                    <p>Status:  <%=obiettivi.get(i).getStatus()%></p>
                    <p>Utilizzo: <%=obiettivi.get(i).getProgresso()%> / <%=obiettivi.get(i).getObiettivo()%></p>
                    <hr>
                    <p class="scadenza">Scadenza obiettivo: <%=obiettivi.get(i).getScadenza()%></p>
                </div>

            <%
            }
            else{
            %>

                <div class="card-obiettivi <%=obiettivi.get(i).getStatus()%>">
                    <h3><%=obiettivi.get(i).getTipoObiettivo()%></h3><i class='bx bxs-down-arrow'></i>
                    <p>Status:  <%=obiettivi.get(i).getStatus()%></p>
                    <p>Euro spesi: <%=obiettivi.get(i).getProgresso()%> &nbsp &nbsp &nbsp Spesa massima: <%=obiettivi.get(i).getObiettivo()%></p>
                    <hr>
                    <p class="scadenza">Scadenza obiettivo: <%=obiettivi.get(i).getScadenza()%></p>
                </div>

            <%
                        }
                    }
                }
            %>

        </div>

    </div>


</div>

<script>
    $('.card-obiettivi').click(function() {
        clickToExpandCards($(this));
    });

    function clickToExpandCards($obj){
        var clickedElement = $obj;
        if (clickedElement.hasClass('expanded')) {
            clickedElement.removeClass('expanded');
        } else {
            clickedElement.addClass('expanded');
        }

    };
</script>
</body>
</html>
