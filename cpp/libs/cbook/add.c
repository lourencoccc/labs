#include <stdio.h>
#include "add.h"

int result = 0;

int add(int a, int b)
{
    result = a + b;

    return result;
}

void show(void)
{
    printf("%d", result);
}
