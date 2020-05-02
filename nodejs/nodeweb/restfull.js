//POST - Add items to the to-do list
//GET - Display a listing of the current items
//DELETE - Remove items from the to-do list
//PUT - Should modify existing items
var http = require('http');
var url = require('url');
var items = [];
//The data store is a regular JavaScript Array in memory.
var server = http.createServer(function(req, res){
    //req.method is the HTTP method requested.
    //https://www.w3.org/Protocols/HTTP/HTRESP.ht
    switch (req.method) {
        case 'POST':
            var item = '';
            //Encode incoming data events as UTF-8 strings.
            req.setEncoding('utf8');

            req.on('data', function(chunk){
                //Concatenate data chunk onto the buffer.
                item += chunk;
            });

            req.on('end', function(){
                //Push complete new item onto the items array.
                items.push(item);
                res.end('OK\n');
            });
            break;
        case 'GET':
            //To speed up responses, the Content-Length field should be sent with
            //your response when possible
            var body = items.map(function(item, i){
                return i + ') ' + item;
            }).join('\n');
            res.setHeader('Content-Length', Buffer.byteLength(body));
            res.setHeader('Content-Type', 'text/plain; charset="utf-8"');
            res.end(body);
            res.end();
            break;
        case 'DELETE':
            //Add DELETE case to the switch statement
            var path = url.parse(req.url).pathname;
            var i = parseInt(path.slice(1), 10);
            if (isNaN(i)) { //Check that number is valid
                res.statusCode = 400;
                res.end('Invalid item id');
            } else if (!items[i]) { //Ensure requested index exists
                res.statusCode = 404;
                res.end('Item not found');
            } else {
                //Delete requested item
                items.splice(i, 1);
                res.end('OK\n');
            }
            break;
        case 'PUT':
            //Add DELETE case to the switch statement
            var path = url.parse(req.url).pathname;
            var i = parseInt(path.slice(1), 10);
            var item = '';
            req.on('data', function(chunk){
                //Concatenate data chunk onto the buffer.
                item += chunk;
            });
            req.on('end', function(){
                if (isNaN(i)) { //Check that number is valid
                    res.statusCode = 400;
                    res.end('Invalid item id');
                } else if (!items[i]) { //Ensure requested index exists
                    res.statusCode = 404;
                    res.end('Item not found');
                } else {
                    items[i] = item;
                    res.end('OK\n');
                }
            });
            break;
    }
});

server.listen(3000, function(){
    console.log("RESTFull Todo List listen on port 3000")
});
