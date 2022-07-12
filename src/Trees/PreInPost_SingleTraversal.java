package Trees;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


//TC = O(3 x N)
//SC = O(4 X N)
public class PreInPost_SingleTraversal {

    static class Pair{

        Node node;
        int num;
        Pair(Node node,int num){
            this.node = node;
            this.num = num;
        }
    }

    private static class Node{
        int data;
        Node left,right;

        Node(int key){
            data = key;
            left = right = null;
        }
    }

    static void preInPostTrav(Node root , List<Integer>pre,List<Integer>in,List<Integer>post){

        if (root == null) return;
        Stack<Pair> st = new Stack<Pair>();
        st.push(new Pair(root,1));

        while(!st.isEmpty()){
            Pair it = st.pop();

            //1,2,3 are the position of the root

            //if num == 1(of Pair) then add to pre and num++.
            //check if it has a left child because in pre(Root,Left,Right)
            //so after root , there comes left, if yes then push into stack with num=1
            if(it.num == 1){
                pre.add(it.node.data);
                it.num++;
                st.push(it);

                if(it.node.left!=null){
                    st.push(new Pair(it.node.left,1));
                }
            }

            //if num == 2(of Pair) then add to in and num++.
            //check if it has a left child because in pre(Left,Root,Right)
            //so after root , there comes right, if yes then push into stack with num=1
            else if(it.num == 2){
                in.add(it.node.data);
                it.num++;
                st.push(it);

                if(it.node.right!=null){
                    st.push(new Pair(it.node.right,1));
                }
            }

            //if num == 3(of Pair) then add to post and in PostOrder = Left,Right,Root
            //there is nothing after root so do not add in stack or do num++

            else{
                post.add(it.node.data);
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List<Integer>pre = new ArrayList<>();
        List<Integer>in = new ArrayList<>();
        List<Integer>post = new ArrayList<>();


        preInPostTrav(root , pre,in,post);
        System.out.println("pre-->"+pre);
        System.out.println("in-->"+in);
        System.out.println("post-->"+post);

    }
}
