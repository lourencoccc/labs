#include <iostream>
using namespace std;

/*
Input:
4
1 4 3 2

Expected Output:
2 3 4 1
*/

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */   
    int n;
    cin >> n;
    int nums[1000];
    for(int i = 0; i <= n; i++){
        cin >> nums[i];
    }
    for(int i = n - 1; i >= 0; i--){
        cout << nums[i] << " ";
    }

    return 0;
}