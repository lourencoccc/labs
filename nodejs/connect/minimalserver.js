var connect = require('connect');
var app = connect();
app.listen(3000);

// When call curl -i localhost:3000 by default connect
// return 404 because no have listeners:
//
// Cannot GET /
// dede@casa-notebook:~/lab/lab-nodejs$ curl -i localhost:3000
// HTTP/1.1 404 Not Found
// X-Content-Type-Options: nosniff
// Content-Type: text/html; charset=utf-8
// Content-Length: 13
// Date: Tue, 19 Jul 2016 07:33:10 GMT
// Connection: keep-alive
//
