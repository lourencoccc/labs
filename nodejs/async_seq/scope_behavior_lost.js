function asyncFunction(callback) {
    setTimeout(callback, 200);
}
var color = 'blue';
asyncFunction(function() {
    //This is executed last (200 ms later).
    console.log('The color is ' + color);
});

color = 'green';

console.log('Color is ' + color);
