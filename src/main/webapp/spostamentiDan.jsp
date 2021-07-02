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



%>
<html>
<head>
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


            <div id="alert">
                <span class="closebtn-error" onclick="this.parentElement.style.display='none';">&times;</span>
                <strong>Errore! </strong> Impossibile aggiungere due obiettivi dello stesso tipo in una settimana.
            </div>

            }



              <div id="success">
                   <span class="closebtn-success" onclick="this.parentElement.style.display='none'; onDeleteMessage()">&times;</span>
                   <strong></strong>Obiettivo aggiunto con <strong>successo.</strong>
               </div>


            <div id="titleContent">
                OBIETTIVI
            </div>

            <div id="list-responsive">
                <!-- card UTILIZZO MEZZO ECO -->
                <div id="cardECO" class="card">
                    <div class="cardSX">
                        <form id="fMezzo" action="" method="post">
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
                                <h6>Negli ultimi 7 giorni hai utilizzato 6 volte un mezzo eco-sostenibile</h6><br>
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
            Lista Obiettivi
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



                <div class="card-obiettivi ">
                    <h3></h3><i class='bx bxs-down-arrow'></i>
                    <p>Status:</p>
                    <p>Km percorsi:  &nbsp &nbsp &nbsp Km massimi: </p>
                    <hr>
                    <p class="scadenza">Scadenza obiettivo: </p>
                </div>

            <div class="card-obiettivi ">
                <h3></h3><i class='bx bxs-down-arrow'></i>
                <p>Status:</p>
                <p>Km percorsi:  &nbsp &nbsp &nbsp Km massimi: </p>
                <hr>
                <p class="scadenza">Scadenza obiettivo: </p>
            </div>


            <div class="card-obiettivi ">
                <h3></h3><i class='bx bxs-down-arrow'></i>
                <p>Status:</p>
                <p>Km percorsi:  &nbsp &nbsp &nbsp Km massimi: </p>
                <hr>
                <p class="scadenza">Scadenza obiettivo: </p>
            </div>




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
