package Trees;

//TC = O(log (n)^2) -> Height will not be more than log n for complete tree
//SC = O(log n) -> Height of the tree
public class countTotalNodeCompleteBT {

    static class Node{
        int data;
        Node left , right;

        Node(int key){
            data = key;
            left = right = null;
        }
    }

    private static int countNodes(Node root){
        if(root == null) return 0; //no of nodes is 0

        int left = getHeightLeft(root);
        System.out.println(left);
        int right = getHeightRight(root);
        System.out.println(right);

        //If left and right are equal it means that the tree is complete and hence go for 2^h -1.
        if(left == right) return ((2<<(left))-1);//(2^H)-1

        //else recursively calculate the number of nodes in left and right and add 1 for root.
        else {
            int goLeft = countNodes(root.left);
            System.out.println(goLeft);
            int goRight = countNodes(root.right);
            System.out.println(goRight);
            return goLeft + goRight + 1;
        }
    }

    private static int getHeightLeft(Node root){
        int count = 0;
        while(root.left != null){
            count++;
            root = root.left;
        }
        return count;
    }

    private static int getHeightRight(Node root){
        int count = 0;
        while(root.right != null){
            count++;
            root = root.right;
        }
        return count;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(countNodes(root));
        //System.out.println(getHeightLeft(root.left));



    }
}
