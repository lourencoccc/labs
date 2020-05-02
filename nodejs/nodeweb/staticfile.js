var http = require('http'),
    parse = require('url').parse,
    join = require('path').join,
    fs = require('fs');

var root = __dirname;
/*
1 Someone requests a file from your server.
2 Your Node server receives the request, and your app logic
attempts to read the file.
3 The file is streamed to the server as a ReadStream instance.
4 The file ReadStream is piped back to the HTTP response to
complete the client request.
*/
var server = http.createServer(function(req, res){
    var url = parse(req.url),
        path = join(root, url.pathname);

    //Optimizing data transfer with Stream#pipe()
    fs.stat(path, function(err, stat){
        if (err) {
            //https://nodejs.org/api/errors.html#errors_error_code
            if ('ENOENT' == err.code) {
                res.statusCode = 404;
                res.end('Not Found');
            } else {
                res.statusCode = 500;
                res.end('Internal Server Error');
            }
        } else {
            //Set Content-Length using stat object
            res.setHeader('Content-Length', stat.size);
            var stream = fs.createReadStream(path);
            stream.pipe(res);
            stream.on('error', function(err){
                res.statusCode = 500;
                res.end('Internal Server Error');
            });
        }
    });

    //or no perfomatic

    //Write file data to response
    //stream.on('data', function(chunk){
    //    res.write(chunk);
    //});

    //stream.on('end', function(){
        //End response when file is complete
    //    res.end();
    //});
    //console.log(path);
    //console.log(root);
});

server.listen(3000);
