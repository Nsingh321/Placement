package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class MAH {

    static class Pair{

        int element;
        int index;

        public Pair(int element,int index){
            this.element = element;
            this.index = index;
        }

    }

    private static void mah(int a[]){

        //initialize stack to find next smaller to right element's index
        Stack<Pair> stack = new Stack<>();
        int n = a.length;
        int nsrIndex[] = new int[n];
        int pseudoIndex = 7;

        for (int i = n-1; i >=0 ; i--) {

            while(!stack.isEmpty() && stack.peek().element >= a[i]){
                stack.pop();
            }
            if(i<n){
                if(!stack.isEmpty()){
                    nsrIndex[i] = stack.peek().index;
                }
                else{
                    nsrIndex[i] = pseudoIndex;
                }
            }
//            push the current element onto the stack
            stack.push(new Pair(a[i],i));
        }

        System.out.println("NSR -> "+Arrays.toString(nsrIndex));

        //re-initialize stack to find next smaller to left element's index
        stack = new Stack<>();
        int nslIndex[] = new int[a.length];
        pseudoIndex = -1;

        for (int i = 0; i < n ; i++) {

            while(!stack.isEmpty() && stack.peek().element >= a[i]){
                stack.pop();
            }
            if(i<n){
                if(!stack.isEmpty()){
                    nslIndex[i] = stack.peek().index;
                }
                else{
                    nslIndex[i] = pseudoIndex;
                }
            }
//            push the current element onto the stack
            stack.push(new Pair(a[i],i));
        }
        System.out.println("NSL ->"+Arrays.toString(nslIndex));

        //width[i] = nsrIndex[i] - nslIndex[i]
        int width[] = new int[n];
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            width[i] = nsrIndex[i] - nslIndex[i] - 1;
            int area = a[i] * width[i]; //area = a[i] * width[i]
            maxArea = Math.max(area,maxArea);
        }
        System.out.println("Width ->"+Arrays.toString(width));
        System.out.println("Max Area "+maxArea);




    }

    public static void main(String[] args) {

        int a[] = {6,2,5,4,5,1,6};
        mah(a);

    }
}
