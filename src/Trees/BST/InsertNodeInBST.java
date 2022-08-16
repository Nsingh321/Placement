package Trees.BST;

//TC = O(log n)

public class InsertNodeInBST {

    static class Node{
        int data;
        Node left , right;

        Node(int key){
            data = key;
            left = right = null;
        }
    }

    //we are inserting the nodes at the leaves
    private static Node Insert(Node root , int val){
        if(root == null) return new Node(val);
        Node cur = root;//not disturbing the root because we need to return it at the last

        while(true){
            if(cur.data <= val){
                //the node will be attached at the right
                if(cur.right != null) cur = cur.right;
                else{
                    //reached the leaf node
                    cur.right = new Node(val);
                    break;
                }
            }
            else{
                //cur.data > val -> the node will be attached to the left
                if(cur.left != null) cur = cur.left;
                else{
                    //reached the leaf node
                    cur.left = new Node(val);
                    break; //just move out the root as soon we attach the node
                }
            }
        }
        return root;

    }

    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(7);

        Insert(root , 5);
    }
}
