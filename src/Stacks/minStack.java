package Stacks;

import java.util.Stack;

public class minStack {
    static Stack<Integer> s = new Stack<>();
    static Stack<Integer> ss = new Stack<>();

    private static void push(int a){
        s.push(a);

        //if size of supporting stack is zero means 1st element is inserted in stack and so that element is max and min both
        //if the element 'a' is less than the top of ss then it is the new min. element
        if(ss.size() == 0 || a<=ss.peek()){
            ss.push(a);
        }
    }

    private static int pop(){
        if(s.isEmpty()) return -1;

        int ans = s.peek();
        s.pop();

        //if the element we are popping (from s) is also the min element(in ss) then pop min element also because
        //the min element will change now
        if(ss.peek() == ans){
            ss.pop();
        }
        return ans;
    }

    //min element in stack will be given by the 'ss' stack
    private static int findMinElement(){
        if(ss.isEmpty()) return -1;

        return ss.peek();

    }

    public static void main(String[] args) {
        int a[] = {18,19,29,15,16};
        push(18);
        push(19);
        push(15);
        push(16);
        System.out.println(pop());
        System.out.println(findMinElement());





    }
}
