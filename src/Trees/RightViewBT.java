package Trees;

import java.util.ArrayList;
import java.util.List;

public class RightViewBT {

    static class TreeNode{
        int data;
        TreeNode left,right;

        TreeNode(int key){
            data = key;
        }
    }


        public static void rightView (TreeNode curr, List < Integer > result ,int currDepth){

            //base case
            if (curr == null) return;
            if (result.size() == currDepth) result.add(curr.data);

            rightView(curr.right, result, currDepth + 1);
            rightView(curr.left, result, currDepth + 1);
        }



        public static void main (String[]args){
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
            root.left.right.left = new TreeNode(6);
            root.right.right = new TreeNode(7);


            List<Integer> ds = new ArrayList<>();
            rightView(root, ds, 0);
            System.out.println(ds);


        }




}
