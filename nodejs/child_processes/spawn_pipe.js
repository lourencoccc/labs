const { spawn } = require('child_process');

//https://medium.freecodecamp.org/node-js-streams-everything-you-need-to-know-c9141306be93

const find = spawn('find', ['.', '-type', 'f']);
const wc = spawn('wc', ['-l']);

//find . -type f | wc -l
find.stdout.pipe(wc.stdin);

wc.stdout.on('data', (data) => {
  console.log(`Number of files ${data}`);
});
