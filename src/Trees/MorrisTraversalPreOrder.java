package Trees;

import java.util.ArrayList;
import java.util.List;

public class MorrisTraversalPreOrder {

    static class Node{
        int data;
        Node left , right ;

        Node(int key){
            data = key;
        }
    }


    //Pre order -> (root , left , right)
    private static void morrisPreOrder(Node root, List<Integer> ans){
        Node cur = root;//copy of root
        while(cur != null){

            if(cur.left == null){
                ans.add(cur.data);
                cur = cur.right;
            }

            else{
                Node prev = cur.left;

                while(prev.right != null && prev.right != cur){
                    prev = prev.right;
                }


                if(prev.right == null){
                    prev.right = cur;
                    ans.add(cur.data);
                    cur = cur.left;
                }


                else{
                    prev.right = null;

                    cur = cur.right;
                }
            }
        }

    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.right = new Node(3);

        List<Integer> ans = new ArrayList<>();
        morrisPreOrder(root , ans);
        System.out.println(ans);

    }
}
