package Recursion.Hard;

//Approach - 1
//Finding permutation Using Map Array
import java.util.ArrayList;
import java.util.List;

public class permutationOfArray {

    private static void permute(int nums[],List<Integer> ds,boolean freq[]){


        //base case --> we need to find all possible combinaion means until all the positions of 'ds' is not full we cannot return
        if(ds.size() == nums.length){
            System.out.println(new ArrayList<>(ds));
            return;
        }

        for(int i=0;i<nums.length;i++){
            //if in the frequency array it is false means not taken
            if(freq[i] == false){
                freq[i] = true;//mark it taken
                ds.add(nums[i]);//add it to 'ds'
                permute(nums,ds,freq);//make the call
                //backtracking
                ds.remove(ds.size()-1);//remove the added element from 'ds'
                freq[i] = false;//unmark it
            }
        }
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3};
        int n = nums.length;
        List<Integer> ds=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        boolean freq[]=new boolean[nums.length];
        permute(nums,ds,freq);

    }
}
