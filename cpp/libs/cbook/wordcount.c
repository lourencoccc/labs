#include  <stdio.h>

#define IN  1 /*inside a word*/
#define OUT 0 /*outside a word*/

#define MAX_DIGITS 10
int main()
{
    int c, i, nl, nw, nc, state, nwhite, nother;
    int ndigits[MAX_DIGITS];
    
    state = OUT;
    nl = nw = nc = 0;
    nwhite = nother = 0;

    for(i = 0;  i < MAX_DIGITS; i++)
        ndigits[i] = 0;

    while((c = getchar()) != EOF)
    {
        ++nc;
        if(!nl)
            nl = 1;
        
        if(c == '\n')
            ++nl;

        if(c >= '0' && c <= '9')
            ++ndigits[c - '0'];
        else if(c == ' ' || c == '\n' || c == '\t')
            ++nwhite;
        else
            ++nother;
        
        if(c == ' ' || c == '\n' || c == '\t')
        {
            state = OUT;
        }
        else if(state == OUT)
        {
            state = IN;
            ++nw;
        }
    }
    printf("nl %d, nw %d, nc %d\n", nl, nw, nc);
    printf("digits = ");
    for(i = 0; i < MAX_DIGITS; i++)
        printf(" %d", ndigits[i]);
    printf(", white space = %d, others = %d\n", nwhite, nother);

    return 0;
}