package Trees;

//TC - O(N) -> Tree Traversal
//SC = O(N) -> HashMap
import java.util.HashMap;

public class BTfromInorderAndPostOrder {

    static class Node{
        int data;
        Node left , right;

        Node(int key){
            data = key;
        }
    }

    private static Node buildTree(int inOrder[] , int[] postOrder){
        //if both the array's length do not match then no need to go further directly return false
        if(inOrder == null || postOrder == null || inOrder.length != postOrder.length) return null;

        //for making the search easy in Inorder we are using map
        HashMap<Integer , Integer> map = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i],i);
        }

        return buildTreeInPost(inOrder , 0 , inOrder.length-1,
                        postOrder , 0 , postOrder.length-1 , map);

    }

    private static Node buildTreeInPost(int inOrder[] , int inStart , int inEnd,
                                 int postOrder[] , int postStart , int postEnd , HashMap<Integer , Integer> map){

        //if both the array of inOrder and PostOrder gets empty(the starting index becomes greater than the end index)
        if(postStart > postEnd || inStart > inEnd)  return null;

        Node root = new Node(postOrder[postEnd]);//the last element in the postOrder is always the root (Left,Right,Root)

        int inRoot = map.get(postOrder[postEnd]);//get the index of the root from the Inorder[]

        int numsLeft = inRoot - inStart;//the no. of elements b/w starting and the root in Inorder[]

        //for left subtree
        root.left = buildTreeInPost(inOrder , inStart , inRoot - 1 ,
                                    postOrder , postStart , postStart + numsLeft - 1 , map);

        //for right subtree
        root.right = buildTreeInPost(inOrder , inRoot+1 , inEnd,
                                     postOrder , numsLeft+postStart , postEnd - 1 , map);

        return root;
    }



    public static void main(String[] args) {
       int inorder[] = {9,3,15,20,7};
       int postorder[] = {9,15,7,20,3};

       Node root =  buildTree(inorder ,postorder);

    }
}
