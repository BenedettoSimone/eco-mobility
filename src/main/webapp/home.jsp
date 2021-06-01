<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" xmlns="">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="home.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet"
          href="../contrast-bootstrap-pro/css/bootstrap.min.css"/>
    <link
            rel="stylesheet"
            href="../contrast-bootstrap-pro/css/cdb.css"/>
    <script
            src="../contrast-bootstrap-pro/js/cdb.js"></script>
    <script
            src="../contrast-bootstrap-pro/js/bootstrap.min.js">
    </script>
    <script src="https://kit.fontawesome.com/9d1d9a82d2.js"
            crossorigin="anonymous"></script>

</head>
<body>

<div class="row">

    <div id="navbar">
        <%@include file="navbar.jsp"%>
    </div>


    <div id="content">
        <div class="background-content">

            <div id="home-card">
                <h1>Home</h1>
                <h3>Bentornato Benedetto</h3>
                <img src="img/home-img.png">
            </div>


            <div id="obiettivi-content">

                <h5>Obiettivi in corso</h5>

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

            <div id="chart-content">

                <div class="row-chart">

                    <div class="column-chart1">

                        <div class="chart-card">

                            <h1>Media chilometri</h1>
                            <h5>Negli ultimi 7 giorni hai percorso in media 53 km.</h5>

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

</body>


<script
        src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.js">
</script>
<script>
    //line
    var ctxL = document.getElementById("chart").getContext('2d');
    var myLineChart = new Chart(ctxL, {
        type: 'line',
        data: {
            labels: ["Sab", "Dom", "Lun", "Mar", "Mer", "Gio", "Ven"],
            datasets: [{
                label: 'media km',
                data: [65, 59, 80, 81, 56, 55, 40],
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
</script>

<script>

    var ctx = document.getElementById("myChart").getContext('2d');
    var myChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: ["Sab", "Dom", "Lun", "Mar", "Mer", "Gio", "Ven"],
            datasets: [{
                label: 'Media spese',
                data: [12, 19, 3, 5, 2, 3],
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