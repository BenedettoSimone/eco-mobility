//line chart
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



//bar chart
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