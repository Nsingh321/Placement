package StringPractise;

import java.util.Stack;

public class reverseWordsInString_Three {

    String s = "Let's take LeetCode contest";

    public static void reverse(char[] s, int left, int right) {
        while(left <= right){
            char tem = s[right];
            s[right] = s[left];
            s[left] = tem;
            left++;
            right--;
        }
    }

    public static String reverseWords(String s) {
        char[] array = s.toCharArray();
        int n = array.length;
        int start = 0;
        int i = 0;
        for(; i < n; i++){
            if(array[i] == ' '){
                reverse(array,start,i-1);
                start = i + 1;
            }
        }
        //reverse(array,start,i-1);
        return String.valueOf(array);

    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
//       String s =  "God Ding";
//        StringBuilder r = new StringBuilder(" ");
//
//        Stack<Character> stack = new Stack<>();
//
//        for (int i = 0;i<s.length();i++){
//            char ch = s.charAt(i);
//            if(ch != ' '){
//                stack.push(ch);
//            }
//            if(ch == ' '|| i == s.length()-1){
//                while(!stack.isEmpty()){
//                    r.append(stack.pop());
//                }
//                r.append(" ");
//            }
//
//        }
//        System.out.println(r);

        System.out.println( reverseWords(s));







    }
}
