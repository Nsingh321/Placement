package Trees.BST;

//TC = 0(1) -> For every operation
//SC = O(H)
import java.util.Stack;

public class BSTIterator {

    private static class Node{
        int data;
        Node left,right;

        Node(int key){
            data = key;
            left = null;
            right = null;
        }
    }


    private Stack<Node> stack = new Stack<>();

    public BSTIterator(Node root) {
        pushAll(root);

    }

    //idea based on recursive inorder Traversal -> at any node go to extreme left till null comes then print node and then go right(again there extreme left then print node)
    public int next() {
        Node tempNode = stack.pop();
        pushAll(tempNode.right);
        return tempNode.data;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAll(Node node){
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }

    public static void main(String[] args) {

        Node root = new Node(7);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(2);
        root.left.left.left = new Node(1);
        root.left.right = new Node(6);
        root.left.right.left = new Node(5);
        root.left.right.left.left = new Node(4);
        root.right.left = new Node(9);
        root.right.left.left = new Node(8);


        BSTIterator obj = new BSTIterator(root);
        System.out.println(obj.next());
        System.out.println(obj.next());
        System.out.println(obj.next());
        System.out.println(obj.hasNext());
        System.out.println(obj.next());
        System.out.println(obj.next());
        System.out.println(obj.next());
        System.out.println(obj.next());
        System.out.println(obj.hasNext());



        
    }

}
