#include <stdio.h>

int strLen(char *str);

int main()
{
    char name[] = "Heitor";
    printf("%d\n", strLen("hello, world"));
    printf("%d\n", strLen(name));

    printf("%d",
    
    return 0;
}

int strLen(char *str)
{
    int n;
    for(n = 0; *str != '\0'; str++)
        n++;

    return n;
}