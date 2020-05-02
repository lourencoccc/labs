#include <bits/stdc++.h>

using namespace std;


// -1 -1 0 -9 -2 -2
// -2 -1 -6 -8 -2 -5
// -1 -1 -1 -2 -3 -4
// -1 -9 -2 -4 -4 -5
// -7 -3 -3 -2 -9 -9
// -1 -3 -1 -2 -4 -5

//expected -6
int main()
{
    vector<vector<int>> arr(6);
    for (int i = 0; i < 6; i++) {
        arr[i].resize(6);

        for (int j = 0; j < 6; j++) {
            cin >> arr[i][j];
        }

        cin.ignore(numeric_limits<streamsize>::max(), '\n');
    }
    int maxSum = INT_MIN;
    for (int i = 0; i < arr.size() - 2; i++) {
      for (int j = 0; j < arr[i].size() - 2; j++) {
        int sumH1 = 0;
        sumH1 += arr[i][j];
        sumH1 += arr[i][j + 1];
        sumH1 += arr[i][j + 2];
        sumH1 += arr[i + 1][j + 1];
        sumH1 += arr[i + 2][j];
        sumH1 += arr[i + 2][j + 1];
        sumH1 += arr[i + 2][j + 2];
        if (sumH1 > maxSum)
          maxSum = sumH1;
      }
    }
    cout << maxSum << endl;

    return 0;
}
