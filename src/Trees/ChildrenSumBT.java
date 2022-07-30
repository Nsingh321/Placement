package Trees;

//TC = O(N)
//SC = O(N)
public class ChildrenSumBT {

    static class Node{
        int data;
        Node left , right;

        Node(int key){
            data = key;
            left = right = null;
        }
    }

    private static void changeTree(Node root){
        if(root == null) return;//base case
        int child = 0; //at any node, computes the sum of left and right child

        if(root.left != null) child = child + root.left.data;
        if(root.right != null) child = child + root.right.data;

        if(child >= root.data) {
            //left and right child has greater sum means increase the node value -> put child value in node value
            root.data = child;
        }
        else{
            //child < root.data -> put root.data in left and right child as there sum is smaller
            if(root.left != null) root.left.data = root.data;
            if(root.right != null) root.right.data = root.data;
        }

        changeTree(root.left);//go left
        changeTree(root.right);//go right

        //while coming back from bottom , take the left child + right child and replace with the root.data
        int tot = 0;
        if(root.left != null) tot += root.left.data;
        if(root.right != null) tot += root.right.data;

        //for leaves nodes we are not changing anything
        if(root.left != null || root.right != null) root.data = tot;
    }

    public static void main(String[] args) {

        Node root = new Node(50);
        root.left = new Node(7);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(1);
        root.right.right = new Node(30);


    }
}
