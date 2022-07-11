function showComponentInfo(event) {
    // 在这里完成表格显示
    // window.alert(event.detail.name.substr(0,1));    // event.detail.name: 编号_零件名

    switch (event.detail.name.substr(0,1)){
        case 'A':
            myCreateFunction(measure1);
            break;
        case 'B':
            myCreateFunction(measure2);
            break;
        case 'C':
            myCreateFunction(measure3);
            break;
        case 'D':
            myCreateFunction(measure4);
            break;
        case 'E':
            myCreateFunction(measure5);
            break;
        case 'F':
            myCreateFunction(measure6);
            break;
        default:
            console.log("???");
    }
    document.getElementById('light').style.display='block';
    document.getElementById('fade').style.display='block';
}
function myCreateFunction(measureAll) {
    var table = document.getElementById("cTable");
    let totalRowCount = table.rows.length;
    for (var i=1;i<totalRowCount;i++){
        table.deleteRow(1);
    }
    totalRowCount = table.rows.length;
    for (index in measureAll) {
        let measure=measureAll[index];
        var row = table.insertRow(totalRowCount++);
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);
        var cell4 = row.insertCell(3);
        cell1.innerHTML = measure.order_;
        cell2.innerHTML = measure.number;
        cell3.innerHTML = measure.name;
        cell4.innerHTML = "<button  onclick=\"location.href='line_chart'\">查看折线图</button>"
    }
}

window.addEventListener('selectcomponent', showComponentInfo, false);

