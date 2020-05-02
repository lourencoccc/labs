// This file is required by the index.html file and will
// be executed in the renderer process for that window.
// All of the Node.js APIs are available in this process.
var addon = require('hello_cpp_addon/build/Release/hello');

console.log(addon.hello()); // 'world'
