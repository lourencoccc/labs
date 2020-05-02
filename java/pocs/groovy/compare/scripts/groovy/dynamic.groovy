
def valor = 200.0 //BigDecimal
assert valor.class == BigDecimal

valor = '200' //String
assert valor.class == String

def coisas = ['Ola']
coisas << 73
coisas << 56.0
coisas << true

assert coisas.class == ArrayList

assert coisas == ['Ola', 73, 56.0, true]

assert coisas*.class == [
        String, Integer, BigDecimal,Boolean
]

assert coisas.collect{it.class} == [
        String, Integer, BigDecimal,Boolean
]