package Stacks;

import java.util.Arrays;

public class stackUsingArrays {

    static int top =-1;
    private static void push(int arr[],int x){
        top = top+1; // first increment the top then add the element
        arr[top] = x;
    }

    private static int pop(int arr[]){
        int popped = arr[top];
        top = top -1 ; // decrement the top by 1
        return popped;
    }

    private static int top(int arr[]){
        //return the element at top in the 'arr'
        return arr[top];
    }

    private static int size(){
        //size = top + 1
        return top+1;
    }

    private static boolean isEmpty(){
        //if top == -1 means the array is empty
        return (top == -1);
    }

    public static void main(String[] args) {

        int arr[] = new int[5];
        push(arr,1);
        push(arr,5);
        push(arr,7);
        push(arr,2);
        push(arr,9);
        System.out.println(Arrays.toString(arr));
        System.out.println(pop(arr));
        System.out.println(pop(arr));
        System.out.println("size of stack is:"+size());
        if(isEmpty() == true){
            System.out.println("stack is empty");
        }
        else{
            System.out.println("stack not empty");
        }



    }
}
