//Parameterized way

import java.util.*;
public class sumOfN{

    void sumOfN(int i,int sum){
        if(i<1){
            System.out.println(sum);
            return;
        }
        else{

            //at every time adding 'i' to the parameter 'sum' and decreasing 'i'
            sumOfN(i-1,sum+i);
        }
    }

    public static void main(String[] args){

        sumOfN obj = new sumOfN();

        Scanner s = new Scanner(System.in);
        System.out.println("Enter the value of N ");
        int N = s.nextInt();

        obj.sumOfN(N,0);

    }
}