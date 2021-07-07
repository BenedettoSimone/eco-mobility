<%@ page import="java.util.List" %>
<%@ page import="com.example.eco_mobility.DTO.ObiettiviDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%



    int[] km,carburante;
    km= (int[]) request.getAttribute("kmSettimanali");

    request.getSession().setAttribute("flag",0);
    carburante= (int[]) request.getAttribute("speseSettimanali");

    if(km==null || carburante==null){
        response.sendRedirect("./SpostamentiControl");
    }

    List<ObiettiviDTO> obiettiviInCorso= (List<ObiettiviDTO>) request.getSession().getAttribute("obiettiviInCorso");

%>
<!DOCTYPE html>
<html lang="en" xmlns="">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" href="css/home.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="../contrast-bootstrap-pro/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../contrast-bootstrap-pro/css/cdb.css"/>
    <script src="../contrast-bootstrap-pro/js/cdb.js"></script>
    <script src="../contrast-bootstrap-pro/js/bootstrap.min.js"></script>
    <script src="https://kit.fontawesome.com/9d1d9a82d2.js" crossorigin="anonymous"></script>
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

            <!--Home section banner-->
            <div id="home-card">
                <h1>Home</h1>
                <h3>Bentornato <%=ut.getNome()%></h3>
                <img src="img/home-img.png">
            </div>

            <!--Section obiettivi-->
            <div id="obiettivi-content">

                <h5>Obiettivi in corso</h5>


                    <div class="row-obiettivi">
                        <% if(obiettiviInCorso.isEmpty()==false){

                            for(ObiettiviDTO obb : obiettiviInCorso){

                              if(obb.getStatus().equals("in corso")){

                              if(obb.getTipoObiettivo().equalsIgnoreCase("Riduzione chilometri")){
                        %>
                        <div class="column-obiettivi">
                            <div class="card-obiettivi">
                                <h3><%=obb.getTipoObiettivo()%></h3>
                                <p>Status: in corso</p>
                                <p>Km percorsi: <%=obb.getProgresso()%> &nbsp &nbsp &nbsp Km massimi: <%=obb.getObiettivo()%></p>
                            </div>
                        </div>
                        <%
                                }else if(obb.getTipoObiettivo().equalsIgnoreCase("Utilizzo mezzo eco")) {

                                %>
                        <div class="column-obiettivi">
                            <div class="card-obiettivi">
                                <h3><%=obb.getTipoObiettivo()%></h3>
                                <p>Status: in corso</p>
                                <p>Utilizzo: <%=obb.getProgresso()%> / <%=obb.getObiettivo()%></p>
                            </div>
                        </div>
                        <%
                            }
                              else{
                        %>
                        <div class="column-obiettivi">
                            <div class="card-obiettivi">
                                <h3><%=obb.getTipoObiettivo()%></h3>
                                <p>Status: in corso</p>
                                <p>Euro spesi: <%=obb.getProgresso()%> &nbsp &nbsp &nbsp Spesa massima: <%=obb.getObiettivo()%></p>
                            </div>
                        </div>
                        <%
                            }
                        }
                        }
                            }else{
                        %>
                        <p class="no_obiettivo">Nessun obiettivo in corso. <a href="obiettivi.jsp">Imposta un nuovo obiettivo</a></p>
                        <%
                                }
                        %>

                    </div>
            </div>

            <!--Section chart-->
            <div id="chart-content">

                <div class="row-chart">

                    <div class="column-chart1">

                        <div class="chart-card">

                            <h1>Media chilometri</h1>
                            <h5>Negli ultimi 7 giorni hai percorso in media <%=mediaKm%> km.</h5>

                            <div class="card chart-container">
                                <canvas id="chart"></canvas>
                            </div>

                        </div>

                    </div>

                    <div class="column-chart2">

                        <div class="chart-card">


                            <h1>Media spese carburante</h1>
                            <h5>Negli ultimi 7 giorni hai speso in media <%=mediaCarburante%> euro.</h5>

                            <div class="card chart-container">
                                <canvas id="myChart"></canvas>
                            </div>

                        </div>


                    </div>

                </div>

            </div>

        </div>
    </div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.js"></script>
<script>



    window.onload=function getDate() {

        //trovo la data corrente (indice)
        const d = new Date();
        const days = ["Lun", "Mar", "Mer", "Gio", "Ven", "Sab", "Dom"];
        //indice giorno corrente
        var final = d.getDay();

        //trovo i nomi giorni
        var array2 = days.slice(0, final);
        var array3 = days.slice(final, 7);

        var array1 = array3.concat(array2);


        //line chart
        var ctxL = document.getElementById("chart").getContext('2d');
        var myLineChart = new Chart(ctxL, {
            type: 'line',
            data: {
                labels: [array1[0], array1[1], array1[2], array1[3], array1[4], array1[5], array1[6]],
                datasets: [{
                    label: 'Km percorsi',
                    data: [<%=km[6]%>, <%=km[5]%>, <%=km[4]%>, <%=km[3]%>, <%=km[2]%>, <%=km[1]%>, <%=km[0]%>],
                    backgroundColor: [
                        '#F1F6FF',
                    ],
                    borderColor: [
                        '#5a87e8',
                    ],
                    borderWidth: 2
                }
                ]
            },
            options: {
                responsive: true
            }
        });


        //bar chart
        var ctx = document.getElementById("myChart").getContext('2d');
        var myChart = new Chart(ctx, {
            type: 'bar',
            data: {
                labels: [array1[0], array1[1], array1[2], array1[3], array1[4], array1[5], array1[6]],
                datasets: [{
                    label: 'Spesa carburante',
                    data: [<%=carburante[6]%>, <%=carburante[5]%>, <%=carburante[4]%>, <%=carburante[3]%>, <%=carburante[2]%>, <%=carburante[1]%>, <%=carburante[0]%>],
                    backgroundColor: '#F1F6FF',
                    borderColor: '#5a87e8',

                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    yAxes: [{
                        ticks: {
                            beginAtZero: true
                        }
                    }]
                }
            }
        });

    }
</script>

</body>
</html>