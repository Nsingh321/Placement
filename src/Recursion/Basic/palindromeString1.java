
import java.util.*;
public class palindromeString1{

    
    boolean checkPalindrome(String s,int i,int n){

        //base case
        if(i>=n/2) return true;
        else{
            if(s.charAt(i) != s.charAt(n-i-1)) return false;

            return checkPalindrome(s,i+1,n);
        }
    }
    
   

    public static void main(String[] args){

        palindromeString1 obj = new palindromeString1();

        Scanner s = new Scanner(System.in);
       
       String st = "MADSM";

       System.out.println(obj.checkPalindrome(st,0,st.length()));
        

        

    }
}