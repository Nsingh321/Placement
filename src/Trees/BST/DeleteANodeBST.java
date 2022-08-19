package Trees.BST;

public class DeleteANodeBST {

    static class Node{
        int data;
        Node left , right;

        Node(int key){
            data = key;
        }
    }

    private static Node deleteNode(Node root , int key){
        if(root == null) return null;
        if(root.data == key) return helper(root);

        Node dummy = root; // not disturbing the root node
        while(root != null){
            if(root.data > key ){
                //go left
                if(root.left != null && root.left.data == key){
                    root.left = helper(root.left);
                    break;
                }
                else{
                    root = root.left;
                }
            }
            else{
                //go right
                if(root.right != null && root.right.data == key){
                    root.right = helper(root.right);
                    break;
                }
                else{
                    root = root.right;
                }
            }
        }
        return dummy;
    }


    private static  Node helper(Node root){
        if(root.left == null) return root.right;
        else if(root.right == null) return root.left;
        else{
            Node rightChild = root.right;
            Node lastRight = findLastChild(root.left);
            lastRight.right = rightChild;
            return root.left;
        }
    }

    private static Node findLastChild(Node root){
        if(root.right == null) return root;
        return findLastChild(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(9);
        root.left = new Node(8);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);
        root.left.left.left.right = new Node(4);
        root.left.left.left.left = new Node(2);
        root.left.left.left.left.left = new Node(1);
        root.left.left.right = new Node(7);
        root.left.left.right.left = new Node(6);
        root.left.left.right.right = new Node(8);
        root.right = new Node(12);
        root.right.left = new Node(10);
        root.right.left.right = new Node(11);
        root.right.right = new Node(13);

        Node result = deleteNode(root , 5);

    }
}
