const http = require('http');
const pid = process.pid;

//https://medium.freecodecamp.org/scaling-node-js-applications-8492bd8afadc

http.createServer((req, res) => {
  for (let i=0; i<1e7; i++); // simulate CPU work
  res.end(`Handled by process ${pid}`);
}).listen(8080, () => {
  console.log(`Started process ${pid}`);
});

process.on('message', msg => {
  console.log(`Message from master: ${msg}`);
});
