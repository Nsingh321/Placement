package Stacks;

import java.util.Stack;

public class minStack_2 {
   static  Stack<Integer> s = new Stack<>();
    static int minEle;

    static void push(int x){

        //if stack is empty
        if(s.size()==0){
            s.push(x);
            minEle = x;//as it is the first element inserted in stack
        }
        else{
            //stack is not empty

            //either x can be greater and = or smaller than min element
            if(x>=minEle){
                s.push(x);
            }
            else if(x < minEle){
                //push in stack 2X - MinElement and update the min element because x is smaller than Min element
                s.push(2*x-minEle); //this works as a flag in stack and tells that here is the min element present
                minEle = x;
            }

        }

    }

    static void pop(){

        //if stack is empty
        if(s.size() == 0) return;
        else{
            //stack is not empty
            if(s.peek() >= minEle){
                s.pop();//we can just pop the top of stack
            }
            else if(s.peek() < minEle){
                //if an element in stack is smaller than min element means that it is a flag
                //means we are popping a min element which is stored in 'minEle'
                minEle = 2*minEle-s.peek();//this will give the previous min element in stack
                s.pop();
            }
        }
    }

   static int top(){
        int top = 0;
        //if stack is empty
        if(s.size()==0) return -1;
        else{
            //stack not empty
            if(s.peek() >= minEle)
                //if the top of stack is greater than min element , then just return the top element of stack
                top = s.peek();

            else if(s.peek() < minEle)
                //means the top of stack is smaller than the min element , so it is a flag ,denoting that the min element is placed here
                top =  minEle;

        }
        return top;

    }

    //give the min element in stack
    static int getMinEle(){
        if(s.size() == 0) return -1;
        return minEle;
    }

    public static void main(String[] args) {
        push(1);
        push(4);
        push(6);
        System.out.println(getMinEle());


    }
}
