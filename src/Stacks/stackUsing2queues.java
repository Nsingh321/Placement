package Stacks;

import java.util.*;

//implemented stack using 2 queues
public class stackUsing2queues {

    //main queue is q1 , q2 is helper queue
    static Queue<Integer> q1 = new LinkedList<>();
    static Queue<Integer> q2 = new LinkedList<>();

    private static void push(int x){

        //1. push 'x' into q2
        q2.add(x);

        //2. if q1 has elements then element wise shift them to q2
        while(!q1.isEmpty()){
            q2.add(q1.peek());
            q1.remove();
        }

        //3. swap the 2 queues
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;

    }

    private static int pop(){

        if(q1.isEmpty()) return -1;
        //while popping from queue , it is not queue it has elements like in stack
        int popped = q1.remove();
        return popped;
    }

    private static int top(){

        //check if q1 is empty
        if(q1.isEmpty()) return -1;
        return q1.peek();
    }

    public static void main(String[] args) {


        push(3);
        push(4);
        push(2);
        push(1);
        System.out.println(top());
        System.out.println(pop());
        System.out.println(top());
        System.out.println(pop());
        System.out.println(top());


    }
}
