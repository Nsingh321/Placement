package Trees;

import java.util.ArrayList;

//TC = O(N)
//SC = O(N)

public class postOrderTraversal {

    static class Node{
        int data;
        Node left,right;

        Node(int key){
            data = key;
            left = null;
            right = null;
        }
    }

   // post order traversal = left,right,node
    static void postOrderTrav(Node curr , ArrayList<Integer> postOrder){

        //base case
        if(curr == null){
            return;
        }

        postOrderTrav(curr.left,postOrder);
        postOrderTrav(curr.right,postOrder);
        postOrder.add(curr.data);
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

        ArrayList<Integer> postOrder = new ArrayList<>();
        postOrderTrav(root,postOrder);
        System.out.println("Post Order Traversal: ");
        for (int i = 0; i < postOrder.size(); i++) {
            System.out.print(postOrder.get(i)+" ");
        }

    }
}
