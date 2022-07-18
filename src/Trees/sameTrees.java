package Trees;

public class sameTrees {

    static class Node{
        int data;
        Node left,right;

        Node(int key){
            data = key;
            left = right = null;
        }
    }

    private static boolean isSameTree(Node root1 , Node root2){

        //if any of the node becomes null then check that node in both the tree
        if(root1 == null || root2 == null) return root1 == root2;

        //and any node => check for the root , the left subtree and right subtree(ie. all must return true)
        return (root1.data == root2.data) && isSameTree(root1.left,root2.left) && isSameTree(root1.right, root2.right);
    }

    public static void main(String[] args) {
        // Tree p
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.right.left = new Node(4);
        root1.right.right = new Node(5);

        // Tree q
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.right.left = new Node(4);
        root2.right.right = new Node(5);

        System.out.println((isSameTree(root1 , root2)));


    }
}
