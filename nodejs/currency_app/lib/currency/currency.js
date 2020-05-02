var realDollar = 0.25;

function roundTwoDecimals(amount) {
    return Math.round(amount * 100) / 100;
}
exports.RealToUS = function(real) {
    return roundTwoDecimals(real * realDollar);
}

exports.USToReal = function(us) {
    return roundTwoDecimals(us / realDollar);
}
