package Trees;

import java.util.ArrayList;

//TC = O(N)
//SC = O(N)
public class InOrderTraversal {

    private static class Node{
        int data;
        Node left,right;

        Node(int key){
            data = key;
            left = null;
            right = null;
        }
    }

    //inorder traversal = left , root , right
    static void inOrderTrav(Node curr , ArrayList<Integer> inorder){

        //base case
        if(curr == null){
            return;
        }

        inOrderTrav(curr.left,inorder);
        inorder.add(curr.data);
        inOrderTrav(curr.right,inorder);
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

        ArrayList<Integer> inorder = new ArrayList<>();
        inOrderTrav(root , inorder);

        System.out.println("Inorder traversal is : ");
        for(int i=0;i<inorder.size();i++){
            System.out.print(inorder.get(i)+" ");
        }

    }
}
