const { spawn } = require('child_process');

/*
One last important child process option to explain here is the detached option,
which makes the child process run independently of its parent process.
 */
const child = spawn('node', ['timer.js'], {
  detached: true,
  stdio: 'ignore'
});

/*
If the unref function is called on the detached process,
the parent process can exit independently of the child.
 */
child.unref();
