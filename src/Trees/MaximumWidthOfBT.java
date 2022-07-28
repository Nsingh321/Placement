package Trees;


//TC = O(N) -> DOING LEVEL ORDER TRAVERSAL
//SC = O(N)
import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBT {

    static class Node{
        int data;
        Node left , right;

        Node(int key){
            data = key;
        }
    }

    static class Pair{
        Node node;
        int index;

        Pair(Node _node, int _index){
            node = _node;
            index = _index;
        }
    }

    public static int widthOfBinaryTree(Node root) {
        if(root == null) return 0;
        int ans = 0; // ans = last(index) - first(index) + 1
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));


        while(!q.isEmpty()){
            int size = q.size();
            int mmin = q.peek().index;    //to make the id starting from zero
            int first = 0,last = 0;
            for(int i=0; i<size; i++){
                int cur_id = q.peek().index-mmin;//to prevent overflow
                Node node = q.peek().node;
                q.poll();
                if(i==0) first = cur_id;
                if(i==size-1) last = cur_id;
                if(node.left != null)
                    q.offer(new Pair(node.left, cur_id*2+1));//left child = 2*index+1
                if(node.right != null)
                    q.offer(new Pair(node.right, cur_id*2+2));//right child = 2*i+2
            }
            ans = Math.max(ans, last-first+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(8);
        root.right.right = new Node(4);

        System.out.println(widthOfBinaryTree(root));


    }
}
