
//Node provides HTTP server and client interfaces through the http module:
var http = require('http');

var server = http.createServer(function(req, res){
    // handle request function
    reponse302(req,res);
});

var reponseHello = function (req, res) {
    res.write('Hello World');
    res.setHeader('Content-Length', bodyList.length);
    res.setHeader('Content-Type', 'text/plain');
    res.end();
}

var reponse302 =  function (req, res) {
    var url = 'http://google.com';
    var body = '<p>Redirecting to <a href="' + url + '">'
        + url + '</a></p>';
    res.setHeader('Location', url);
    res.setHeader('Content-Length', body.length);
    res.setHeader('Content-Type', 'text/html');
    res.statusCode = 200;
    res.end(body);
}

server.listen(3000, function(){
    console.log("HTTP Server listen on port 3000")
});
