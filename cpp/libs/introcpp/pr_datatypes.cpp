#include <iostream>

using namespace std;

int main(){

    //First Name
    string firstNAme;
    
    //Street Address
    string streetAddress;
    
    //Birth Date
    struct Date 
    {
        int month;
        int day;
        int year;
    };
    Date birthDate =  {4, 13, 1986};
    
    //Zip/Postal Code
    string ZipPostalCode;
    
    //Bank Account Balance
    double bankAccountBalance;

    //Months of the Year
    enum Month 
    {
        January, 
        February, 
        March, 
        April, 
        May, 
        June,
        July,
        August,
        September,
        October,
        November,
        December
    };

    return 0;
}