package Trees;

import java.util.ArrayList;


//TC = O(N)
//SC = O(N)
public class preOrderTraversal {

    static class Node{
        int data;
        Node left,right;

        Node(int key){
            data = key;
            left = null;
            right = null;
        }
    }

    //preOrder = Root , Left , Right
    static void preOrderTrav(Node curr , ArrayList<Integer> preOrder){

        //base case
        if(curr == null){
            return;
        }

        preOrder.add(curr.data);
        preOrderTrav(curr.left,preOrder);
        preOrderTrav(curr.right,preOrder);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);

        ArrayList<Integer> preOrder = new ArrayList<>();
        preOrderTrav(root,preOrder);

        System.out.println("The Preorder Traversal is :");
        for (int i = 0; i < preOrder.size(); i++) {
            System.out.print(preOrder.get(i)+" ");
        }

    }

}