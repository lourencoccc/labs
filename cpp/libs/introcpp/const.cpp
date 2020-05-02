#include <cassert>

int addTow(int a)
{
    return a + 2;
}

int main()
{
    int i { 4 }; //is not a constant
    const int j { i + 2 };
    int const k { i + 3 };
    const int z =  21;
    assert ( i == 4);
    assert ( j == 6);
    assert ( z == 21);
    addTow(j);
    assert ( j == 6);
    //k = 9; //error: assignment of read-only variable ‘k
    //z = 1;  //error
    i = 2;
    return 0;
}