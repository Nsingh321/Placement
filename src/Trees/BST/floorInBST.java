package Trees.BST;

//TC = O(log n)

public class floorInBST {

    static class Node{
        int data;
        Node left , right;

        Node(int key){
            data = key;
            left = right = null;
        }
    }


    private static int floorBST(Node root , int val){
        int floor = -1;
        while(root != null){

            //if we get a node with value == val then no need to go left or right
            if(root.data == val){
                floor = root.data;
                return floor;
            }

            //the current node's value is > val means we need to go left because we want values just more than the 'val'
            if(root.data > val){
                root = root.left;
            }
            else{
                //root.data < key -- > acc. to aur need we found the value which is less than the node's value, but there can be a value which is less
                //than 'val' and greater than current node's value -> so go right
                floor = root.data;
                root = root.right;
            }
        }
        return floor;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(2);
        root.left.right = new Node(8);
        root.left.right.left = new Node(6);
        root.right.left = new Node(13);
        root.right.right = new Node(17);

        int floor = floorBST(root , 8);
        System.out.println(floor);



    }
}
