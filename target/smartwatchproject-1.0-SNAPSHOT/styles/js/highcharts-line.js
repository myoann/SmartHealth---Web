 function doLine(_id,_title,data_title,data_values,nom){
     
    var array = data_values.split(",");
    var array2 = data_title.split(",");
    var mySeries = [];
    for (var i = 0; i < array.length; i++) {
        mySeries.push([parseInt(array[i])]);
    }
    var categories = [];
    for (var i = 0; i < array2.length; i++) {
        categories.push([array2[i]]);
    }
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
            categories: categories
        },
        yAxis: {
            title: {
                text: ''
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [{
            name: nom,
            data: mySeries
        }]
    })
}