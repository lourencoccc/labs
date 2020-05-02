const { spawn } = require('child_process');


const childFind = spawn('find . -type f | wc -l', {
  stdio: 'inherit',
  shell: true,
  cwd: '/home/Downloads'
});

childFind.on('error', error => {
    console.log(error);
});

const child = spawn('echo $ANSWER', {
  stdio: 'inherit',
  shell: true,
  env: { ANSWER: 42 },
});
