var http = require('http'),
    formidable =  require('formidable');

var server = http.createServer(function(req, res){
    switch (req.method) {
        case 'GET':
            show(req, res);
            break;
        case 'POST':
            upload(req, res);
            break;
    }
});


function show(req, res) {
    var html = ''
        + '<form method="post" action="/" enctype="multipart/form-data">'
        + '<p><input type="text" name="name" /></p>'
        + '<p><input type="file" name="file" /></p>'
        + '<p><input type="submit" value="Upload" /></p>'
        + '</form>';
    res.setHeader('Content-Type', 'text/html');
    res.setHeader('Content-Length', Buffer.byteLength(html));
    res.end(html);
}

//1. Install formidable through npm.
//2. Create an IncomingForm instance.
//3. Call form.parse() with the HTTP request object.
//4. Listen for form events field , file , and end .
//5. Use formidable’s high-level API .

function upload(req, res) {
    // upload logic
    if (!isFormData(req)) {
        res.statusCode = 400;
        res.end('Bad Request');
        return;
    }
    var form = new formidable.IncomingForm();
    /*
    form.on('field', function(field, value){
        console.log(field);
        console.log(value);
    });
    
    form.on('file', function(name, file){
        console.log(name);
        console.log(file);
    });
    
    form.on('end', function(){
        res.end('upload complete!');
    });

    form.parse(req);*/

    //production mode
        
    form.parse(req, function(err, fields, files){
        console.log(fields);
        console.log(files);
        res.end('upload complete!');
    });

    form.on('progress', function(bytesReceived, bytesExpected){
        var percent = Math.floor(bytesReceived / bytesExpected * 100);
        console.log(percent);
        //TODO Use WebSocket or Socket.IO to show feedback for user
    });


}

function isFormData(req) {
    var type = req.headers['content-type'] || '';
    return 0 == type.indexOf('multipart/form-data');
}

server.listen(3000);

