package Recursion.Intermediate;

import java.util.ArrayList;
import java.util.List;

public class printAllSubsequences {

    static void allSubsquences(int arr[],int index, int n,ArrayList<Integer> ds){

        //base case
        if(index ==n){
//            for(int i=0;i<ds.size();i++){
//                System.out.print(ds.get(i)+" ");
//            }
            System.out.println(ds);
           // System.out.println();
            return;
        }
        else{
            ds.add(arr[index]);//add the current element to the sequence
            allSubsquences(arr,index+1,n,ds); //make a call for the next index
            ds.remove(ds.size()-1);//remove the element that had been added
            allSubsquences(arr,index+1,n,ds);//make a call for the next index
        }

    }

    public static void main(String[] args) {
        int arr[] = {3,1,2};
        int n = 3;
        ArrayList<Integer> ds =new ArrayList<>();
        allSubsquences(arr,0,n,ds);

    }
}
