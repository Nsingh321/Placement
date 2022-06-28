package Stacks;

import java.util.Stack;

public class validBrackets {
    static Stack<Character> stack=new Stack<>();

    private static boolean checkValidBrackets(String s){
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);

            //if the bracket is opening --> push in stack
            if(c == '(' || c == '[' || c == '{') stack.push(c);

            else{
                //bracket is not opening

                //stack is empty ,and we got a closing bracket --> return false
                //eg . s = ']()'
                if(stack.isEmpty()) return false;

                //stack is not empty and there may be a closing bracket
                //take the top element of stack(ch)(also remove it) and compare with the character of string(c)
                char ch = stack.peek();

                if((c == ')' && ch == '(') || (c == ']' && ch == '[') || (c == '}' && ch == '{')){
                    stack.pop(); // remove from the stack
                }
                else{
                    return false;
                }
            }
        }

        //at last , when the string is finished if the stack is empty(means we got all the opening and closing bracket pairs)
        if(stack.isEmpty()) return true;
        return false;
    }


    public static void main(String[] args) {

        System.out.println(checkValidBrackets("[()[{()}]]"));

    }

}
