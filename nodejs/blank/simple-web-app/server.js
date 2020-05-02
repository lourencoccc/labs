//Built-in http module provides HTTP server and client functionality
var http = require('http');
//Built-in fs module provides filesystem-related functionality
var fs = require('fs');
//Built-in path module provides filesystem path–related functionality
var path = require('path');
//Add-on mime module provides ability to derive a MIME
//type based on a filename extension
var mime = require('mime');
//cache object is where the contents of cached files are stored
var cache = {};

function send404(response) {
    response.writeHead(404, {'Content-Type': 'text/plain'});
    response.write('Error 404: resource not found.');
    response.end();
}

function sendFile(response, filePath, fileContents) {
    response.writeHead(200,
            {"content-type": mime.lookup(path.basename(filePath))});
    response.end(fileContents);
}

//Serving static files
function serveStatic(response, cache, absPath) {
    //Check if file is cached in memory
    if (cache[absPath]) {
       //Serve file from memory
       sendFile(response, absPath, cache[absPath]);
    } else {
        fs.exists(absPath, function(exists) {
            //Check if file exists
            if (exists) {
                //Read file from disk
                fs.readFile(absPath, function(err, data) {
                    if (err) {
                        send404(response);
                    } else {
                        cache[absPath] = data;
                        //Serve file read from disk
                        sendFile(response, absPath, data);
                    }
                });
            } else {
                // Send HTTP 404 response
                send404(response);
            }
        });
    }
}

/*
* Create HTTP server, using anonymous function to define per-request behavior
*/
var server = http.createServer(function(request, response) {
    var filePath = false;
    if (request.url == '/') {
        //Determine HTML file to be served by default
        filePath = 'public/index.html';
    } else {
        //Translate URL path to relative file path
        filePath = 'public' + request.url;
    }
    var absPath = './' + filePath;
    //Serve static file
    serveStatic(response, cache, absPath);
});

server.listen(3000, function() {
    console.log("Server listening on port 3000.");
});
