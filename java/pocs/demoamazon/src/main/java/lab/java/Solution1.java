package lab.java;

//IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
//DEFINE ANY CLASS AND METHOD NEEDED
//CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution1
{        
// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
 public List<Integer> cellCompete(int[] states, int days)
 {
     // WRITE YOUR CODE HERE
     List<Integer> nextStates = Arrays.stream(states).boxed().collect(Collectors.toList());
     
     List<Integer> previousStates = Arrays.stream(states).boxed().collect(Collectors.toList());
     
     for(int day = 0; day < days; day++) {
         for(int i = 0; i < states.length; i++) {
             if(i == 0  && previousStates.get(i + 1) == 0) {
                 nextStates.set(i, 0);
             } else if(i == (states.length - 1)  && previousStates.get(i - 1) == 0) {
                 nextStates.set(i, 0);
             } else if( i > 0 
                     && i < (states.length - 1)
                     && previousStates.get(i - 1) == previousStates.get(i + 1)) {
                 nextStates.set(i, 0);
             } else {
                 nextStates.set(i, 1);
             }
         };
         previousStates = nextStates.stream().collect(Collectors.toList()); 
     };
     
     return nextStates;
 }
// METHOD SIGNATURE ENDS
   
 public void debug(List<Integer> states){
     if(states == null || states.isEmpty())
         return;
     StringBuilder result = new StringBuilder("DEBUG: [");
     for(int state : states) {
         result.append(state);
         result.append(" ");
     }
     System.out.println(result.toString().trim()+"]");
 }
 
 public void debug(int num){
     System.out.println("DEBUG: " + num);
 }
 

}
