package Recursion.Hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class nQueens {


    public static List<List<String>> solveNQueen(int n){
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.'; //place empty character as the initial value of character board[][]
            }
        }
        List<List<String>> res = new ArrayList<List<String>>();//this will store the all the possible way to store the queen

        //3 hash array will be created because we go from left to right on board
        //so for placing a queen we only check for left row,upperDiagonal,lowerDiagonal
        int leftRow[] = new int[n];//for checking the left row
        int upperDiagonal[] = new int[2 * n - 1];//for upper diagonal
        int lowerDiagonal[] = new int[2 * n - 1];//for lower diagonal
        solve(0,board,res,leftRow,lowerDiagonal,upperDiagonal);
        return res;
    }

    static void solve(int col,char[][] board,List<List<String>> res, int leftRow[],int lowerDiagonal[],int upperDiagonal[]){

        //base case -> when 'col' becomes equal to the board.length
        if(col == board.length){
            //we found a possible way to place the queen , then add 'board' to 'res'
            res.add(construct(board));
            return;
        }

        //for a single column we are going for all the rows
        for(int row=0;row<board.length;row++){
            if(leftRow[row] == 0 && lowerDiagonal[row+col] == 0 && upperDiagonal[board.length -1 + col - row] == 0){
                //mean there is no queen yet placed, so place the queen at that position
                board[row][col] = 'Q';
                leftRow[row] = 1; //make the position for 'leftRow' Hash Array
                lowerDiagonal[row+col] = 1;//make the position for 'lowerDiagonal' Hash Array
                upperDiagonal[board.length-1 +col-row] = 1;//make the position for 'upperDiagonal' Hash Array
                solve(col+1,board,res,leftRow,lowerDiagonal,upperDiagonal);//as a queen has been placed , make a call for next column
                board[row][col] = '.';//as you return back , remove the queen from that postion
                leftRow[row] = 0;//unmark the 'leftRow' hash Array
                lowerDiagonal[row+col] = 0;//unmark the 'lowerDiagonal' hash Array
                upperDiagonal[board.length -1 + col-row] = 0;//unmark the 'upperDiagonal' hash Array


            }
        }
    }

    static List<String> construct(char[][] board){
        //make a List to add to final List<List>
        List<String> res = new LinkedList<String>();
        for(int i=0;i<board.length;i++){
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }


    public static void main(String[] args) {
        int N = 4;
        List<List<String>> queen =solveNQueen(N);
        int i=1;
        //iterate the list of list by using a List<String>
        for(List<String> it:queen){
            System.out.println("Arrangement"+ i);
            //iterate the List it using a String variable 's'
            for(String s:it){
                System.out.println(s);
            }
            System.out.println();
            i+=1;//increment i
        }
    }
}
