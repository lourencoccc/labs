#include <iostream>
#include <cassert>
#include <typeinfo>

int main()
{
    //Array
    int arrayName[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    
    int arrayName2[10] = {1, 2, 3};

    //Strings
    char isAString[6] = { 'H', 'e', 'l', 'l', 'o', '\0'};
    char isNotAString[5] = { 'H', 'e', 'l', 'l', 'o'};
    std::cout << isAString << std::endl; //Hello
    std::cout << isNotAString << std::endl; //HelloHello 

    char isAStringWay[6] = "Hello"; // the compiler implicity \0
    char isAnotherStringWay[] = "Array size is inferred";

    //using string class
    using namespace std;
    string myString = "Hello!";
    std::string myNewString = "Less typing";
    
    //Structs
    struct coffeeBean
    {
        string name;
        string country;
        int strength;
    };

    coffeeBean myBean = { "Strata", "Columbia", 10 };
    coffeeBean newBean;
    newBean.name = "Flora";
    newBean.country = "Mexico";
    newBean.strength = 9;
    cout << "Coffee bean " + newBean.name + " is from " + newBean.country << endl;

    //Union
    union numericUnion
    {
        int intValue;
        long longValue;
        double doubleValue;
    };
    //union can only store one piece of data at a time
    numericUnion myUnion;
    myUnion.intValue = 3;
    cout << myUnion.intValue << endl; //output 3
    myUnion.doubleValue = 4.5; 
    cout << myUnion.doubleValue << endl; // output 4.5
    cout << myUnion.intValue; cout << endl; //output 0 

    //Enumerations
    enum Day { Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday };
    //By default it is mean: Sunday = 0, Monday = 1, Tuesday = 2 ...
    assert(Sunday == 0 && Sunday == Sunday);
    assert(Monday == 1 && Monday == Monday);

    Day payDay;
    payDay = Thursday;
    cout << payDay << endl; //show 4 (Thursday)
    return 0;
}