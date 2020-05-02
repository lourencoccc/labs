//The traditional Way
def sum(n) {
    total = 0
    for(int i = 2; i <= n; i += 2) {
        total += i
    }
    total
}

def product(n) {
    prod = 1
    for(int i = 2; i <= n; i += 2) {
        prod *= i
    }
    prod
}

assert sum(10) == 30
assert product(10) == 3840


//The groovy Way
def calcEven(n, block) {
    for(int i = 2; i <= n; i += 2) {
        block(i)
    }
}

//print even elements
calcEven(10, { print "$it," } ) //2,4,6,8,10,

//sum
totalSum = 0
calcEven(10, { totalSum += it } )
assert totalSum == 30

//product
def totalProduct = 1
calcEven(10) { totalProduct *= it }
assert totalProduct == 3840



