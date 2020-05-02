
//Docs: http://groovy.codehaus.org/Operator+Overloading

class Conta {

    def saldo = 0.0

    def plus(BigDecimal val){
        saldo = saldo + val
    }

    Conta minus(def val){
        saldo = saldo - val
        this
    }

    def multiply(BigDecimal fat){
        saldo =  saldo * fat
    }
}

def conta = new Conta(saldo: 25.0)

conta + 25
assert conta.saldo == 50.0

println "Plus Saldo: R\$  ${conta.saldo}"

assert (conta - 20.0).saldo == 30.0

println "Minus Saldo: R\$  ${conta.saldo}"

conta * 5
assert conta.saldo == 150.0

println "Multiply Saldo: R\$  ${conta.saldo}"



