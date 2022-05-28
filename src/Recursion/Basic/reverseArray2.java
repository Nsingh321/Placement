
import java.util.*;
public class reverseArray2{

    //using one pointer to reverse array

    
    void reverseArray2(int arr[],int i,int n){
        //i -> current index in array, n -> size of array
        //base case
        if(i>=n/2) return; //crossed /reached half array
        else{
            int temp = arr[i];
            arr[i] = arr[n-i-1];
            arr[n-i-1] = temp;

            reverseArray2(arr,i+1,n);
        }
        
    }
    

    public static void main(String[] args){

        reverseArray2 obj = new reverseArray2();

        Scanner s = new Scanner(System.in);
        int arr[] = {1,2,3,4,5};
        

        obj.reverseArray2(arr,0,arr.length);

        System.out.println(Arrays.toString(arr));

    }
}