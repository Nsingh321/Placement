package Recursion.Intermediate;

import java.util.ArrayList;

public class printSubseqWithSumK {

    static void printSubseqSumK(int arr[],int index,int n, ArrayList<Integer> ds , int s,int sum){

        //base case
        if(index == n){
            //once completed the array then check if the sum of the subsequence 's' is equal to the given sum 'sum'
            if(s == sum){
                for(int i=0;i<ds.size();i++){
                    System.out.print(ds.get(i)+" ");
                }
                System.out.println();
            }
            return;
        }

        else{
            ds.add(arr[index]);//add the current element to the 'ds'
            s = s+arr[index]; // add element arr[i] to the sum 's' also
            printSubseqSumK(arr,index+1,n,ds,s,sum); //make call for the next index
            ds.remove(ds.size()-1);//remove the element that you added
            s = s-arr[index];//also remove the element arr[i] from the sum 's'
            printSubseqSumK(arr,index+1,n,ds,s,sum);//make a call for the next index
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,2,1};
        int sum = 2;
        int n=3;
        ArrayList<Integer> ds = new ArrayList<>();
        printSubseqSumK(arr,0,n,ds,0,sum);

    }
}
