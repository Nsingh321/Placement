package Trees.BST;
// TC = O(log n)
// SC = O(log n)
public class SearchInBST {

    static class Node{
        int data;
        Node left , right;

        Node(int key){
            data = key;
            left = right = null;
        }
    }

    private static Node searchInBST(Node root , int val){
        while(root != null && root.data != val){
            if(val > root.data){
                //move right to root
                root = root.right;
            }
            else{
                // val < root.data so move left of root
                root = root.left;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(12);
        root.left.left = new Node(4);
        root.left.right = new Node(7);
        root.left.right.left = new Node(6);
        root.right.left = new Node(10);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);

 /* Property of BST ->
    1) Left Node < Current Node < Right Node
    2) Left subtree and right subtree is a BST
 */
        Node ele = searchInBST(root , 12);
        System.out.println(ele.data);

    }
}
