package Trees;

class Node {

    int data;
    Node left , right;
    public Node(int key){
        data = key;
    }
}


public class representBT {

    Node root; //root node

    public static void main(String[] args) {

        representBT tree = new representBT();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.left = new Node(5);

        /*   1
        *   / \
        *  2   3
        *     /
        *    5
        * Leaf node will have right and left references as Null
        */

    }



}
