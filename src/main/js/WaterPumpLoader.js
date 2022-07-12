import * as THREE from "three"

import {GLTFLoader} from "three/examples/jsm/loaders/GLTFLoader"
import {OrbitControls} from "three/examples/jsm/controls/OrbitControls"

var modelDirPath = "static/model/"

console.log("three.js版本号", window.__THREE__);

// 模型全局颜色设置
window.defaultColor = 0x333333;      // 初始颜色
window.selectedColor = 0xdddddd;    // 被选中时颜色

window.componentList = [];    // 零件数组
var rotatingComName = ["A_PRT0172_1090", "C_PRT0164_1028", "E_PRT0039_230", "G_PRT0149_912"]   // 需要旋转的零件名数组
var rotatingComponents = [];        // 需要旋转的零件对象数组


const scene = new THREE.Scene();
const camera = new THREE.PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000);
const renderer = new THREE.WebGLRenderer();
renderer.setSize(window.innerWidth, window.innerHeight);
renderer.shadowMap.enabled = true;
document.getElementById("output").appendChild(renderer.domElement);  // 将渲染器添加到output div中

// 添加坐标轴
// var axes = new THREE.AxesHelper(50);
// scene.add(axes);

// 加载模型
class Model {
   static #aModel = null;

   static async #loadModel() {
      let loader = new GLTFLoader();
      loader.setPath(modelDirPath);
      await loader.loadAsync("WaterPumpAttach.glb").then(afterLoad);
      return window.MODEL;
   }

   static async getInstance() {
      if(this.#aModel == null) {
         this.#aModel = await this.#loadModel();
      }
      return this.#aModel;
   }
}

function afterLoad (gltf) {
   scene.add(gltf.scene);
   window.MODEL = gltf;
   window.componentList = gltf.scene.children;
   // 设置初始颜色
   for (let i = 0; i < componentList.length; i++) {
      componentList[i].material = new THREE.MeshStandardMaterial({ color: defaultColor });
   }
   // 取得所有需要旋转的零件
   for(let i = 0; i < componentList.length; i++) {
      if(rotatingComName.indexOf(componentList[i].name) != -1) {
         rotatingComponents.push(componentList[i]);
      }
   }
}

var model = await Model.getInstance();

console.log("模型对象：");
console.log(model);

// 设置镜头位置方向
camera.position.set(5, 5, 5);
camera.lookAt(scene.position);

// 地面
var planeGeometry = new THREE.PlaneGeometry(100, 100);
var planeMaterial = new THREE.MeshLambertMaterial({ color: 0xcccccc });
var plane = new THREE.Mesh(planeGeometry, planeMaterial);
plane.rotation.x = -0.5 * Math.PI;
plane.position.set(15, -5, 0);
plane.receiveShadow = true;
scene.add(plane);

// 环境光源
var ambienLight = new THREE.AmbientLight(0xAAAAAA);
scene.add(ambienLight);

// 聚光灯
var spotLight = new THREE.SpotLight(0xFFFFFF);
spotLight.position.set(-60, 40, -60);
spotLight.castShadow = true;
spotLight.shadow.mapSize = new THREE.Vector2(2048, 2048);
spotLight.shadow.camera.far = 200;
spotLight.shadow.camera.near = 80;
scene.add(spotLight);

// 轨道控制器
var controls = new OrbitControls(camera, renderer.domElement);
controls.update();

// 点击选择零件高亮
var raycaster = new THREE.Raycaster();
var mouseVector = new THREE.Vector2();
var isMoved = false;          // 用于鼠标是否为拖动操作的标记
var selectedObj = null;       // 当前被选择的对象
var modelElem = document.getElementById("output");    // 取得显示模型的元素
var dElem = document.documentElement;

function onMouseDown(event) {
   isMoved = false;
}
function onMouseMove(event) {
   isMoved = true;
}
function onMouseUp(event) {
   if (isMoved) return;
   // 根据点击位置，计算相对窗口的单位向量
   // mouseVector.x = (event.clientX / window.innerWidth) * 2 - 1;
   // mouseVector.y = 1 - (event.clientY / window.innerHeight) * 2;

   // 根据点击位置，计算相对模型元素的单位向量（无滚动）
   // mouseVector.x = ((event.clientX - modelElement.offsetLeft) / modelElement.offsetWidth) * 2 - 1;
   // mouseVector.y = 1 - ((event.clientY - modelElement.offsetTop) / modelElement.offsetHeight) * 2;

   if(isClickOnModelElem(event.clientX, event.clientY)) {
      // 根据点击位置，计算相对模型元素的单位向量（滚动）
      mouseVector.x = ((event.clientX + dElem.scrollLeft - modelElem.offsetLeft) / modelElem.offsetWidth) * 2 - 1;
      mouseVector.y = 1 - ((event.clientY + dElem.scrollTop - modelElem.offsetTop) / modelElem.offsetHeight) * 2;

      raycaster.setFromCamera(mouseVector, camera);      // 设置raycaster
      var intersects = raycaster.intersectObjects(model.scene.children);
      if (intersects.length > 0) {
         var componentName = intersects[0].object.name;     // 零件名
         console.log(componentName);
         // 处理选中后颜色变化，排除不重要的模型
         if (componentName.search("nonsignificant") == -1) {
            // 更新颜色高亮
            if (selectedObj != null) { selectedObj.material.color.set(defaultColor); }
            selectedObj = intersects[0].object;
            intersects[0].object.material.color.set(selectedColor);

            // 选中零件事件
            var selectEvent = new CustomEvent("selectcomponent", {
               detail: { name: componentName }
            });
            window.dispatchEvent(selectEvent);
         }
      }
   }
   isMoved = false;
}

// 判断是否点击了模型元素
function isClickOnModelElem(x, y) {
   if(x + dElem.scrollLeft < modelElem.offsetLeft || x + dElem.scrollLeft > modelElem.offsetLeft + modelElem.offsetWidth) {
      return false;
   }
   if(y + dElem.scrollTop < modelElem.offsetTop || y + dElem.scrollTop > modelElem.offsetTop + modelElem.offsetHeight) {
      return false;
   }
   return true;
}

window.addEventListener('mousedown', onMouseDown, false);
window.addEventListener('mousemove', onMouseMove, false);
window.addEventListener('mouseup', onMouseUp, false);


renderScene();
function renderScene() {
   requestAnimationFrame(renderScene);	// 使浏览器平滑高效地绘制

   // 旋转零件
   for(let i in rotatingComponents) {
      rotatingComponents[i].rotation.y += 0.05
   }

   controls.update();      // 更新轨道控制器
   renderer.render(scene, camera);
}
