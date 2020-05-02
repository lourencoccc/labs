/*
When Node’s HTTP parser reads in and parses request data, it makes that data
available in the form of data events that contain chunks of parsed data ready to be
handled by the program:
*/
var http = require('http')

var server = http.createServer(function(req, res){

    //A chunk is now a utf8 string instead of a Buffer.
    req.setEncoding('utf8')

    //Data events are fired whenever a new chunk of data has been read.
    req.on('data', function(chunk){
        //A chunk, by default, is a Buffer object (a byte array).
        console.log('parsed', chunk);
    });

    //The end event is fired when everything has been read.
    req.on('end', function(){
        console.log('done parsing');
        res.end()
    });
});

server.listen(3000, function(){
    console.log("HTTP Server parsers listen on port 3000")
});
