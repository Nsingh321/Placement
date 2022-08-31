package Trees.BST;

//TC = O(N)
//SC = O(1)-> Not considering stack space
public class LargestBSTinBT {

    static class Node{
        int data;
        Node left , right;

        Node(int key){
            data = key;
        }
    }

    static class NodeValue{
        public int maxNode , minNode , maxSize;

        public NodeValue(int minNode, int maxNode, int maxSize) {
            this.maxNode = maxNode;
            this.minNode = minNode;
            this.maxSize = maxSize;
        }
    }


        //doing post order traversal
        private static NodeValue largestBSTSubtreeHelper(Node root){

            //base case - empty tree is a BST of size = 0
            if(root == null) return new NodeValue(Integer.MAX_VALUE , Integer.MIN_VALUE ,0);

            NodeValue left = largestBSTSubtreeHelper(root.left);//left
            NodeValue right = largestBSTSubtreeHelper(root.right);//right

            //node -> doing all the business
            //current node is greater than 'max in left' and smallest than 'min in right'
            if(left.maxNode < root.data && root.data < right.minNode){
                //it is a BST - > the largest on left < Node < the smallest on right
                return new NodeValue(Math.min(root.data , left.minNode) , Math.max(root.data , right.maxNode) , left.maxSize + right.maxSize + 1);
            }

            //otherwise return (-Int min , Int max) so that parent can't be a valid bst . Given a range that next time the comparison is never satisfied
            return new NodeValue(Integer.MIN_VALUE , Integer.MAX_VALUE , Math.max(left.maxSize , right.maxSize + 1));
        }

        public static int largestBSTSubtree(Node root){
            return largestBSTSubtreeHelper(root).maxSize;
        }


    public static void main(String[] args) {

        Node root = new Node(20);
        root.left = new Node(15);
        root.right = new Node(40);
        root.left.left = new Node(14);
        root.left.right = new Node(18);
        root.left.right.left = new Node(16);
        root.left.right.right = new Node(19);
        root.left.left.right = new Node(17);
        root.right.left = new Node(30);
        root.right.right = new Node(60);
        root.right.right.left = new Node(50);

        System.out.println((largestBSTSubtree(root)));

    }
}
