const { fork } = require('child_process');

const forked = fork('fork_child.js');

forked.on('message', (msg) => {
  console.log('Message from child', msg);
});

forked.send({ hello: 'world' });
