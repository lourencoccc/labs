function asyncFunction(callback) {
    setTimeout(callback, 0);
}
var color = 'blue';

(function(color) {
    asyncFunction(function() {
        console.log('The color is ' + color);
    });
})(color);

//https://developer.mozilla.org/en-US/docs/Web/JavaScript/Closures

color = 'green';

console.log("Color is "+color);
