package Trees.BST;

//TC = O(H)
//SC = O(1 )
public class InOrderSucessorBST {

    static class Node{
        int data;
        Node left , right;

        Node(int key){
            data = key;
            left = right = null;
        }
    }

    //need to find the node just immediate greater than p
    private static Node inorderSuccessor(Node root , Node p){
        Node successor = null;

        while(root != null){
            if(p.data >= root.data){
                //go right
                root = root.right;
            }
            else{
                // root.data > p.data -> this can be successor, but we cannot be sure
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }

    //need to find the node just immediate lesser than p
    private static Node preorderPredecessor(Node root , Node q){
        Node predecessor = null;

        while(root != null){
            if(root.data < q.data){
                predecessor = root;
                root = root.right;
            }
            else{
                //root.data > p.data
                root = root.left;
            }
        }
        return predecessor;
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        root.left.right.left = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(9);
        root.right.right.left = new Node(8);
        root.right.right.right = new Node(10);

        Node successor = inorderSuccessor(root , new Node(3));
        System.out.println(successor.data);

        Node predecessor = preorderPredecessor(root , new Node(3));
        System.out.println(predecessor.data);


    }
}
