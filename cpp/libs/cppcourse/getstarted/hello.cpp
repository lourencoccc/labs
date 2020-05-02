// hello.cpp: Joao Lourenco from https://developers.google.com/edu/c++
// Description: a program that prints the immortal saying "hello world"

//http://www.cplusplus.com/reference/ostream/ostream/

#include <iostream> //http://www.cplusplus.com/reference/iostream/
#include <iomanip> //http://www.cplusplus.com/reference/iomanip/
using namespace std;

int main() {
	for(int i = 0; i < 6; i++){
		for (int j = 0;  j < 4 ; j++)
      		// setw(int) sets the column width
			cout << left << setw(17) << "Hello World!";
    	// this  next line is a part of the first for loop
    	// and causes the new line
		cout << endl;	
	}
	return 0;
}

//Solution
// int main() {
//   //set up cout to right-align
//   cout <<  setiosflags(ios::left);
//   // the first for-loop will handle the rows
//   for (int i = 0; i < 6; i++) {
//     // the second for loop will handle the columns
//     for (int j = 0;  j < 4 ; j++)
//       // setw(int) sets the column width
//       cout << setw(17) << "Hello World!";
//     // this  next line is a part of the first for loop
//     // and causes the new line
//     cout << endl;
//   }
//   return 0;
// }
