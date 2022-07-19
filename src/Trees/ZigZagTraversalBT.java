package Trees;

//TC = O(N)
//SC = O(N)
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagTraversalBT {

    static class Node{
        int data;
        Node left,right;

        Node(int key){
            data = key;
        }
    }

    public static ArrayList < ArrayList < Integer >> zigzagLevelOrder(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        ArrayList < ArrayList < Integer >> wrapList = new ArrayList < > ();

        if (root == null) return wrapList;

        queue.offer(root);//we start with having root in the queue
        boolean flag = true;//true means left to right storing in 'wraplist'

        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            ArrayList<Integer> subList = new ArrayList<Integer>(levelNum);
            for (int i = 0; i < levelNum; i++) {
                int index = i;
                if (queue.peek().left != null) queue.offer(queue.peek().left);//add left node to queue
                if (queue.peek().right != null) queue.offer(queue.peek().right);//add right node to queue
                if (flag == true)
                    subList.add(queue.poll().data);//add left to right in subList
                else
                    subList.add(0, queue.poll().data);//add right to left in sublist
            }
            flag = !flag;//make true -> false or false -> true
            wrapList.add(subList);//add the sublist to the final result list
        }
        return wrapList;
    }



    public static void main(String[] args) {
        int i, j;
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        ArrayList <ArrayList< Integer >> ans;
        ans = zigzagLevelOrder(root);
        System.out.println(ans);

    }

}
