package Recursion.Hard;

public class mColouringProblem {

    private static boolean isSafe(int node , int[][] G,int[] color,int n,int currColor){

        //iterate the graph
        for(int it:G[node]){
            if(color[it] == currColor) return false;//adjacent node has same color
        }
        return true;//adjacent node do not has same color
    }




    private static boolean solve(int node , int[][]G , int[] color , int n,int m){

        //base case
        if(node == n) return true;//if the value of node reaches the no. of nodes(n) means we colored all nodes

        //we try to color all the nodes with every possible color
        for(int i=1;i<=m;i++){
            if(isSafe(node , G,color,n,i)){
                color[node] = i;//color the node
                //make a recursive call for the next node
                if(solve(node+1,G,color,n,m) == true) return true;
                color[node] = 0;//if the function returned a false means that we cannot color the node with any given color then backtack
                //and remove the color with which the you colored the node before
            }
        }
        return false;//if we cannot color the node with any given color (1 to m) then return a false
    }




    public static void main(String[] args) {
        int G[][] = {{0, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {1, 0, 1, 0}};
        int color[] = new int[G.length];

        int N = G.length;
        int M = 2;
       boolean result =  solve(0,G,color,N,M) ;
        System.out.println(result);




    }
}
