package Trees;

//TC = O(N)
//SC = O(N) = O(Height of tree)
public class maxHeightOfBT {

    static class Node{
        int data;
        Node left,right;

        Node(int key){
            data = key;
            left = right = null;
        }
    }

    static int maxHeightOfBT(Node root){
        //at any node find the height of left tree , then height of right tree and calculate the max of both the heights

        if (root == null) return 0;

        int lh = maxHeightOfBT(root.left);
        int rh = maxHeightOfBT(root.right);
        return 1+ Math.max(lh,rh);
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        int height = maxHeightOfBT(root);
        System.out.println(height);


    }
}
