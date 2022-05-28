

import java.util.*;
public class factorialOfN{

    int fact(int n){
       //base case
       if(n==0) return 1;
       else{
           return n * fact(n-1);
       }
    }

    public static void main(String[] args){

        factorialOfN obj = new factorialOfN();

        Scanner s = new Scanner(System.in);
        System.out.println("Enter the value of N ");
        int N = s.nextInt();

        System.out.println(obj.fact(N));

    }
}