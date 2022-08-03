package Trees;

//TC = O(N)
//SC = O(N)-> HashMap
import java.util.HashMap;
import java.util.Map;

public class BTfromInorderAndPostOrder {

    static class Node{
        int data;
        Node left , right;

        Node(int key){
            data = key;
        }
    }

    private static Node builtTree(int[] preOrder , int[] inOrder){
        Map<Integer , Integer> inMap = new HashMap<>();

        for (int i = 0; i < inOrder.length; i++) {
            inMap.put(inOrder[i],i);
        }

        Node root = buildTree(preOrder , 0 , preOrder.length-1,
                              inOrder , 0  , inOrder.length , inMap);

        return root;
    }

    static Node buildTree(int[] preOrder ,int preStart , int preEnd ,
                          int[] inOrder , int inStart , int inEnd , Map<Integer,Integer> inMap){

        if (preStart > preEnd || inStart > inEnd) return null;

        Node root = new Node(preOrder[preStart]);
        int inRoot = inMap.get(root.data);
        int numsLeft = inRoot - inStart;

        root.left = buildTree(preOrder, preStart + 1, preStart + numsLeft, inOrder,
                inStart, inRoot - 1, inMap);
        root.right = buildTree(preOrder, preStart + numsLeft + 1, preEnd, inOrder,
                inRoot + 1, inEnd, inMap);

        return root;
    }


    public static void main(String[] args) {
        int preorder[] = {3,9,20,15,7};
        int inorder[] = {9,3,15,20,7};

        Node root = builtTree(preorder , inorder);
    }
}
