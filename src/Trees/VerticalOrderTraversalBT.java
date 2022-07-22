package Trees;

import com.sun.source.tree.Tree;

import javax.swing.event.ListDataEvent;
import java.util.*;

public class VerticalOrderTraversalBT {

    //(left,data,right)
    static class Node{
        int data;
        Node left,right;

        Node(int key){
            data = key;
        }
    }

    //(node,vertical,level)
    static class Tuple{
        Node node;
        int row;
        int col;

        Tuple(Node _node , int _row , int _col){
            node = _node;
            row = _row;
            col = _col;
        }
    }

    private static List<List<Integer>> verticalTraversal(Node root){
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();

        q.offer(new Tuple(root,0,0));
        while(!q.isEmpty()){
            Tuple tuple = q.poll();//take  the tuple from queue
            Node node = tuple.node;//node
            int x = tuple.row;//vertical
            int y = tuple.col;//level

            if(!map.containsKey(x)) map.put(x,new TreeMap<>());
            if(!map.get(x).containsKey(y)) map.get(x).put(y,new PriorityQueue<>());
            map.get(x).get(y).offer(node.data);

            if(node.left!=null) q.offer(new Tuple(node.left,x-1,y+1));
            if(node.right!=null) q.offer(new Tuple(node.right,x+1,y+1));

        }
        List<List<Integer>> list = new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> ys:map.values()){
            list.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes:ys.values()){
                while(!nodes.isEmpty()){
                    //System.out.print(nodes.peek()+" ");
                    list.get(list.size()-1).add(nodes.poll());
                }
            }
        }
        return list;
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.left.right = new Node(10);
        root.right.left = new Node(9);
        root.right.right = new Node(10);

        List<List<Integer>> ans ;
        ans = verticalTraversal(root);
        System.out.println(ans);



    }


}
