function showComponentInfo(event) {
    // 在这里完成表格显示
    // window.alert(event.detail.name.substr(0,1));    // event.detail.name: 编号_零件名

    switch (event.detail.name.substr(0,1)){
        case 'A':
            document.getElementById('light').style.display='block';
            document.getElementById('fade').style.display='block'
            break;
        default:
            console.log("???");
    }
    myCreateFunction()

}

window.addEventListener('selectcomponent', showComponentInfo, false);

function myCreateFunction() {
    var table = document.getElementById("measureTable");
    console.log(table)
    var row = table.insertRow(0);
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    var cell4 = row.insertCell(3);
    cell1.innerHTML = measure1.id;
    cell2.innerHTML = measure1.order;
    cell3.innerHTML = measure1.number;
    cell4.innerHTML = measure1.name;

}
