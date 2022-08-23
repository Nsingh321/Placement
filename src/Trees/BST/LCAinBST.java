package Trees.BST;

//TC = O(N)
//SC = O(1) -> Not considering the stack space
public class LCAinBST {

    static class Node{
        int data;
        Node left , right;

        Node(int key){
            data = key;
            left = right = null;
        }
    }

    private static Node lca(Node root , Node p , Node q){

        //base case
        if(root == null) return null;
        if(root.data < p.data && root.data < q.data){
            //go right
            return lca(root.right,p,q);
        }
        if(root.data > p.data && root.data > q.data){
            //go left
            return lca(root.left,p,q);
        }
        return root; // cannot determine whether to go left or right . Hence ,they are on same row so the first node of p or q return it

    }


    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(4);
        root.right = new Node(13);
        root.left.left = new Node(3);
        root.left.left.left = new Node(1);
        root.left.left.left.right = new Node(2);
        root.left.right = new Node(8);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(9);
        root.right.left = new Node(11);
        root.right.right = new Node(15);

        Node lca = lca(root , new Node(1) , new Node(2));
        System.out.println();
    }
}
