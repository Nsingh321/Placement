import java.util.*;
public class print_from_one_to_n{


      void print_name(int i,int n){
        //base case
        if(i>n) return;
        else{
            System.out.println(i);
            print_name(i+1,n);
        }
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the value of N ");
        int N = s.nextInt();


        //making instance
        print_from_one_to_n obj = new print_from_one_to_n();

        //calling method
        obj.print_name(1,N);
    }
}