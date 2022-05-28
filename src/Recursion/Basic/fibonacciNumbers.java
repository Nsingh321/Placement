
import java.util.*;
public class fibonacciNumbers{

    
    // 0 1 1 2 3 5 8 13 21 ....
    //f(0) -> 0 , f(1) -> 1 , f(4) -> 3
    //f(n) = f(n-1) + f(n-2)

    int fibo(int n){
        
        //fibonacci of 0th and 1th is 0 and 1 --> base case
        if(n<=1){
            return n;
        }
        else{
            int last = fibo(n-1);
            int slast = fibo(n-2);

            return last + slast;
        }
    }
    
   

    public static void main(String[] args){

        fibonacciNumbers obj = new fibonacciNumbers();

        Scanner s = new Scanner(System.in);

        System.out.println("Enter the value of N ");
        int N = s.nextInt();

        System.out.println(obj.fibo(N));
       
       

        

    }
}