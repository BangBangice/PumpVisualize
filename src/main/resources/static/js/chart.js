google.charts.load('current', {packages: ['corechart', 'line']});
google.charts.setOnLoadCallback(drawCurveTypes);

function drawCurveTypes() {



    var rows=new Array();
    for(data in dataList){
        var row=new Array();
        rows[data]=row;
        row[0]=dataList[data].datetime;
        row[1]=dataList[data].wcw103MV;
    }


    var data = new google.visualization.DataTable();
    data.addColumn('string', 'X');
    data.addColumn('number', 'Dogs');

    data.addRows(rows);

    var options = {
        hAxis: {
            title: 'DateTime'
        },
        vAxis: {
            title: 'Measured Value'
        },
        series: {
            1: {curveType: 'function'}
        }
    };

    var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
    chart.draw(data, options);
}