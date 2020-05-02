const { spawn } = require('child_process');

/*
Spawned Child Processes
The spawn function launches a command in a new process and we can use it to
pass that command any arguments. For example, here’s code to spawn a
new process that will execute the pwd command.
 */

const child = spawn('pwd');

child.on('exit', function (code, signal) {
  console.log('child process exited with ' +
              `code ${code} and signal ${signal}`);
});

child.on('error', (error) => {
  console.error(`child process error:\n${error}`);
});

child.stdout.on('data', (data) => {
  console.log(`child stdout:\n${data}`);
});

child.stderr.on('data', (data) => {
  console.error(`child stderr:\n${data}`);
});


const childFind = spawn('find', ['.', '-type', 'f']);

childFind.on('exit', function (code, signal) {
  console.log('childFind process exited with ' +
              `code ${code} and signal ${signal}`);
});

childFind.on('error', (error) => {
  console.error(`childFind process error:\n${error}`);
});

childFind.stdout.on('data', (data) => {
  console.log(`childFind stdout:\n${data}`);
});

/*
If an error occurs during the execution of the command, for example,
if we give find an invalid destination above, the child.stderr data event
handler will be triggered and the exit event handler will report an exit
code of 1 if we give find an invalid destination above, the child.stderr
data event handler will be triggered and the exit event handler will
report an exit code of 1
*/
childFind.stderr.on('data', (data) => {
  console.error(`childFind stderr:\n${data}`);
});
