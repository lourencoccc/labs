#include <iostream>
#include <map>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */   
    int size;
    cin >> size;
    string key;
    int value;
    int i = 0;
    map<string,int> phones;
    while(i < size)
    {
        cin >> key >> value;
        phones[key] = value;
        i++;
    }
    while(!cin.eof())
   {
       cin >> key;
       map<string,int>::iterator it = phones.find(key);
       if(it != phones.end())
       {
           cout << it->first << "=" << it->second << "\n";
       }
       else
       {
           cout << "Not found" << "\n";
       }
    }
    return 0;
}

