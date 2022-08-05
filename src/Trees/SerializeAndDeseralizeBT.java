package Trees;

//TC - O(N) -> Level Order Traversal
//SC - O(N) -> Queue DataStructure
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeseralizeBT {

    static class Node{
        int data;
        Node left , right;

        Node(int key){
            data = key;
        }
    }

    public static String serialize(Node root){
        if(root == null) return "";
        Queue<Node> q = new LinkedList<>(); //Level Order Traversal
        StringBuilder res = new StringBuilder();
        q.add(root);

        while(!q.isEmpty()){
            Node node = q.poll();
            if(node == null){
                res.append("n ");
                continue;
            }
            res.append(node.data+" ");
            q.add(node.left);
            q.add(node.right);
        }
        return res.toString();
    }

    public static Node deserialize(String data){
        if(data == "") return null;
        Queue<Node> q = new LinkedList<>();
        String[] values = data.split(" ");
        Node root = new Node(Integer.parseInt(values[0]));
        q.add(root);

        for (int i = 1; i < values.length; i++) {
            Node parent = q.poll();
            if(!values[i].equals("n")){
                Node left = new Node(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
                System.out.println("left "+i);

            }
            if(!values[++i].equals("n")){
                Node right = new Node(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
                System.out.println("right "+i);

            }
            System.out.println("outside "+i);
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);

        String result = serialize(root);
        System.out.println(result);

        Node Root = deserialize(result);
        //System.out.println(Root.data);

    }
}
