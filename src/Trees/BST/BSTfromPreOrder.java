package Trees.BST;

//TC = O(N)
//SC = O(1) -> Not considering auxiliary stack space

public class BSTfromPreOrder {

    static class Node{
        int data;
        Node left , right;

        Node(int key){
            data = key;
            left = right = null;
        }
    }

    private static Node bstfromPreOrder(int[] A){
        return bstfromPreOrder(A,Integer.MAX_VALUE , new int[]{0});
    }

    private static Node bstfromPreOrder(int[] A,int bound , int[] i){
        if(i[0] == A.length || A[i[0]] > bound) return null;
        System.out.println(i[0]);

        Node root = new Node(A[i[0]++]);
        root.left = bstfromPreOrder(A , root.data , i);
        root.right = bstfromPreOrder(A , bound , i);
        return root;
    }

    public static void main(String[] args) {
       int preorder[] = {8,5,1,7,10,12};

       Node root = bstfromPreOrder(preorder);
       System.out.println(root.data);

    }
}
