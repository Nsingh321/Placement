package Trees;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.*;

public class TopViewBT {

    static class Node{
        int data;
        Node left,right;

        Node(int key){
            data = key;
        }
    }

    static class Tuple{
        Node node;
        int vertical;

        Tuple(Node _node , int _vertical){
            node = _node;
            vertical = _vertical;
        }
    }

    private static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>(); //for returning back for the final answer
        Map<Integer, Integer> map = new TreeMap<>();//for storing vertical -> node(but only 1 vertical store 1 node)
        Queue<Tuple> q = new LinkedList<>(); //for level order traversal

        if (root == null) return ans;
        q.add(new Tuple(root, 0)); //start with root node with vertical 0

        while (!q.isEmpty()) {
            Tuple tuple = q.remove();
            int vertical = tuple.vertical;
            Node temp = tuple.node;

            if (map.get(vertical) == null) map.put(vertical, temp.data);
            if (temp.left != null) q.add(new Tuple(temp.left, vertical - 1));
            if (temp.right != null) q.add(new Tuple(temp.right, vertical + 1));

        }
        for(Map.Entry<Integer , Integer> entry : map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.right.right = new Node(7);


        System.out.println(topView(root));

    }
}
