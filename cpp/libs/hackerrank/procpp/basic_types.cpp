#include <iostream>
#include <cstdio>
using namespace std;

/**
Sample Input
3 12345678912345 a 334.23 14049.30493
Sample Output
3
12345678912345
a
334.230
14049.304930000
*/

int main() {
    int i;
    long l;
    char ch;
    float f;
    double d;
    scanf("%d %ld %c %f %lf", &i, &l, &ch, &f, &d);
    printf("%d\n", i);
    printf("%ld\n", l);
    printf("%c\n", ch);
    printf("%f\n", f);
    printf("%lf\n", d);
    return 0;
}
