#include <bits/stdc++.h>

using namespace std;


/*
Sample Input 1
8
Sample Output 1
eight
Explanation 1
eight is the English word for the number .
Sample Input 2
44
Sample Output 2
Greater than 9
*/
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
