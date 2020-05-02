#include <iostream>
#include <string>
#include <typeinfo>
#include "max.hpp"

int main()
{
    //compare int
    int i = 42;
    std::cout << "max(7,i): " << ::max(7, i) << std::endl;
    // template is uali

    //compare double
    double f1 =  3.4;
    double f2 =  -6.7;
    std::cout << "max(f1,f2): " << ::max(f1, f2) << std::endl;

    //compare string
    std::string s1 =  "mathematics";
    std::string s2 =  "math";
    std::cout << "max(s1,s2): " << ::max(s1, s2) << std::endl;

    //specify qualify
    std::cout << "max(5,4.2): " << ::max<double>(5, 4.2) << std::endl;
    std::cout << "max(5,4.2) return " <<
        typeid(::max<double>(5, 4.2)).name() << std::endl;




}
