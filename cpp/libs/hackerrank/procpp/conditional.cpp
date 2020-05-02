#include <bits/stdc++.h>

using namespace std;


int main()
{
    int n;
    cin >> n;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    // Write Your Code Here
    string text [10] = {"Greater than 9", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" }; 
    if(n >= 1 && n <= 9)
    {
        cout << text[n] << endl;
    }
    else if ( n > 9)
    {
        cout << text[0] << endl;
    }
    return 0;
}
