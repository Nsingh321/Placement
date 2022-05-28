
import java.util.*;
public class reverseArray{

    //using two pointers to reverse array

    
    void reverseArray(int arr[],int l,int r){

        //base case
        if(l>=r) return;
        else{
            //not crossed or reached at the middle of array so swap
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            reverseArray(arr,l+1 , r-1);
        }
    }
    

    public static void main(String[] args){

        reverseArray obj = new reverseArray();

        Scanner s = new Scanner(System.in);
        int arr[] = {1,2,3,4,5};
        

        obj.reverseArray(arr,0,arr.length-1);

        System.out.println(Arrays.toString(arr));

    }
}