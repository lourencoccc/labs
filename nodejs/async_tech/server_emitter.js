var EventEmitter = require('events').EventEmitter;
var net =  require('net');

var channel = new EventEmitter();

channel.on('join', function() {
    console.log("Welcome! ");
});

var server = net.createServer(function (client) {
    var id = client.remoteAddress + ':' + client.remotePort;
    console.log('conected ')
    channel.emit('join');
});

server.listen(8888);
