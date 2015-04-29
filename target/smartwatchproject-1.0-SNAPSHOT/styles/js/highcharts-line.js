 function doLine(_id,_title){
    $('#'+_id).highcharts({
        chart:{
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
            text: _title,
            x: -20 //center
        },
        xAxis: {
            categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
                'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
        },
        yAxis: {
            title: {
                text: 'Temperature (°C)'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: '°C'
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [{
            name: 'test',
            data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6]
        }]
    })
}