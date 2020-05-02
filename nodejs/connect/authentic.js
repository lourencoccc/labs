var connect = require('connect');
var util = require('util');
var logger = require('./lib/logger.js')


function hello(req, res) {
    console.log('Hello %s \n', req.url);
    res.setHeader('Content-Type', 'text/plain');
    res.end('hello world');
}

function  authenticateWithDatabase(user, pass, callback){
    if( user == 'loki' && pass == 'ferret' ){
        callback();
    }else{
        callback('User or password not valid');
    }
    
}
function restrict(req, res, next) {
    var authorization = req.headers.authorization;
    if (!authorization) return next(new Error('Unauthorized'));
    
    var parts = authorization.split(' ');
    var scheme = parts[0];
    var auth = new Buffer(parts[1], 'base64').toString().split(':');
    var user = auth[0];
    var pass = auth[1];

    authenticateWithDatabase(user, pass, function (err) {
        if (err) return next(err);
        next();
    });

}

function admin(req, res, next) {
    switch (req.url) {
        case '/':
            res.end('try /users');
            break;
        case '/users':
            res.setHeader('Content-Type', 'application/json');
            res.end(JSON.stringify(['tobi', 'loki', 'jane']));
            break;
    }
}

//When a string is the first argument to .use(), Connect will
//only invoke the middleware when the prefix URL matches.

connect()
    .use(logger(':method :url'))
    .use('/admin', restrict)
    .use('/admin', admin)
    .use('/hello', hello)
    .listen(3000);

//cur
//
