package Trees;

import java.util.ArrayList;

public class RootToNodePath {

    static class Node{
        int data;
        Node left , right;

        Node(int key){
            data = key;
            left = right = null;
        }
    }

    private static boolean getPath(Node root , ArrayList<Integer> arr,int x){

        //base case
        if(root == null) return false;
        arr.add(root.data);
        if(root.data == x) return true;//if we got x then no need to go further just return true

        boolean left = getPath(root.left,arr,x);
        boolean right = getPath(root.right,arr,x);

        if(left || right) return true; //if any of the left or right sub-tree returns true then return true
        arr.remove(arr.size()-1); //if above condition not happens then backtrack and remove the added node4
        return false;//we do not got the node(x) at this route so return false

    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);


        ArrayList<Integer> arr = new ArrayList<>();
        int x = 7;
        System.out.println((getPath(root , arr,x)));
        System.out.println(arr);


    }
}
