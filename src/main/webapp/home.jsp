<%@ page import="java.util.List" %>
<%@ page import="com.example.eco_mobility.DTO.ObiettiviDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int[] km;
    km= (int[]) request.getAttribute("kmSettimanali");
    if(km==null){
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
                        %>
                        <div class="column-obiettivi">
                            <div class="card-obiettivi">
                                <h3><%=obb.getTipoObiettivo()%></h3>
                                <p>Status: in corso</p>
                                <p>Descrizione: <%=obb.getObiettivo()%></p>
                                <p></p>
                            </div>
                        </div>
                        <%
                                }
                            }else{
                        %>
                        nessun obiettivo in corso
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
                            <h5>Negli ultimi 7 giorni hai percorso in media <p id="mediaKm">null</p> km.</h5>

                            <div class="card chart-container">
                                <canvas id="chart"></canvas>
                            </div>

                        </div>

                    </div>

                    <div class="column-chart2">

                        <div class="chart-card">


                            <h1>Media chilometri</h1>
                            <h5>Negli ultimi 7 giorni hai percorso in media 53 km.</h5>

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



    //line chart
    var ctxL = document.getElementById("chart").getContext('2d');
    var myLineChart = new Chart(ctxL, {
        type: 'line',
        data: {
            labels: ["Sab", "Dom", "Lun", "Mar", "Mer", "Gio", "Ven"],
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
            labels: ["Sab", "Dom", "Lun", "Mar", "Mer", "Gio", "Ven"],
            datasets: [{
                label: 'Media spese',
                data: [],
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
</script>

</body>
</html>