import java.util.*;
public class print_names_five_times{


      void print_name(int i,int n){
        //base case
        if(i>n) return;
        else{
            System.out.println("Nsingh");
            print_name(i+1,n);
        }
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the value of N ");
        int N = s.nextInt();


        //making instance
        print_names_five_times obj = new print_names_five_times();

        //calling method
        obj.print_name(1,N);
    }
}