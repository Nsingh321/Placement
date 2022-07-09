package Trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//TC = O(N)
//SC = O(N)

public class bfs {

    static class Node{
        int data;
        Node left,right;

        Node(int key){
            data = key;
            left = null;
            right = null;
        }
    }

    static List<List<Integer>> bfsTrav(Node root,List<List<Integer>> ans){
        Queue<Node> queue = new LinkedList<Node>();//to store level order traversal


        if(root == null) return ans;
        queue.offer(root); //at starting queue will store the 'root' node

        while(!queue.isEmpty()){
            int noOfelements = queue.size();

            //at every level order a new sublist of the level order nodes will be formed and put in the 'ans'
            List<Integer> sublist = new LinkedList<>();
            for(int i=0;i<noOfelements;i++){
                //from the queue pop the nodes one by one and check if they have a left or right node or not
                //if yes then add those nodes to the queue
                if(queue.peek().left!=null) queue.offer(queue.peek().left);
                if(queue.peek().right!=null) queue.offer(queue.peek().right);
                sublist.add(queue.poll().data);

            }
            ans.add(sublist);
        }
        return ans;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        bfsTrav(root,ans);
        System.out.println(ans);


    }
}
