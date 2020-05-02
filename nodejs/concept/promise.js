
/*
Um Promise está um destes estados:
    pending (pendente): Estado inicial, que não foi realizada nem rejeitada.
    fulfilled (realizada): sucesso na operação.
    rejected (rejeitado):  falha na operação.
    settled (estabelecida): Que foi realizada ou rejeitada.

Metódos

Promise.all(lista)
Retorna uma promise que é resolvida quando todas as promises no argumento
lista forem resolvidas ou rejeitada assim que uma das promises da lista for rejeitada.

Promise.race(lista)
Retorna uma promise que resolve ou rejeita assim que uma das promises do
argumento lista resolve ou rejeita, com um valor ou o motivo daquela promise.


Promise.reject(motivo)
Retorna um objeto Promise que foi rejeitado por um dado motivo.

Promise.resolve(valor)
Retorna um objeto Promise que foi resolvido com um dado valor. Se o valor
possui um método then (thenable), a promise retornada "seguirá" este método,
adotando esse estado eventual; caso contrário a promise retornada será
realizada com o valor.

Geralmente, se você quer saber se um valor é uma promise ou não, utilize
Promise.resolve(valor) e trabalhe com a valor de retorno que é sempre uma promise.


Promise.prototype.catch(onRejected)
Adiciona um callback que trata rejeçãopara a promise e, retorna uma nova promise
resolvendo o valor retornado do callback, se ele for chamado, ou para seu valor
original de conclusão se a promise for realizada.

Promise.prototype.then(onFulfilled, onRejected)
diciona os métodos de tratamento da realização e rejeiçãoda promise e,
retorna uma nova promise resolvendo para o valor do método chamado.
*/


var promise = new Promise(function(resolve, reject) {
  resolve(10);
});

promise.then(function(val) {
  console.log("F1: return val + 2");
  console.log("Val = "+val); // 1
  return val + 2;
}).then(function(val) {
  console.log("F2: return val + 3");
  console.log("Val = "+val); // 3
  return val+3;
}).then(function(val) {
  console.log("F3: don't return");
  console.log("Val = "+val); // 6
}).then(function(val) {
  console.log("F4: don't return");
  console.log("Val = "+val); // undefined
})
