package Trees.BST;

//TC = O(N)
//SC = O(N)


public class kSmallestBST {

    private static class Node{
        int data;
        Node left,right;

        Node(int key){
            data = key;
            left = null;
            right = null;
        }
    }

    static int count =0;
    static int result = Integer.MIN_VALUE;


   //Due to a property of BST , the inorder is always sorted 
    static void Inorder(Node root, int k) {
        if(root==null) return;

        Inorder(root.left, k);
        count++;
        if(count==k) result = root.data;
        /*NO need to visit the right tree if count is already greater than k, if count>k that means we already found K */
        if(count<k) Inorder(root.right,k);
    }



    public static int kthSmallest(Node root, int k) {
        if (root == null) return 0;

        Inorder(root,k);
        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.right.left = new Node(7);
        root.right.right = new Node(8);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);


        System.out.println(kthSmallest(root, 3));



    }
}










//    static void inOrderTrav(Node curr , ArrayList<Integer> inorder){
//
//        //base case
//        if(curr == null){
//            return;
//        }
//
//        inOrderTrav(curr.left,inorder);
//        inorder.add(curr.val);
//        inOrderTrav(curr.right,inorder);
//    }
//
//
//
//    public int kthSmallest(Node root, int k) {
//        if (root == null) return 0;
//
//        ArrayList<Integer> inorder = new ArrayList<>();
//        inOrderTrav(root , inorder);
//
//        return inorder.get(k-1);
//    }