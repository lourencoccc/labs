package lab.java;

//IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
import java.util.Arrays;
//SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
//DEFINE ANY CLASS AND METHOD NEEDED
//CLASS BEGINS, THIS CLASS IS REQUIRED
public class GCD
{
 // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
 public int generalizedGCD(int num, int[] arr)
 {
     // WRITE YOUR CODE HERE
     int gcd = Arrays.stream(arr).boxed().mapToInt(v->v).max().getAsInt();
     
     boolean isGcd = false;
     
     for(; gcd > 0; gcd--) {
         for(int i = 0; i < num; i++) {
             if(arr[i] % gcd != 0){
                 isGcd = false;
                 break;
             }
             isGcd = true;
         }
         if(isGcd){
             break;
         }
     }
     
     return gcd;
 }
 // METHOD SIGNATURE ENDS
}