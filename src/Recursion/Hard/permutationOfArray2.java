package Recursion.Hard;


//Approach 2
import java.util.ArrayList;
import java.util.List;

public class permutationOfArray2 {

    static void swap(int i,int j,int[] arr){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private static void permute2(int index, int[] arr, List<Integer> ds){

        //base case
        if(index == arr.length){
            ds = new ArrayList<>();//a new data structure

            //copy all elements of arr to ds
            for (int i = 0; i < arr.length; i++) {
                ds.add(arr[i]);
            }
            System.out.println(ds);
            return;
        }

        //start a loop from current index to arr.length
        for(int i=index;i<arr.length;i++){
            swap(i,index,arr);//swap the current index to the index from where you started
            permute2(index+1,arr,ds);//move index to next position
            swap(i,index,arr);//re swap ,the swap that you made
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3};
        int n=arr.length;
        permute2(0,arr,new ArrayList<>());
    }
}
