package Trees;

//TC= O(N)
//SC = O(N)
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class MinTimeToBurnABT {

    static class Node{
        int data;
        Node left,right;

        Node(int key){
            data = key;
        }
    }

//    function returns the target node and maps pointers from children to parents storing them in map
    private static Node bfsToMapParents(Node root,HashMap<Node, Node> mpp, int start) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        Node res = new Node(-1);
        while(!q.isEmpty()) {
            Node node = q.poll();
            if(node.data == start) res = node;
            if(node.left != null) {
                mpp.put(node.left, node);
                q.offer(node.left);
            }
            if(node.right != null) {
                mpp.put(node.right, node);
                q.offer(node.right);
            }
        }
        return res;
    }

    //function returns the min time taken to burn a node
    private static int findMaxDistance(HashMap<Node, Node> mpp, Node target) {
        Queue<Node> q = new LinkedList<>();
        q.offer(target);
        HashMap<Node,Integer> vis = new HashMap<>();//keep putting the nodes as we traverse to keep track that we do not go from where we came
        vis.put(target, 1);
        int maxi = 0;

        while(!q.isEmpty()) {
            int sz = q.size();
            int fl = 0;//anytime a node is burned , this will become 1

            for(int i = 0;i<sz;i++) {
                Node node = q.poll();

                //to burn the left node it should not be null and should not be visited
                if(node.left != null && vis.get(node.left) == null) {
                    fl = 1;
                    vis.put(node.left, 1);
                    q.offer(node.left);
                }

                //to burn the right node it should not be null and should not be visited
                if(node.right != null && vis.get(node.right) == null) {
                    fl = 1;
                    vis.put(node.right, 1);
                    q.offer(node.right);
                }

                //to burn the parent node it should not be null and should not be visited
                if(mpp.get(node) != null && vis.get(mpp.get(node)) == null) {
                    fl = 1;
                    vis.put(mpp.get(node), 1);
                    q.offer(mpp.get(node));
                }
            }
            if(fl == 1) maxi++;
        }
        return maxi;
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.right = new Node(7);
        root.right.left = new Node(5);
        root.right.right = new Node(6);

        int startTarget = 2;
        HashMap<Node , Node> mpp = new HashMap<>();//map to store children -> parent pointers

        Node target = bfsToMapParents(root , mpp, startTarget);//get the reference of start node
        int maxi = findMaxDistance(mpp,target);
        System.out.println(maxi);



    }
}
