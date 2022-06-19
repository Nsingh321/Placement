package Stacks;

import java.util.LinkedList;
import java.util.Queue;

//implemented stack using 1 queue
public class stackUsing1queue {
    static Queue<Integer> q = new LinkedList<>();

    private static void push(int x){
        //1. push x in q
        q.add(x);

        //2.just after pushing 'x' ,for (size-1) run a loop , remove the elements from front and push them again in queue
        //as the elements in queue are removed from front and doing this will place the elements in queue like that in stack
        for (int i = 0; i < q.size()-1; i++) {
            q.add(q.peek());
            q.remove();

        }
    }

    private static int pop(){


        if (q.isEmpty()) return -1;
       int popped =  q.remove();
       return popped;
    }

    private static int top(){
        if (q.isEmpty()) return -1;
        return q.peek();
    }

    public static void main(String[] args) {

        push(3);
        push(2);
        push(4);
        push(1);
        System.out.println(top());
        System.out.println(pop());
        System.out.println(top());

    }
}
