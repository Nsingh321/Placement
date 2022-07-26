package Stacks;

//TC = O(N X N) X 4 -> for every cell there is a for loop for up,down,left,right
//SC = O(N X N) -> at worst the queue will store all rotten oranges in 4 adjacent cells
import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public static int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        //Applying BFS Traversal so using Queue Data structure
        Queue<int[]> queue = new LinkedList<>();
        int count_fresh = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(grid[i][j] == 2) queue.offer(new int[]{i,j});//add all rotten to the queue
                if(grid[i][j] !=0 ) count_fresh++; //count non-empty cells
            }
        }
        if(count_fresh == 0) return 0; //non - empty cells = 0(all empty)
        int minDays = 0,cnt = 0;
        int dx[] = {0,0,1,-1};
        int dy[] = {1,-1,0,0};

        while(!queue.isEmpty()){
            int size = queue.size();
            cnt = cnt + size;
            for (int i = 0; i < size; i++) {
                int point[] = queue.poll();

                //loop for going in all 4 directions of a point (left,right,up,down)
                for (int j = 0; j < 4; j++) {
                    int x = point[0] + dx[j];
                    int y = point[1] + dy[j];

                    //checking the boundary conditions , empty , rotten cells-> cannot go on those cells
                    if(x<0 || y<0 || x>=rows || y>=cols || grid[x][y] == 0 || grid[x][y] == 2) continue;
                    grid[x][y] = 2; //make the new orange as rotten
                    queue.offer(new int[]{x,y}); //add the new rotten coordinate to queue
                }
            }
            //if queue size is not zero -> mean it made some oranges rotten
            if(queue.size()!=0)  minDays++;
        }
        //if the no. of non-empty cells which were the at the beginning == cnt(which stores the track of all the rotten oranges)
        //then return the minDays or else -1
        return count_fresh == cnt ? minDays : -1;

    }

    public static void main(String[] args) {
        int grid[][] = {{2,1,1},{0,1,1},{1,0,1}};

        System.out.println(orangesRotting(grid));



    }
}
