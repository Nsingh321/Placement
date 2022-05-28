import java.util.*;
public class print_n_to_one{


      void print_name(int i,int n){
        //base case
        if(i<1) return;
        else{
            System.out.println(i);
            print_name(i-1,n);
        }
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the value of N ");
        int N = s.nextInt();


        //making instance
        print_n_to_one obj = new print_n_to_one();

        //calling method
        obj.print_name(N,1);
    }
}