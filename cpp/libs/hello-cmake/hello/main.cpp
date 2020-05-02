#include <stdio.h>
#include "hello.h"

uint8_t buffer [] =  {0x00, 0x00, 0x00,0x11, 0x01};

int main()
{
    hello();
    double value = (buffer[5] << 24) 
        | (buffer[4] << 16)
        | (buffer[3] << 8)
        | (buffer[2]) 
        | (buffer[1]);
    printf ("floats: %4.2f \n", value);
    cout << value << endl;
    return 0;
}
