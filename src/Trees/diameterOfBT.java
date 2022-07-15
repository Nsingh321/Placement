package Trees;

//TC = O(n)
//SC = O(n)
public class diameterOfBT {

    static class Node{
        int data;
        Node left,right;

        Node(int key){
            data = key;
            left = right = null;
        }
    }

    static int findMaxDiameter(Node root,int[] diameter){

        //base case
        if(root == null) return 0;

        int lh = findMaxDiameter(root.left,diameter);
        int rh = findMaxDiameter(root.right,diameter);

        //this figures out that if we are on a node then what is max height to its left and right it (diameter of tree)
        diameter[0]= Math.max(diameter[0],lh+rh);
        return 1+Math.max(lh,rh); //this gives the height at a node
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.left.left = new Node(5);
        root.right.left.left.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.right = new Node(8);
        root.right.right.right.right = new Node(9);

        int maxi = 0;
        int[] diameter = new int[1];
        findMaxDiameter(root,diameter);
        System.out.println(diameter[0]);

    }
}
