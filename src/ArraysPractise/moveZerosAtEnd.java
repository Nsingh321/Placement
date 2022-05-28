package ArraysPractise;

import java.util.Arrays;
import java.util.Stack;

public class moveZerosAtEnd {

    public static void main(String[] args) {

        int  nums[] = {0,1,0,3,12};
        int b[] = new int[nums.length];
        int n2 = b.length;
        int n = nums.length;

        int notZeroes =0;
        for(int i =0;i<n;i++){
            //if element is not zero
            if(nums[i]!=0) {
                nums[notZeroes] = nums[i];
                notZeroes++;
            }
        }
        System.out.println(Arrays.toString(nums));



        //now place all zeroes at the remaining position
        while(notZeroes<n){
            nums[notZeroes] = 0;
            notZeroes++;
        }
        System.out.println(Arrays.toString(nums));






//        System.out.println(countZeros);
//         System.out.println(Arrays.toString(b));

       /*  Approach 2 Using Stacks DONE
       Stack<Integer> stack = new Stack<>();
        for(int j = 0;j<n;j++){
            if(nums[j] == 0){
                stack.push(0);
            }
        }
        for (int i = n-1; i >= 0; i--) {
            if(nums[i] !=0){
                stack.push(nums[i]);
            }
        }

        int i=0;
        while(!stack.isEmpty()){
            nums[i++] = stack.pop();
        }

        System.out.println(Arrays.toString(nums));*/




    }
}
