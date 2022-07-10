function showComponentInfo(event) {
    // 在这里完成表格显示
    // window.alert(event.detail.name);    // event.detail.name: 编号_零件名
    document.getElementById('light').style.display='block';
    document.getElementById('fade').style.display='block'
}

window.addEventListener('selectcomponent', showComponentInfo, false);
