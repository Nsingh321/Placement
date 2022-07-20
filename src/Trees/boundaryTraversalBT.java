package Trees;

//TC = O(N)
//SC = O(N)
import java.util.ArrayList;

public class boundaryTraversalBT {
    static class Node{
        int data;
        Node left,right;

        Node(int key){
            data = key;
        }
    }

    //check is a node is left or not
    private static boolean isLeafNode(Node curr){
        if(curr.left == null && curr.right == null) return true;
        else return false;
    }

    //add the left boundary(left nodes ,if not present then right nodes) except leaf nodes
    static void addLeftBoundary(Node root, ArrayList<Integer> res){
        Node curr = root.left; //start with the left node of the current node
        while(curr != null){
            if(isLeafNode(curr) == false) res.add(curr.data);
            if(curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }

    //add the right boundary nodes (if not there,then left child of parent node) and reverse it
    //since we are going anti-clock wise
    static void addRightBoundary(Node root,ArrayList<Integer> res){
        Node curr = root.right;
        ArrayList<Integer> temp = new ArrayList<>();
        while(curr != null){
            if(isLeafNode(curr) == false) temp.add(curr.data);
            if(curr.right != null) curr = curr.right;
            else curr = curr.left;
        }
        int i;
        for(i=temp.size()-1;i>=0;--i){
            res.add(temp.get(i));
        }
    }

    //add the leaf nodes to the ans list
    static void addLeafNodes(Node root,ArrayList<Integer> res){
        if(isLeafNode(root) == true){
            res.add(root.data);
            return;
        }
        if(root.left!=null) addLeafNodes(root.left,res);
        if(root.right!=null) addLeafNodes(root.right,res);
    }



    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(3);
        root.right.right = new Node(8);
        root.left.left.right = new Node(4);
        root.right.right.left = new Node(9);
        root.left.left.right.left = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right.right.left.left = new Node(10);
        root.right.right.left.right = new Node(11);

        ArrayList<Integer> ans = new ArrayList<>();
        if(isLeafNode(root) == false) ans.add(root.data);
        addLeftBoundary(root,ans);
        addLeafNodes(root,ans);
        addRightBoundary(root,ans);
        System.out.println(ans);

    }
}
