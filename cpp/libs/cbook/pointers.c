#include <stdio.h>

#define OK  0;

int main()
{
    int x = 1, y = 2, z[10];

    int *ip; //ip is pointer to int
    printf("ip is pointer to int => %d\n", ip);

    ip = &x; //ip now point to x
    printf("ip now point to x => %d\n", ip);

    y = *ip; //y is now 1
    printf("y is now %d\n", y);

    *ip = 0; //x is now 0;
    printf("x is now %d\n", x);

    ip = &z[0]; //ip is now poit to z[0]
    printf("ip is now poit to z[0] %d\n", ip);
    *ip = 1;
    printf("z[0] is now %d\n", z[0]);

    ip += 1; //ip is now poit to z[1]
    printf("ip is now poit to z[1] %d\n", ip);

    ++ip; //ip is now poit to z[2]
    printf("ip is now poit to z[2] %d\n", ip);

    (ip)++; //ip is now poit to z[3]
    printf("ip is now poit to z[3] %d\n", ip);

    printf("z[0] is now %d\n", z[0]);


    return OK;
}
