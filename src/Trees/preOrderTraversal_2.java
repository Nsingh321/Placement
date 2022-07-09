package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//TC = O(N)
//SC = O(N) = O(H) Height of binary tree
public class preOrderTraversal_2 {

    static class Node{
        int data;
        Node left,right;

        Node(int key){
            data = key;
            left = null;
            right = null;
        }
    }


    static List<Integer> preOrderTrav(Node root , List<Integer> preOrder){

        //if tree is empty
        if(root == null) return preOrder;

        Stack<Node>  st = new Stack<>();
        st.push(root); //initially stack has root node

        while (!st.isEmpty()){
            //pop node from stack and add to list . check for the left and right child of that node .
            //First add right and then left because it is a stack and preOrder is Root , Left , Right
            root = st.pop();
            preOrder.add(root.data);
            if(root.right!=null) st.push(root.right);
            if(root.left!=null) st.push(root.left);


        }
        return preOrder;

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.left.right.left = new Node(5);
        root.left.right.right = new Node(6);

        List<Integer> preOrder = new ArrayList<>();
        List<Integer> result = preOrderTrav(root,preOrder);
        System.out.println(result);

    }
}
