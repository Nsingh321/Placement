package Trees;

//TC = O(N)
//SC = O(N) . At worst Auxillary stack space when the tree is skewed
public class SymmetricalTree {

    static class Node{
        int data;
        Node left,right;

        Node(int key){
            data = key;
        }
    }

    private static boolean isSymmetrical(Node root ){

        return root == null || isSymmetricalHelp(root.left,root.right);

    }

    private static boolean isSymmetricalHelp(Node left,Node right){
        if(left == null || right == null) return left == right;

        if(left.data != right.data) return false;

        return isSymmetricalHelp(left.left , right.right) && isSymmetricalHelp(left.right , right.left);
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);

        System.out.println((isSymmetrical(root)));
    }
}
