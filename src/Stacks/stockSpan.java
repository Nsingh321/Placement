package Stacks;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class stockSpan {

    static class Pair{

        int element;
        int index;

        public Pair(int element,int index){
            this.element = element;
            this.index = index;
        }

    }

    public static void main(String[] args) {

        Stack<Pair> stack=new Stack<>();

        //int a[] = {2,10,12,1,11};
        int a[] = {100,80,60,70,60,75,85};
        int n = a.length;
        int pge[] = new int[a.length];

//        iterating forward just double the size of array(because array is circular)
        for (int i = 0; i < n ; i++) {

            while(!stack.isEmpty() && stack.peek().element <= a[i]){
                stack.pop();
            }
            if(i<n){
                if(!stack.isEmpty()){
                    pge[i] = stack.peek().index;
                }
                else{
                    pge[i] = -1;
                }
            }
//            push the current element onto the stack
            stack.push(new Pair(a[i],i));
        }

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(pge));

        for(int i = 0;i< n;i++){
            //i-pge(i)
            pge[i] = i-pge[i];
        }
        System.out.println(Arrays.toString(pge));
        int max = Integer.MIN_VALUE;
        for (int i=0;i<pge.length;i++){
            if(pge[i] > max){
                max = pge[i];
            }
        }
        System.out.println(max);

    }
}
