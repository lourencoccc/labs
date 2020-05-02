class Humano {
  constructor(nome) {
    this.nome = nome;
  }
  andar() {
    return this.nome+' andou um passo'
  }
}

const HumanoFalante = Base => class extends Base {
  falar() {
    return this.nome+' diz: olá mundo!'
  }
}

const HumanoFalanteMixado = Base => class extends Base {}

const HumanoFinal = HumanoFalanteMixado(HumanoFalante(Humano))

const humano = new HumanoFinal('Bill Gates')

console.log(humano.andar())
console.log(humano.falar())
