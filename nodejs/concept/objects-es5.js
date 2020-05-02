

//Objct/Class
var Person = function (name, age) {
  //constructor
  console.log('Person - constructor');
  //properties
  this.name = name
  this.age = age
};

Person.prototype.tellAge = function () {
  console.log(this.age);
};

var person1 =  new Person();
var person2 =  new Person('Joao', 30);

console.log('Person1 name '+ person1.name); //undefined
console.log('Person2 name '+ person2.name); //Joao

person2.tellAge();//30

//Extends

//define classe Pessoa
function Pessoa () {}

Pessoa.prototype.caminhar =  function () {
  console.log('Pessoa - Estou caminhando');
};

Pessoa.prototype.dizOi =  function () {
  console.log('Pessoa - Oi');
};

function Estudante () {
  //chama o construtor pai
  Pessoa.call(this);
}

// herda de Pessoa
//Old Estudante.prototype = new Pessoa();
Estudante.prototype = Object.create(Pessoa.prototype);

// adiciona o método dizOi
Estudante.prototype.dizOi = function(){
  console.log('Oi, eu sou estudante');
}

// corrige o ponteiro construtor, que aponta para Pessoa
Estudante.prototype.constructor = Estudante;

// adiciona o método dizTchau
Estudante.prototype.dizTchau = function(){
  console.log('tchau');
}

var estudante1 = new Estudante();
estudante1.dizOi();//Oi, eu sou estudante
estudante1.caminhar();//Pessoa - Estou caminhando
estudante1.dizTchau();

// checa a herança
console.log(estudante1 instanceof Pessoa); // true
console.log(estudante1 instanceof Estudante); // true
