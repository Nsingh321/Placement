package Recursion.Intermediate;

import java.util.ArrayList;
import java.util.List;

public class combinationSum_1 {

    static void combSum(int index ,int n,int arr[], int target , List<Integer> ds){


        //base case
        if(index == n){
            if(target == 0){
                System.out.print(ds);
                System.out.println();
            }
            return;
        }

            //we can only pick the element if it is less than or equal to the target
            if(arr[index] <=target) {
                ds.add(arr[index]); // add the current element to 'ds'
                combSum(index,n,arr,target-arr[index],ds);//an element can be picked multiple times so call to the same index
                ds.remove(ds.size()-1);//immediately remove the element that you added form the 'ds' after returning from the call
            }
            combSum(index+1,n,arr,target,ds);
        }





    public static void main(String[] args) {

        int arr[] = {2,3,6,7};
        int target = 7;
        int n = 4;
        List<Integer> ds=new ArrayList<>();

        combSum(0,n,arr,target,ds);

    }
}
