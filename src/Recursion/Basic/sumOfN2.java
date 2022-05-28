//DONE
//Functionl way

import java.util.*;
public class sumOfN2{

    //f(n) --> sum of 1st N numbers

    int sumOfN(int n){
        
        //base case
        if(n==0) return 0; //sum of first 'N' numbers is 0
        else{
            return n+sumOfN(n-1);
        }
    }

    public static void main(String[] args){

        sumOfN2 obj = new sumOfN2();

        Scanner s = new Scanner(System.in);
        System.out.println("Enter the value of N ");
        int N = s.nextInt();

        System.out.println(obj.sumOfN(N));

    }
}