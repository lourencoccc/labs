var http = require('http');
var url = require('url');
var server = http.createServer(function(request, response){
    response.writeHead(200, {"Content-Type": "text/html"});
    response.write("<h1>Dados da query string</h1>");
    var result = url.parse(request.url, true);
    // href: Retorna a url completa: ‘http://user:pass@host.com:8080/p/a/t/h?
    // query=string#hash’
    response.write("<h2> href : "+request.url +"</h2>");
    // protocol: Retorna o protocolo: ‘http’
    response.write("<h2> protocol : "+result.protocol +"</h2>");
    // host: Retorna o domínio com a porta: ‘host.com:8080’
    response.write("<h2> host : "+result.host +"</h2>");
    // auth: Retorna dados de autenticação: ‘user:pass’
    response.write("<h2> auth : "+result.auth +"</h2>");
    // hostname: Retorna o domínio: ‘host.com’
    response.write("<h2> hostname : "+result.hostname +"</h2>");
    // port: Retorna a porta: ‘8080’
    response.write("<h2> port : "+result.port +"</h2>");
    // pathname: Retorna os pathnames da url: ‘/p/a/t/h’
    response.write("<h2> pathname : "+result.pathname +"</h2>");
    // search: Retorna uma query string: ‘?query=string’
    response.write("<h2> search : "+result.search +"</h2>");
    // path:Retorna a concatenação de pathname com query string:
    // ‘/p/a/t/h?query=string’
    response.write("<h2> path : "+result.path +"</h2>");
    // query: Retorna uma query string em JSON: {‘query’:’string’}
    response.write("<h2> query : "+result.query +"</h2>");
    // hash: Retorna ancora da url: ‘#hash’
    response.write("<h2> hash : "+result.hash +"</h2>");

    for(var key in result.query ){
        response.write("<h2>"+key+" : "+result.query[key]+"</h2>");
    }
    response.end();
});

server.listen(3000, function(){
    console.log('Servidor http.');
});
