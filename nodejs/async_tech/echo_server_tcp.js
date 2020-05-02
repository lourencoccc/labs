var net = require('net');


var server = net.createServer(function(socket) {
    // data events handled whenever new data has been read
    // on - response every time
    // once -  response only first time
    socket.on('data', function(data) {
        console.log('Data recived: ' + data);
        // Data is written (echoed back) to client
        socket.write(data);
    });
});

server.listen(8888);
