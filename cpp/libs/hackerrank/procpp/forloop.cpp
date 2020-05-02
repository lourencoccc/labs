#include <iostream>
#include <cstdio>
using namespace std;

int main() {
    // Complete the code.
    int a,b;
    cin >> a >> b;
     string text [10] = {"Greater than 9", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" }; 
    for(int n = a; n <= b; n++) 
    {
        if(n >= 1 && n <= 9)
        {
            cout << text[n] << endl;
        }
        else if ( n > 9  && n % 2 == 0)
        {
            cout << "even" << endl;
        }
        else if ( n > 9  && n % 2 != 0)
        {
            cout << "odd" << endl;
        }
    }
    return 0;
}

