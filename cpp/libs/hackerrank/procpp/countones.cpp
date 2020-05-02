#include <iostream>


using namespace std;



int main()
{
    double n;
    cin >> n;
    //cin.ignore(numeric_limits<streamsize>::max(), '\n');
    int countOne = 0;
    int maxOnes = 0;
    while (n > 0.0)
    {
        if((int)n % 2 != 0)
        {
            countOne++;
        }
        else
        {
          maxOnes = countOne > maxOnes ? countOne : maxOnes;
          countOne = 0;
        }
        n = n / 2.0;
    }
    cout << maxOnes << endl;
    return 0;
}
