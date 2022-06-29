package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class pse {

    public static void main(String[] args) {

        Stack<Integer> stack=new Stack<>();
        //int a[] = {2,10,12,1,11};
        int a[] = {4,5,2,10,8};
        int n = a.length;
        int pse[] = new int[a.length];

//        iterating forward just double the size of array(because array is circular)
        for (int i = 0; i <=2*n-1 ; i++) {

            while(!stack.isEmpty() && stack.peek() >= a[i%n]){
                stack.pop();
            }
            if(i<n){
                if(!stack.isEmpty()){
                    pse[i] = stack.peek();
                }
                else{
                    pse[i] = -1;
                }
            }
//            push the current element onto the stack
            stack.push(a[i%n]);
        }

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(pse));

    }
}
