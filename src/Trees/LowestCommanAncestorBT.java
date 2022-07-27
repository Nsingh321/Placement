package Trees;

//TC = O(N)
//SC = O(H)
import java.util.ArrayList;

public class LowestCommanAncestorBT {

    static class Node{
        int data;
        Node left , right;

        Node(int key){
            data = key;
        }
    }

    private static Node lca(Node root , Node p , Node q){

        if(root == null || root == p || root == q) return root;//base case

        Node left = lca(root.left , p,q);//go left subtree
        Node right =  lca(root.right,p,q);//go right subtree

        if(left == null) return right; //if left gives null , then return node given by right subtree
        else if(right == null) return left;//if right gives null , then return node given by left subtree

        else {
            //both left and right not gives null -> found LCA
            return root;
        }

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);
        root.right.left = new Node(8);
        root.right.right = new Node(9);

        lca(root , new Node(4) , new Node(7));



    }
}
