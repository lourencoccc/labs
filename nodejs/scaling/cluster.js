const cluster = require('cluster');
const os = require('os');

//https://medium.freecodecamp.org/scaling-node-js-applications-8492bd8afadc


if (cluster.isMaster) {
  const cpus = os.cpus().length;

  console.log(`Forking for ${cpus} CPUs`);
  for (let i = 0; i<cpus; i++) {
    cluster.fork();
  }
  //node --harmony cluster.js
  Object.values(cluster.workers).forEach(worker => {
    worker.send(`Hello Worker ${worker.id}`);
  });
} else {
  require('./server');
}
