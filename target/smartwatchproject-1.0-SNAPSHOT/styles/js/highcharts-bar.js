function doBar(_id,_title) {
        $('#'+_id).highcharts({
            chart: {
                type: 'bar',
                height: 200,
                backgroundColor:'rgba(255, 255, 255, 0.1)',
                spacingTop:0,
                spacingBottom:0,
                spacingRight:0,
                spacingLeft:0
               /* marginLeft:0,
                marginRight:0*/
            },
            exporting:{
                enabled: false
            },
            credits: {
                enabled: false
            },
            title: {
                text: _title
            },
            xAxis: {
                categories: ['Course à pieds', 'Vélo', 'Marche'],
                title: {
                    text: null
                }
            },
            yAxis: {
                min: 0,
                title: {
                    text: 'Nombre',
                    align: 'high'
                },
                labels: {
                    overflow: 'justify'
                }
            },
            tooltip: {
                valueSuffix: ''
            },
            plotOptions: {
                bar: {
                    dataLabels: {
                        enabled: true
                    }
                }
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'top',
                x: -40,
                y: 100,
                floating: true,
                borderWidth: 1,
                backgroundColor: ((Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'),
                shadow: true
            },
            credits: {
                enabled: false
            },
            series: [{
                name: 'Effectué',
                data: [107, 31, 635]
            }, {
                name: 'Restant',
                data: [133, 156, 947]
            }]
        });
}