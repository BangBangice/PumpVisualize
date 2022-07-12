/**
 * 将指定的零件设置为指定的颜色
 * @param id 零件字母编号，取值A-H不区分大小写，对应关系详见水泵介绍文档文档
 * @param color rgb颜色
 */
window.setComponentColor = function(id="A", color=0xff0000) {
    id = id.toUpperCase();
    var componentList = MODEL.scene.children;
    for(let i = 0; i < componentList.length; i++) {
        if(componentList[i].name[0] == id) {
            componentList[i].material.color.set(color);
        }
    }
}

/**
 * 重置所有零件颜色
 */
window.resetColor = function() {
    var componentList = MODEL.scene.children;
    for(let i = 0; i < componentList.length; i++) {
        componentList[i].material.color.set(0x333333);
    }
}