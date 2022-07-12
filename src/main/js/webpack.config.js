const path = require('path');

module.exports = {
  entry: './WaterPumpLoader.js',
  output: {
    filename: 'WaterPumpLoader.js',
    path: path.resolve(__dirname, '../resources/static/js'),
  },
  mode: 'development',
  experiments: {
    topLevelAwait: true
  }
};