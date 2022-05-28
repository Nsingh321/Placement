package Recursion.Intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsetSum1 {

   private static void subsetSum(int index,int a[], int sum, List<Integer> ds){

        //base case
        if(index == a.length){
            ds=new ArrayList<>();//make a new 'ds'
            ds.add(sum);//add the sum to the new 'ds'
            System.out.println(ds);
            return;
        }

        subsetSum(index+1,a,sum+a[index],ds);//take the element and add it to sum
        subsetSum(index+1,a,sum,ds);//do not take the element so do not add to the sum

    }

    public static void main(String[] args) {
        int a[] = {3,2,1};
        int n=a.length;
        Arrays.sort(a);
        List<Integer> ds=new ArrayList<>();
        subsetSum(0,a,0,ds);

    }
}
