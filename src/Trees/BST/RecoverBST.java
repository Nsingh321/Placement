package Trees.BST;

public class RecoverBST {

    private static class Node{
        int data;
        Node left,right;

        Node(int key){
            data = key;
            left = null;
            right = null;
        }
    }
    static Node first;
    static Node prev;
    static Node middle;
    static Node last;

    private static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);

        if(prev != null && (root.data < prev.data)){
            //if this is the first violation(first = null) then store first and middle
            if(first == null){
                first = prev;
                middle = root;
            }
            else{
                //if it is the last violation
                last = root;
            }
        }
        prev = root;//before moving on mark the current node as previous
        inorder(root.right);
    }

    private static void recoverTree(Node root){
        first = middle = last = null;
        prev = new Node(Integer.MIN_VALUE);
        inorder(root);

        if(first != null && last != null){
            int t = first.data;
            first.data = last.data;
            last.data = t;
        }
        else if(first != null && middle != null){
            int t = first.data;
            first.data = middle.data;
            middle.data = t;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(1);
        root.right = new Node(4);
        root.right.left = new Node(3);

        recoverTree(root);


    }
}
