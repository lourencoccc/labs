#include <stdio.h>
#include <cmath>

/*
Input:
4
5

Expected Output:
9
1
*/
void update(int *a,int *b) {
    // Complete this function
    int ai  =  *a + *b;
    int bi =  std::abs(*a - *b);
    *a = ai;
    *b = bi;
}

int main() {
    int a, b;
    int *pa = &a, *pb = &b;
    
    scanf("%d %d", &a, &b);
    update(pa, pb);
    printf("%d\n%d", a, b);

    return 0;
}
