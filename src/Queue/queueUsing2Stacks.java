package Queue;

import java.util.Stack;

public class queueUsing2Stacks {

    //TC --> push O(1) , pop and top --> O(1)
    //SC --> O(2N)
    //pop() and top() operations are done from output , only push is done on input.

    static Stack<Integer> input = new Stack<>();
    static Stack<Integer> output = new Stack<>();


    private static void push(int x){
        input.push(x);
    }

    private static int pop(){
        //check if o/p is empty
        int popped = 0;
        if(output.isEmpty() == false){
            popped = output.pop();
        }
        else{
            //o/p is empty --> transfer all elements from i/p to o/p
            while(input.isEmpty() == false){
                output.push(input.peek());
                input.pop();
            }
            popped = output.pop();
        }
        return popped;
    }

    private static int top(){
        //check if o/p is empty
        int top = 0;
        if(output.isEmpty() == false){
            top = output.peek();
        }
        else{
            //o/p is empty --> transfer all elements from i/p to o/p
            while(input.isEmpty() == false){
                output.push(input.peek());
                input.pop();
            }
            top = output.peek();
        }
        return top;
    }




    public static void main(String[] args) {
        push(2);
        push(5);
        push(3);
        System.out.println(top());
        System.out.println(pop());
        push(6);
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(top());


    }
}
