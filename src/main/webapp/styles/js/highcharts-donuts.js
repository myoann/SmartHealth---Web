function doDonut(_id,_title){
    var colors = Highcharts.getOptions().colors,
        categories = ['50%'],
        data = [{
            y: 100,
            color: colors[0],
            drilldown: {
                name: 'd',
                categories: [''],
                data: [100],
                color: colors[0]
            }
        }],
        browserData = [],
        versionsData = [],
        i,
        j,
        dataLen = data.length,
        drillDataLen,
        brightness;


    // Build the data arrays
    for (i = 0; i < dataLen; i += 1) {

        // add browser data
        browserData.push({
            name: categories[i],
            y: data[i].y/*,
            color: data[i].color*/
        });

        // add version data
        drillDataLen = data[i].drilldown.data.length;
        for (j = 0; j < drillDataLen; j += 1) {
            brightness = 0.2 - (j / drillDataLen) / 5;
            versionsData.push({
                name: data[i].drilldown.categories[j],
                y: data[i].drilldown.data[j],
                color: Highcharts.Color(data[i].color).brighten(brightness).get()
            });
        }
    }

    // Create the chart
    $('#'+_id).highcharts({
        chart: {
         //   backgroundColor:'rgba(255, 255, 255, 0.1)',
            height:200,
            type: 'pie',
            spacingTop:0,
            spacingBottom:0,
            spacingRight:0,
            spacingLeft:0,
            marginTop:0,
            marginBottom:0,
            marginLeft:0,
            marginRight:0
        },
        exporting:{
            enabled: false
        },
        credits: {
            enabled: false
        },
        title: {
            text: _title,
            verticalAlign: 'bottom', 
            y: -10,
            style: {
                fontSize:"12px"
            }
        },
        yAxis: {
            title: {
                text: 'Total percent'
            }
        },
        plotOptions: {
            pie: {
                shadow: false,
                center: ['50%', '50%']
            }
        },
        tooltip: {
            valueSuffix: '%'
        },
        series: [{
            name: 'Browsers',
            data: browserData,
            size: '40%',
            dataLabels: {
                color: 'black',
                style: {
                    fontSize:"22px"
                },
                distance: -45
            }
        }, {
            name: 'Versions',
            data: versionsData,
            size: '100%',
            innerSize: '80%',
            dataLabels: {
                connectorWidth: 0
            }
        }]
    });
}