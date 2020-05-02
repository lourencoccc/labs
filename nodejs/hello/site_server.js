var http =  require('http');
var url =  require('url');
var fs =  require('fs');

var server =  http.createServer(function(request, response){

    var result = url.parse(request.url, true);
    var htmlPath = result.path == '/' ? './site/artigos.html' :'./site'+result.path+'.html';
    var erroPath = './site/erro.html';
    // console.log(fs.existsSync(htmlPath));

    fs.exists(htmlPath, (exists) => {
        response.writeHeader(200, {'Content-Type': 'text/html'});
        if(exists){
            fs.readFile(htmlPath, function(err, html){
                response.end(html);
            });
        }else{
            fs.readFile(erroPath, function(err, html){
                response.end(html);
            });
        }
    });

    // verificação syncrona
    // if(fs.existsSync(htmlPath)){
    //     fs.readFile(htmlPath, function(err, html){
    //         response.writeHeader(200, {'Content-Type': 'text/html'});
    //         response.end(html);
    //     });
    // } else{
        // fs.readFile(erroPath, function(err, html){
        //     response.writeHeader(200, {'Content-Type': 'text/html'});
        //     response.end(html);
        // });
    // }
});

server.listen(3000, function(){
    console.log('Servidor http.');
});
