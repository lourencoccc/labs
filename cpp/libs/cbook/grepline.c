#include <stdio.h>

#define MAXLINE 1000


int getLine(char line[], int max);

int stringIndex(char source[], char searchFor[]);


char pattern[] =  "ould";

int main()
{
    char lines[MAXLINE];
    int found = 0;

    while(getLine(lines, MAXLINE) > 0)
    {
        if(stringIndex(lines, pattern) >= 0)
        {
            printf("%s", lines);
            found++;
        }
    }

    return found;
}

int getLine(char lines[], int max)
{
    int c, i;

    i = 0;

    while(--max > 0 && (c = getchar()) != EOF && c != '\n' )
        lines[i++] = c;

    if(c == '\n')
        lines[i++] = c;
    
    lines[i] = '\0';

    return i;
}

int stringIndex(char source[], char searchFor[])
{
    int i, j, k;

    for(i = 0; source[i] != '\0'; i++)
    {
        for(j = i, k = 0; 
            searchFor[k] != '\0' && source[j] == searchFor[k]; 
            j++, k++){}

        if(k > 0 && searchFor[k] == '\0')
            return i;
    }

    return -1;
}