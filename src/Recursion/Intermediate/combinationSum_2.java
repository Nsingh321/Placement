package Recursion.Intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum_2 {

    static void combPrint2(int index, int arr[],int n, int target, List<Integer> ds){

        //base case
        if(target == 0){
            System.out.println(ds);
            return;
        }

        for (int i = index; i < n; i++) {
            if(i>index && arr[i] == arr[i-1]) continue;
            if(arr[i] > target) break;
            ds.add(arr[i]);
            combPrint2(i+1,arr,n,target-arr[i],ds);
            ds.remove(ds.size()-1);
        }
    }

    public static void main(String[] args) {
        int arr[] = {10,1,2,7,6,5,1};
        Arrays.sort(arr);
        int n = arr.length;
        int target = 8;
        List<Integer> ds=new ArrayList<>();
        combPrint2(0,arr,n,target,ds);

    }
}
