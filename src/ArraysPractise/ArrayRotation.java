package ArraysPractise;

import java.util.Arrays;
import java.util.Stack;

public class ArrayRotation {

    private static void reverse(int a[],int i,int j){
        int li = i;
        int ri = j;
        //while left is small than right
        while(li<ri){
            int temp = a[li];
            a[li] = a[ri];
            a[ri] = temp;
            li++;
            ri--;
        }
    }

    public static int[] rotate(int a[], int k){
        k = k%a.length;//because rotation of k =0 and k = a.length is same
        //part 1
        reverse(a,0,a.length-1-k);


        //part 2
        reverse(a,a.length-k,a.length-1);


        //all
        reverse(a,0,a.length-1);
        return a;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        //Brute Force
//        while(k-->0){
//           int temp = nums[nums.length-1];
//            System.out.println(temp);
//           for (int i = nums.length-1; i >0 ; i--) {
//               System.out.println(Arrays.toString(nums));
//               nums[i] = nums[i-1];
//           }
//          nums[0] = temp;
//       }
//        System.out.println(Arrays.toString(nums));

        int b[] = rotate(nums,3);
        System.out.println(Arrays.toString(b));




    }
}
