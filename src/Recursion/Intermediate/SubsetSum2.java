package Recursion.Intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSum2 {

    private static void subsetSum2(int index , int arr[] , int n , List<Integer> ds){

        //0th level --> empty set generated
        //1st level --> all subset of size 1 generated
        //2nd level --> all subset of size 2 generated


        System.out.println(new ArrayList<>(ds));

        for(int i= index;i<arr.length;i++){
            if(i!=index && arr[i] == arr[i-1]) continue;
            ds.add(arr[i]);
            subsetSum2(i+1,arr,n,ds);
            ds.remove(ds.size()-1);
        }

    }

    public static void main(String[] args) {
        int arr[] = {1,2,2};
        int n = arr.length;
        Arrays.sort(arr);
        subsetSum2(0,arr,n,new ArrayList<>());




    }
}
