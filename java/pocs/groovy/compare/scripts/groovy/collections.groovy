//Collections manipulation
//List
def list = [5, 6, 7, 8]
assert list.size == 4
assert list.size() == 4
assert list.class == ArrayList

//Range
assert 5..8 == [5,6,7,8]
assert 5..<8 == [5, 6, 7]

//each
def n=0
(1..10).each{ n += it }
assert n == 55

//find
assert [1, 2, 3].find{ it > 1 } == 2
assert [1, 2, 3].findAll{ it > 1 } == [2, 3]

//sort
def listAl= ['e','d','c','b','a']
listAl.sort(true)
assert listAl == ['a','b','c','d','e']

//reverse
listAl == ['a','b','c','d','e']
assert listAl.reverse() == ['e','d','c','b','a']
assert listAl == ['a','b','c','d','e']

//collect
assert [1, 2, 3].collect{ it * 2 } == [2, 4, 6]
assert [1, 2, 3]*.multiply(2) == [2, 4, 6]

//union
def a = [1,2,3,4] as Set
def b = [3,4,5,6] as Set
def union = a + b
assert union == [1,2,3,4,5,6] as Set

//intersection
def intersection = a.intersect(b)
assert intersection == [3, 4] as Set
