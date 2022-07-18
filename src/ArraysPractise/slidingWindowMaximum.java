package ArraysPractise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class slidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] r = new int[n-k+1];
        int ri = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for(int i =0;i<n;i++){
            //remove out of bounds index elements
            if(!q.isEmpty() && q.peek() == i-k){
                q.poll();
            }
            //in deque , if element is smaller that a[i] then remove from deque
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]){
                q.pollLast();
            }
            q.offer(i);//add current index in deque
            if(i >= k-1){
                // add the greatest element in the result array r[] when we reach at the end of the windows k
                r[ri++] = nums[q.peek()];
            }
        }
        return r;

    }

    public static void main(String[] args) {
        int a[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;

       int[] maxWindow =  maxSlidingWindow( a,  k);
        System.out.println(Arrays.toString(maxWindow));
    }
}
