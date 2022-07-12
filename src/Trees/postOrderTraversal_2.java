package Trees;

import java.util.Stack;

public class postOrderTraversal_2 {

    static class Node{
        int data;
        Node left,right;

        Node(int key){
            data = key;
            left = null;
            right = null;
        }
    }

    private static void postOrder(Node curr){

        Stack<Node> st = new Stack<>();
        while(curr!=null || !st.isEmpty()){
            if(curr !=null){
                st.push(curr);
                curr = curr.left;
            }
            if(curr == null){
                //curr is null
                Node temp = st.peek().right;
                if(temp == null){
                    temp = st.pop();
                    System.out.print(temp.data+" ");
                    while(!st.isEmpty() && temp == st.peek().right){
                        temp = st.pop();
                        System.out.print(temp.data+" ");
                    }
                }
                else{
                    curr = temp;
                }
            }
            
        }

    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.right.left = new Node(7);
        root.right.right = new Node(8);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);

        postOrder(root);

    }
}
