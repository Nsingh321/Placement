package Trees;

import java.util.Stack;

public class inOrderTraversal_2 {


//TC = O(N)
//SC = O(N)

        private static class Node {
            int data;
            Node left, right;

            Node(int key) {
                data = key;
                left = null;
                right = null;
            }
        }


        static void iterativeInorderTrav(Node root) {
            Stack<Node> stack = new Stack<>();
            Node node = root;
            while (true) {
                //if node is not null then push in stack and go left
                if (node != null) {
                    stack.push(node);
                    node = node.left;//update the node to node.left
                } else {
                    //node is null then pop from stack , print it and go right(as left is done)
                    if (stack.isEmpty()) break;
                    node = stack.pop();
                    System.out.print(node.data + " ");
                    node = node.right;//update node to node.right

                }
            }


        }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.right.left = new Node(7);
        root.right.right = new Node(8);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);

        iterativeInorderTrav(root);
    }
    }

