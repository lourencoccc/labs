var http = require('http');
var fs = require('fs');

// Create HTTP server and use callback to define response logic
// http.createServer(function(req, res) {
//     if (req.url == '/') {
//         fs.readFile('./titles.json', function(err, data) {
//             if (err) {
//                 // If error occurs, log error and return “Server Error” to client
//                 console.error(err);
//                 res.end('Server Error');
//             } else {
//                 //Parse data from JSON text
//                 var titles = JSON.parse(data.toString());
//                 // Read HTML template and use callback when it’s loaded
//                 fs.readFile('./template.html', function(err, data) {
//                     if (err) {
//                         console.error(err);
//                         res.end('Server Error');
//                     } else {
//                         var tmpl = data.toString();
//                         // Assemble HTML page showing blog titles
//                         var html = tmpl.replace('%', titles.join('</li><li>'));
//                         res.writeHead(200, {'Content-Type': 'text/html'});
//                         // Send HTML page to user
//                         res.end(html);
//                     }
//                 });
//             }
//         });
//     }
// }).listen(8000, "127.0.0.1");

//After refactory

var server = http.createServer(function (req, res){
    getTitles(res);
}).listen(8000, "127.0.0.1");

function getTitles(res) {
    fs.readFile('./titles.json', function (err, data) {
        if (err) return hadError(err, res)
        getTemplate(JSON.parse(data.toString()), res)
    })
}

function getTemplate(titles, res) {
    fs.readFile('./template.html', function (err, data) {
        if (err) return hadError(err, res)
        formatHtml(titles, data.toString(), res)
    })
}

function formatHtml(titles, tmpl, res) {
    var html = tmpl.replace('%', titles.join('</li><li>'));
    res.writeHead(200, {'Content-Type': 'text/html'});
    res.end(html);
}

function hadError(err, res) {
    console.error(err)
    res.end('Server Error')
}
