package Queue;

import java.util.Arrays;

public class queueUsingArrays {

    static int count=0; //count the elements of the queue
    static int n = 5; //size of queue is 5
    static int front , rear=0;
    static int a[]=new int[n]; //limiting the size of queue to 5

    //insert at rear
    private static void push(int x){

        //check if queue is full--> count ==n
        if(count == n) {
           return;
        }

        a[rear%n] = x; //important to do (rear%n) as rear goes on increasing (exceeding the array)
        rear++;
        count++; //as an element is added
    }

    //pop from front
    private static int pop(){

        //check if queue is empty --> count
        if(count == 0) return -1 ;

        int popped = a[front %n];
        a[front %n] = -1;
        front++;
        count--;

        return popped;
    }

    //element on front
    private static int top(){

        //check if queue is empty
        if(count == 0) return -1;

        return a[front%n];
    }

    public static void main(String[] args) {

        push(2);
        push(5);
        push(7);
        push(8);
        push(9);
        System.out.println(Arrays.toString(a));

        push(22);
        System.out.println(pop());
        System.out.println(pop());

        System.out.println(Arrays.toString(a));

        push(27);
        push(58);
        push(79);
        System.out.println(Arrays.toString(a));

    }
}
