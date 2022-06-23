package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class nge {

    public static void main(String[] args) {

        Stack<Integer> stack=new Stack<>();
        int a[] = {2,10,12,1,11};
        int n = a.length;
        int nge[] = new int[a.length];

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
            stack.push(a[i%n]);
        }

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(nge));

    }
}
