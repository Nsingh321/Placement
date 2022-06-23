package Stacks;

import java.util.Arrays;
import java.util.Stack;

//TC = O(N)
//SC = O(N)
public class nge {

    public static void main(String[] args) {

        Stack<Integer> stack=new Stack<>();
        int a[] = {2,10,12,1,11};
        int n = a.length;
        int nge[] = new int[a.length];

//        iterating from backwards just double the size of array(because array is circular)
        for (int i = 2*n-1; i >=0 ; i--) {

            while(!stack.isEmpty() && stack.peek() <= a[i%n]){
                stack.pop();
            }
            if(i<n){
                if(!stack.isEmpty()){
                    nge[i] = stack.peek();
                }
                else{
                    nge[i] = -1;
                }
            }
//            push the current element onto the stack
            stack.push(a[i%n]);
        }

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(nge));

    }
}
