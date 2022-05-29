package Recursion.Hard;

import java.util.ArrayList;
import java.util.List;

public class palindromePartitioningOne {

    private static void partition(int index,String s, List<List<String>> res, List<String> ds){

        //base case
        if(index == s.length()){
            res.add(new ArrayList<>(ds));
            return;
        }

        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,index,i) == true){
                ds.add(s.substring(index,i+1));
                partition(i+1,s,res,ds);
                ds.remove(ds.size()-1);
            }
        }
    }

    static boolean isPalindrome(String s,int start,int end){
        while(start<=end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aabb";

        List<List<String>> res = new ArrayList<>();
        List<String> ds = new ArrayList<>();
        partition(0,s,res,ds);
        System.out.println(res);
    }
}
