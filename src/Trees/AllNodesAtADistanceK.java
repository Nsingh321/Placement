package Trees;

//TC = O(N)
//SC = O(N)
import java.util.*;

public class AllNodesAtADistanceK {
    static class Node{
        int data;
        Node left,right;

        Node(int key){
            data = key;
            left = right = null;
        }
    }

    //function to make pointers between parent node and its child node
    private static void makeParents(Node root , Map<Node , Node> parent_track , Node target){
        Queue<Node> queue = new LinkedList<>();//BFS Traversal
        queue.offer(root); //start with root

        while(!queue.isEmpty()){
            Node current = queue.poll();
            if(current.left != null){
                parent_track.put(current.left,current);
                queue.offer(current.left);
            }
            if(current.right != null){
                parent_track.put(current.right,current);
                queue.offer(current.right);
            }

        }
    }

    private static List<Integer> distanceK(Node root , Node target , int k){
        Map<Node , Node> parent_track = new HashMap<>();
        makeParents(root,parent_track,root);

        Map<Node , Boolean> visited = new HashMap<>();//stores the nodes which we have visited so that we do not go to them again
        Queue<Node> queue = new LinkedList<>();//BFS Traversal

        queue.offer(target);//start with target node and go to up , left and right direction
        visited.put(target,true);
        int cur_level = 0;//keeps track on which level we went from target node

        while(!queue.isEmpty()){
            int size = queue.size();
            if(cur_level == k) break;
            cur_level++;
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();

                //only put in queue if right child is not visited(ie. null) and if that node's right child is not null
                if(current.left != null && visited.get(current.left) == null){
                    queue.offer(current.left);
                    visited.put(current.left,true);
                }

                //only put in queue if right child is not visited(ie. null) and if that node's right child is not null
                if(current.right != null && visited.get(current.right) == null){
                    queue.offer(current.right);
                    visited.put(current.right,true);
                }

                //only put in queue if node's parent is not visited(ie. null ) and if that node's parent child is not null
                if(parent_track.get(current) != null && visited.get(parent_track.get(current)) == null){
                    queue.offer(parent_track.get(current));
                    visited.put(parent_track.get(current),true);
                }
            }
        }

        //now we have queue with all elements at distance of 'k'
        List<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            Node current = queue.poll();
            ans.add(current.data);
        }
        return ans;


    }


    public static void main(String[] args) {

        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);
        root.right.left = new Node(0);
        root.right.right = new Node(8);

        int k =2;
        distanceK(root , new Node(5) , k);


    }




}
