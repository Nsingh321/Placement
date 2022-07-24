package Trees;

import java.util.*;

public class BottomViewBT {

    static class Node{
        int data;
        Node left , right;

        Node(int key){
            data = key;
            left = right = null;
        }
    }

    static class Tuple{
        Node node;
        int vertical;

        Tuple(Node _node,int _vertical){
            node = _node;
            vertical = _vertical;
        }
    }

    private static ArrayList<Integer> bottomView(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer,Integer> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();

        if(root == null) return ans;
        q.add(new Tuple(root,0));

        while(!q.isEmpty()){
            Tuple t = q.remove();
            Node temp = t.node;
            int v = t.vertical;

            map.put(v,temp.data);//replace the previous node with the current node on the vertical
            if(temp.left != null) q.add(new Tuple(temp.left,v-1));
            if(temp.right != null) q.add(new Tuple(temp.right,v+1));

        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
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
        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(bottomView(root));

    }
}
