//Path uses ./ to indicate that module exists
//within same directory as application script
var currency = require('./lib/currency');
var Currency = require('./lib/currency2');

console.log('50 Brasil reais equals this amount of US dollars:');
console.log(currency.RealToUS(50));
//Use currency module’s canadianToUS function
console.log('30 US dollars equals this amount of Brasil reais:');
console.log(currency.USToReal(30));;

var canadianDollar = 0.91;
var currency2 = new Currency(canadianDollar);
console.log('Use Currency2');
console.log(currency2.canadianToUS(50));
