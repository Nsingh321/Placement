package Recursion.Hard;

public class SudokoSolver {


    static boolean solve(char[][] board){

        //go through every index(r,c)
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                //check if it is black space(.)
                if(board[i][j] == '.'){
                    //if yes then try for every possible value from 1 to 9
                    for(char c='1';c<='9';c++){
                        //can the value be placed at the index (r,c) without violating all 3 Rules
                        if(isValid(board,i,j,c) == true){
                            //if yes then place the value of c(the value between 1 to 9) at index(r,c)
                            board[i][j] = c;
                            //make a recusive call and check if anytime you get a true (means a single possible solution found)
                            if(solve(board) == true){
                                return true;
                            }
                            //if you get a 'false' then means that you cannot place any value at index(r,c) replace the previous value with a blank space(.)
                            else{
                                board[i][j] = '.';
                            }
                        }

                    }

                    return false;//we are not able to place any value on the index(r,c) means we need to go back and remove the previous put value
                }
            }
        }
        return true;//after going through every row and col , if we do not get a blank space than it means that we got a possible solution
    }

    public static boolean isValid(char[][] board , int row,int col,char c){
        for (int i = 0; i < 9; i++) {
            if(board[i][col] == c) return false;//col same  , row changing

            if(board[row][i] == c) return false;//row same  , col changing
            if(board[3*(row/3)+ i/3][3*(col/3) + i%3] == c) return false;//going through a 3x3 block
        }
        return true;//not violating any of the 3 rule --> so can be placed there
    }

    public static void main(String[] args) {

        char[][] board= {
                {'9', '5', '7', '.', '1', '3', '.', '8', '4'},
                {'4', '8', '3', '.', '5', '7', '1', '.', '6'},
                {'.', '1', '2', '.', '4', '9', '5', '3', '7'},
                {'1', '7', '.', '3', '.', '4', '9', '.', '2'},
                {'5', '.', '4', '9', '7', '.', '3', '6', '.'},
                {'3', '.', '9', '5', '.', '8', '7', '.', '1'},
                {'8', '4', '5', '7', '9', '.', '6', '1', '3'},
                {'.', '9', '1', '.', '3', '6', '.', '7', '5'},
                {'7', '.', '6', '1', '8', '5', '4', '.', '9'}
        };
        solve(board);

        //print the solution of the sudoko solver
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}


