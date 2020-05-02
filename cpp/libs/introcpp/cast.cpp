#include <iostream>
#include <cassert>
#include <typeinfo>

int main()
{
    double d =  3 / 2;
    assert( typeid(d) == typeid(double));
    int i =  static_cast<int>(3.2);
    assert( typeid(i) == typeid(int));
    assert( i == 3);
    auto ai = 3 / 2;
    assert( typeid(ai) == typeid(int));
    assert( ai == 1);
    auto aii =  2 / 2;
    assert( typeid(aii) == typeid(int));
    auto ad =  2.0 / 2;
    assert( typeid(ad) == typeid(double));
    assert( ad == 1.0);
    return 0;
}