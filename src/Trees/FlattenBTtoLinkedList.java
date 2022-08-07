package Trees;


import java.util.Stack;

public class FlattenBTtoLinkedList {

    static class Node{
        int data;
        Node left , right;

        Node(int key){
            data = key;
        }
    }

//    Approach - 1 -> Using reverse Post order traversal (Right , Left , Root)-> TC = O(N) , SC = O(N)
    static Node prev = null;
    private static void flattenBt_recursive(Node root){
        if(root == null) return;
        flattenBt_recursive(root.right);
        flattenBt_recursive(root.left);

        root.right = prev;
        root.left = null;
        prev = root;//keep updating prev with the nodes that we recently visited
    }

//    Approach -2 -> Using stack -> TC = O(N) , SC = O(N)
    private static void flattenBt_UsingStack(Node root){
        Stack<Node> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()){
            Node cur = st.peek();
            st.pop();
            if(cur.right != null) st.push(cur.right);
            if(cur.left != null) st.push(cur.left);

            if(!st.isEmpty()){
                cur.right = st.peek();
                cur.left = null;
            }
        }
    }

    //    Approach -3 -> Using Morris Traversal -> TC = O(N) , SC = O(1)
    //    Intuition is based on Morris Traversal, the rightmost node in the left subtree will be connected to the current node's right
    //    And the current's right will point to current's left and current's left will always point to null
    private static void flattenBt_MorrisTraversal(Node root){
        Node cur = root;//copy of root

        while(cur != null){
            if(cur.left!= null){
                Node prev = cur.left;

                while(prev.right != null){
                    prev = prev.right;
                }

                prev.right = cur.right;
                cur.right = cur.left; //so that cur can be moved to left
                cur.left = null;     //the left of the current node is always null (as can be seen from the question)
            }

            cur = cur.right;
        }
    }




    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(6);
        root.right.right.left = new Node(7);

        flattenBt_recursive(root);
        flattenBt_UsingStack(root);
        flattenBt_MorrisTraversal(root);

    }
}
