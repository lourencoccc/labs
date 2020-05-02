#include <stdio.h>

int power(int base, int n);
// int power(int a, int b); ok
// int power(int, int); ok, but no good

int main()
{
    int i;
    for(i = 0; i < 10; i++)
        printf("2 ** %d = %d, -3 ** %d = %d\n", i, power(2, i), i,  power(-3, i));
    return 0;
}

int power(int base, int n)
{
    int i, p;

    p = 1;

    for(i = 1; i <= n; i++)
    {
        p = p * base;
    }

    return p;
}