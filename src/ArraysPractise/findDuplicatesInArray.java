package ArraysPractise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findDuplicatesInArray {

    public static void main(String[] args) {


//        //1.Brute Force Approach
////        int a[] = {1, 2, 3, 6, 3, 6, 1};
//        int a[] = {1, 2, 3, 4 ,3,4,7,8,9,9,9};
//        Arrays.sort(a); //Sort the array
//        System.out.println(Arrays.toString(a));//check array
//
//        //now array sorted so all duplicates will be next to each other
//        //if a[i] == a[i+1] means we found a duplicate so print the number
//        for (int i=0;i<a.length-1;i++){
//            if (a[i] == a[i+1] ){
//                System.out.println(a[i]+" ");
//            }
//        }
//        System.out.println(Arrays.toString(a));


        //2.Optimized approach (Linked List Cycle Approach - Tortoise Method)
//        int a[] = {1, 2, 3, 6, 3, 6, 1};
//        //initialise the slow and the fast pointer(they start from same place)
//        int slow = a[0];
//        int fast = a[0];
//
//        do {
//            //slow moves one step and fast moves 2 step till they meet
//            slow = a[slow];
//            fast = a[a[fast]];
//
//        }while(slow!=fast);
//
//        //now slow and fast at same index
//        //reset the fast pointer to starting index from where it started
//        fast = a[0];
//        while(fast!=slow){
//            //move slow and fast by 1 step
//            slow = a[slow];
//            fast = a[fast];
//        }
//
//        //the place where they meet is the duplicate no.
//        System.out.println(slow);


        //3. Approach 3
        List<Integer> result = new ArrayList();

        int nums[] = {1, 2, 3, 6, 3, 6, 1};
        System.out.println(nums.length-1);
        for(int n:nums){
            //
            // System.out.println(n);
            n = Math.abs(n);

            if (nums[n-1]>0){
                nums[n-1] = nums[n-1]*-1;
            }
            else{
                result.add(n);
            }
        }
        System.out.println(result);


    }
}
