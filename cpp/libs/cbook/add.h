//if !defined(H_ADD) is equal to ifndef H_ADD
#ifndef H_ADD
#define H_ADD
enum Operation {
    ADD, SUB
};

extern int result;

int add(int a, int b);

void show(void);
#endif