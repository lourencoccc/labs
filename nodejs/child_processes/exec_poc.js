const { exec } = require('child_process');

exec('find . -type f | wc -l', (err, stdout, stderr) => {
  if (err) {
    console.error(`exec error: ${err}`);
    return;
  }

  console.log(`Number of files ${stdout}`);
});

/*
The exec function is a good choice if you need to use the shell syntax and
 if the size of the data expected from the command is small.
 (Remember, exec will buffer the whole data in memory before returning it.)

 The spawn function is a much better choice when the size of the data expected
 from the command is large, because that data will be streamed with the
 standard IO objects.
 */
