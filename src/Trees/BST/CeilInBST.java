package Trees.BST;

public class CeilInBST {
    static class Node{
        int data;
        Node left , right;

        Node(int key){
            data = key;
            left = right = null;
        }
    }

    private static int ceilBST(Node root , int key){
        //need to find the node with value >= key
        int ceil = -1;

        while(root != null){
            if(root.data == key){
                ceil = root.data;
                return ceil;
            }

            //currently, the node's value is less than given key so there will be smaller values on the left of node so go right
            if(root.data < key){
                root = root.right;
            }

            //currently, the node has value > key which is true so update ceil and move left because on the right there will be values larger to this
            else{
                //root.data > key
                ceil = ceil = root.data;
                root = root.left;
            }
        }
        return ceil;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.left.left.left = new Node(2);
        root.left.left.right = new Node(4);
        root.right = new Node(13);
        root.right.left = new Node(11);
        root.right.right = new Node(14);

        int ceil = ceilBST(root , 25);
        System.out.println(ceil);



    }
}
