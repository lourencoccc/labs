
//Setup function can be called multiple
//times with different configurations
function setup(format) {
    //Logger component uses a regexp to match request properties
    var regexp = /:(\w+)/g;
    return function logger(req, res, next) {
        var str = format.replace(regexp, function(match, property){
            return req[property];
        });
        console.log(str);
        next();
    }
}

module.exports = setup;
