* 这里是一个nodejs的工作目录，WaterPumpLoader.js是加载水泵模型的源代码
* 项目文件中的src/main/resources/static/js目录中的WaterPumpLoader.js是项目运行真正使用的js
* 要修改源代码并应用到项目中需要完成如下步骤

### 修改WaterPumpLoader.js的步骤

1. 完成修改js代码（好像是废话
2. 本地安装node.js，已安装可以跳过
3. 在当前目录打开终端
   * idea自带有终端，但是工作目录不同，需要先`cd .\src\main\js`
4. 首次修改时需要先执行`npm install`，之后可以跳过这一步
5. 在终端中执行`npm run build`命令（本地需要安装`nodejs`）
   * 执行完毕后，修改后的js文件将自动生成到static目录中
