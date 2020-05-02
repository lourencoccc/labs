#include <iostream>
#include <string>

using namespace std;

int main()
{
	int t = 2;

	string s = "Hacker";
	cout << s.size() << endl;
	
	//std::getline(cin, s);
		string sleft = "";
		string sright = "";
		for (int i = 0; i < s.size(); i++)
		{
			if (i == 0 || i % 2 == 0)
			{
				sleft += s[i];
			}
			else
			{
				sright += s[i];
			}
		}
		cout << sleft << " " << sright << endl;

	return 0;
}