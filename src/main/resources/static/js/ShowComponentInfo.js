function showComponentInfo(event) {
    // 在这里完成表格显示
    window.alert(event.detail.name);    // event.detail.name: 编号_零件名
}

window.addEventListener('selectcomponent', showComponentInfo, false);

