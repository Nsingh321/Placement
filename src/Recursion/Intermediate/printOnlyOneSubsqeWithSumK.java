package Recursion.Intermediate;

import java.util.ArrayList;

public class printOnlyOneSubsqeWithSumK {

    static boolean printOneSubseqWithKSum(int arr[],int index,int n,int s,int sum,ArrayList<Integer> ds){

        //base case
        if(index == n){
            if(s == sum){
                for(int i=0;i<ds.size();i++){
                    System.out.print(ds.get(i)+" ");
                }
                System.out.println();
                return true;
            }
           else{
               return false;
            }
        }

        ds.add(arr[index]);//add the current element to the data structure 'ds'
        s = s+arr[index]; //also add the current sum 'sum' to the sum 's'

        //avoid making further calls once we get a 'true' from the call
        if(printOneSubseqWithKSum(arr,index+1,n,s,sum,ds)){
            return true;
        }
        ds.remove(ds.size()-1);//remove the element that you added
        s = s-arr[index]; //also remove from the sum

        //avoid making further calls once we get a 'true' from the call
        if(printOneSubseqWithKSum(arr,index+1,n,s,sum,ds)){
            return true;
        }

        //if we not a 'true' then return a 'false'
         return false;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,1};
        int n = 3;
        int sum = 2;
        ArrayList<Integer> ds = new ArrayList<>();

        printOneSubseqWithKSum(arr,0,n,0,sum,ds);


    }
}
