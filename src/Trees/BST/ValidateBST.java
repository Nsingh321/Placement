package Trees.BST;

//TC = O(N)
//SC = O(N) -> Auxiliary stack space
public class ValidateBST {

    private static class Node{
        int data;
        Node left,right;

        Node(int key){
            data = key;
            left = null;
            right = null;
        }
    }

    private static boolean isValidBST(Node root){

        return isValidBST(root , Long.MIN_VALUE , Long.MAX_VALUE);
    }

    private static boolean isValidBST(Node root , long minVal , long maxVal){

        if (root == null) return true; //base case
        if(root.data >= maxVal || root.data <= minVal) return false;

        return isValidBST(root.left,minVal,root.data) && isValidBST(root.right,root.data , maxVal);
    }

    public static void main(String[] args) {
        Node root = new Node(13);
        root.left = new Node(10);
        root.right = new Node(15);
        root.left.left = new Node(7);
        root.left.right = new Node(12);
        root.left.left.right = new Node(9);
        root.left.left.right.left = new Node(8);
        root.right.left = new Node(14);
        root.right.right = new Node(17);
        root.right.right.left = new Node(16);

        isValidBST(root);


    }
}
