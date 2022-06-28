package Stacks;

import java.util.Arrays;
import java.util.Stack;

//at any element arr[i] , the stack will contain all the left elements of arr[i] in it
public class pge {

    public static void main(String[] args) {

        Stack<Integer> stack=new Stack<>();
        //int a[] = {2,10,12,1,11};
        int a[] = {1,3,2,4};
        int n = a.length;
        int pge[] = new int[a.length];

//        iterating from backwards just double the size of array(because array is circular)
        for (int i = 0; i <=2*n-1 ; i++) {

            while(!stack.isEmpty() && stack.peek() <= a[i%n]){
                stack.pop();
            }
            if(i<n){
                if(!stack.isEmpty()){
                    pge[i] = stack.peek();
                }
                else{
                    pge[i] = -1;
                }
            }
//            push the current element onto the stack
            stack.push(a[i%n]);
        }

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(pge));

    }
}
