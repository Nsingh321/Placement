package Trees;

//TC = O(N)
//SC = O(1)
import java.util.ArrayList;
import java.util.List;

public class MorrisTraversalInorder {

    static class Node{
        int data;
        Node left , right ;

        Node(int key){
            data = key;
        }
    }

    //inorder -> (left , right , root)
    private static void morrisInorder(Node root, List<Integer> ans){
        Node cur = root;//copy of root
        while(cur != null){

            // case 1 - when left is null , then next is root so store it ans and go right
            if(cur.left == null){
                ans.add(cur.data);
                cur = cur.right;
            }

            // case 2 - left is not null , go to the rightmost node in the left subtree(not disturbing 'cur')
            else{
                Node prev = cur.left;

                //keep moving till not reached the right most and the rightmost should not point to cur(himself)
                while(prev.right != null && prev.right != cur){
                    prev = prev.right;
                }

                //reached the rightmost node in left subtree so now make the thread or link (from the rightmost node to 'cur')
                if(prev.right == null){
                    prev.right = cur;
                    cur = cur.left;
                }

                //if we have already made the thread before(means we already went to left now it's time to go right) with the rightmost guy and
                // prev comes again in left subtree and when it comes at the rightmost guy then we remove the thread (otherwise we couldn't able to decide weather to go left or right subtree)
                else{
                    prev.right = null;
                    ans.add(cur.data);
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
        morrisInorder(root , ans);
        System.out.println(ans);

    }
}
