package Trees.BST;

//TC = O(N)
//SC = O(H)

import java.util.Stack;

class BSTIterator_2 {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }


    private Stack<TreeNode> stack = new Stack<TreeNode>();
    boolean reverse = true;

    public BSTIterator_2(TreeNode root, boolean isReverse) {
        reverse = isReverse;
        pushAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tmpNode = stack.pop();
        if(reverse == false) pushAll(tmpNode.right);
        else pushAll(tmpNode.left);
        return tmpNode.val;
    }

    private void pushAll(TreeNode node) {
        while(node != null) {
            stack.push(node);
            if(reverse == true) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
    }
}

class Solution {
    public boolean findTarget(BSTIterator_2.TreeNode root, int k) {
        if(root == null) return false;
        BSTIterator_2 l = new BSTIterator_2(root, false);
        BSTIterator_2 r = new BSTIterator_2(root, true);

        int i = l.next();
        int j = r.next();
        while(i<j) {
            if(i + j == k) return true;
            else if(i + j < k) i = l.next();
            else j = r.next();
        }
        return false;
    }

    public static void main(String[] args) {
        BSTIterator_2.TreeNode root = new BSTIterator_2.TreeNode(5);
        root.left = new BSTIterator_2.TreeNode(3);
        root.right = new BSTIterator_2.TreeNode(6);
        root.left.left = new BSTIterator_2.TreeNode(2);
        root.left.right = new BSTIterator_2.TreeNode(4);
        root.right.right = new BSTIterator_2.TreeNode(7);


        Solution obj = new Solution();
        System.out.println((obj.findTarget(root , 9)));
    }
}

