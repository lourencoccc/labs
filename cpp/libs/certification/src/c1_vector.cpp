#include <vector>
#include <iostream>

using namespace std;

int interator();
int initialization();
int copyconstructor();
int constructorObjects();
int copyvector();

int main()
{
    // Basic exampl
    vector<int> v1(10, 0);
    cout << "Size: " << v1.size() << endl;
    for (unsigned i = 0; i < v1.size(); ++i)
    {
        cout << v1[i] << " ";
    }
    cout << endl;
    interator();
    initialization();
    copyconstructor();
    constructorObjects();
    copyvector();
    return 0;
}

//Constructing vectors – Iterator constructors
int interator()
{
    cout << "# Constructing vectors – Iterator constructors" << endl;
    //first one
    vector<int> v1(10, 0);
    for (unsigned i = 0; i < v1.size(); ++i)
    {
        v1[i] = i + 1;
    }
    cout << "Size (v1):  " << v1.size() << endl;
    for (unsigned i = 0; i < v1.size(); ++i)
    {
        cout << v1[i] << " ";
    }
    cout << endl;
    //second one; create vector with the first five elements from v1
    vector<int> v2(v1.begin(), v1.begin() + 5);
    cout << "Size (v2):  " << v2.size() << endl;
    for (unsigned i = 0; i < v2.size(); ++i)
    {
        cout << v2[i] << " ";
    }
    cout << endl;
    return 0;
}

int initialization()
{
    cout << "# Iterator constructors – initialization" << endl;
    int a1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    //first one
    vector<int> v1(a1, a1 + 10);
    cout << "Size (v1):  " << v1.size() << endl;
    for (unsigned i = 0; i < v1.size(); ++i)
    {
        cout << v1[i] << " ";
    }
    cout << endl;
    //second one;
    //the first element will be included,
    //and the last element will not be in that range.
    vector<int> v2(a1 + 5, a1 + 10);
    cout << "Size (v2):  " << v2.size() << endl;
    for (unsigned i = 0; i < v2.size(); ++i)
    {
        cout << v2[i] << " ";
    }
    cout << endl;
    return 0;
}

int copyconstructor()
{
    cout << "# Copy constructors" << endl;
    int a1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    //first one
    vector<int> v1(a1, a1 + 10);
    cout << "Size (v1):  " << v1.size() << endl;
    for (unsigned i = 0; i < v1.size(); ++i)
    {
        cout << v1[i] << " ";
    }
    cout << endl;
    //second one;
    //The copy is exact; every element from the source is copied.
    vector<int> v2(v1);
    cout << "Size (v2):  " << v2.size() << endl;
    for (unsigned i = 0; i < v2.size(); ++i)
    {
        cout << v2[i] << " ";
    }
    cout << endl;
    /*
    Output:
    Size (v1):  10
    1 2 3 4 5 6 7 8 9 10
    Size (v2):  10
    1 2 3 4 5 6 7 8 9 10
    */
    return 0;
}

class A
{
    int number;
    int number2;

public:
    A(int _number) : number(_number), number2(0)
    {
        cout << "Normal constructor\n";
    }
    //explicit A(int _number):number(_number) , number2(0) {}
    A()
    {
        cout << "Default constructor\n";
    }

    A(const A &source)
    {
        number = source.number;
        number2 = source.number2;
        cout << "Copy constructor\n";
    }

    A &operator=(const A &source)
    {
        number = source.number;
        number2 = source.number2;
        cout << "Assignment operator\n";
        return *this;
    }

    ~A()
    {
        cout << "Destructor\n";
    }
};

int dealing()
{
    vector<A> v1;
    //implicit type conversion.
    v1.push_back(1); //compilation error if constructor is mrked
    // with explicit
    return 0;
}

int constructorObjects()
{
    cout << "# Constructors and objects" << endl;
    vector<A> v1(1); //(1)
    v1.push_back(1); //(2)
    v1[0] = 10;      //(3)
    return 0;
    /*
Output:
Default constructor ****(1)
Normal constructor ****(2)
Copy constructor     ****(2)
Copy constructor     ****(2)
Normal constructor ****(3)
Assignment operator  ****(3)
    */
}

int copyvector()
{
    cout << "#  Creating a copy of a vector" << endl;
    vector<A> v1;    //(1)
    v1.push_back(1); //(1)
    cout << "First ready!\n";
    //copy constructor
    vector<A> v2(v1); //(2)
    cout << "Second ready!\n";
    //assignment operator - empty target
    vector<A> v3; //(3)
    v3 = v2;      //(3)
    cout << "Third ready!\n";
    //assignment - not empty target
    vector<A> v4(2); //(4)
    v4 = v2;         //(4)
    return 0;
    /*
    Output:
    Normal constructor        (1)
    Copy constructor        (1)
    First ready!
    Copy constructor        (2)
    Second ready!
    Copy constructor        (3)
    Third ready!
    Default constructor        (4)
    Default constructor        (4)
    Assignment operator        (4)
    */
}

int desctructors()
{
    cout << "# Destructors" << endl;
    //destructor of elements will 
    //be called if and only if these elements are static (not pointers)
    vector<A> v1;
    v1.push_back(1);
    cout << "First ready!\n";
    v1.push_back(2);
    cout << "Second ready!\n";
    v1.push_back(3);
    cout << "Third ready!\n";
    return 0;
    /*
Output:
Normal constructor
Copy constructor
Destructor
First ready!
Normal constructor
Copy constructor
Copy constructor
Destructor
Destructor
Second ready!
Normal constructor
Copy constructor
Copy constructor
Copy constructor
Destructor
Destructor
Destructor
Third ready!
Destructor
Destructor
Destructor
        */
}