#include <iostream>
#include <cassert>

int main()
{
    int values [10] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    for(int i = 0; i < 10; i++)
    {
        printf("indice [%i] = %i;\n", i, values[i]);
    }

    enum Month 
    { 
        January = 1, 
        February = 2, 
        March = 3, 
        April = 4, 
        May = 5, 
        June = 6,
        July = 7, 
        August = 8, 
        September = 9, 
        October = 10, 
        November = 11, 
        December = 12
    };
    assert(January == 1 && January == January);
    assert(April == 4 && April == April);
}