package Trees;

public class maxPathSumOfBT {

    static class Node{
        int data;
        Node left,right;

        Node(int key){
            data = key;
            left = right = null;
        }
    }

    private static int maxPathSum(Node root , int[] maxi){
        //base case
        if(root == null) return 0;

        int leftPathSum = Math.max(0,maxPathSum(root.left,maxi));
        int rightPathSum = Math.max(0,maxPathSum(root.right,maxi));

        //this will store the sum of maximum path
        maxi[0] = Math.max(maxi[0],root.data+leftPathSum+rightPathSum);

        //this will tell that when we are at any node then what is the maximum path(left subtree sum , right sub tree sum)
        return root.data + Math.max(leftPathSum,rightPathSum);

    }

    public static void main(String[] args) {
        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        int[] maxi = new int[1];
        maxi[0] = Integer.MIN_VALUE;

        maxPathSum(root,maxi);
        System.out.println(maxi[0]);
    }
}
