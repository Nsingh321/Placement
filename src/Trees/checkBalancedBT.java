package Trees;

//TC = O(N)
//SC = O(N)
public class checkBalancedBT {

    static class Node{
        int data;
        Node left,right;

        Node(int key){
            data = key;
            left = right = null;
        }
    }

    private static int checkBalancedBT(Node root){
        if(root == null) return 0;

        int lh = checkBalancedBT(root.left);
        if(lh == -1) return -1; //left subtree is not balanced => no need to go for right subtree
        int rh = checkBalancedBT(root.right);
        if(rh == -1) return -1;//right subtree is not balanced => no need to go for left subtree

        //condition for balanced Bt at any node height(left subtree)-height(right subtree)<=1
        if(Math.abs(lh - rh)>1) return -1;
        return Math.max(lh,rh)+1;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(4);
        root.left.left = new Node(3);
        root.left.left.left = new Node(9);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.right.right = new Node(7);
        root.right.right.right.right = new Node(8);

        int height = checkBalancedBT(root);
        if( height == -1 ){
            System.out.println("Not Balanced Bt");
        }
        else{
            System.out.println("Balanced Bt of height"+height);
        }


    }
}
