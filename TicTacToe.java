
public class TicTacToe
{
    private char[][] board = new char[3][3];
    private int turns = 0;
    public void TicTacToeClass(){
        int N = board.length;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                board[i][j] = '_';
            }
        }
    }

    public boolean isWinner(char ox){
        int x = 0;
        while(x < 3){
            if(board[x][0] == ox && board[x][1] == ox && board[x][2] == ox){
                return true;
            }
            else if(board[0][x] == ox && board[1][x] == ox && board[2][x] == ox){
                return true;
            }
            x++;
        }
        if(board[0][0] == ox && board[1][1] == ox && board[2][2] == ox){
            return true;
        }
        else if(board[2][0] == ox && board[1][1] == ox && board[0][2] == ox){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if(turns == 9){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isCat(){
        if(isFull() == true && isWinner('O') == false && isWinner('X') == false){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isValid(int r, int c){
        if(r >= 0 && r <= 2 && c >= 0 && c <= 2 && board[r][c] != 'X' && board[r][c] != 'O'){
            return true;
        }
        else{
            return false;
        }
    }

    public int numTurns(){
        turns = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 'X' || board[i][j] == 'O'){
                    turns++;
                }
            }
        }
        return turns;
    }

    public void displayBoard(){
        int N = board[0].length;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(j == 0){
                    System.out.print("           ");
                    if(board[i][j] == ' '){
                        System.out.print("( )");
                        System.out.print("");
                    }
                    else{
                        System.out.print(board[i][j]);
                        System.out.print(" ");
                    }
                }
                else{
                    if(board[i][j] == ' '){
                        System.out.print("( )");
                        System.out.print("");
                    }
                    else{
                        System.out.print(board[i][j]);
                        System.out.print(" ");
                    }
                }
            }
            System.out.printf("%n");
        }
    }

    public void playMove(char p, int r, int c){
        if(isValid(r, c) == true){
            board[r][c] = p;
        }
        turns++;
    }

    public char loadSave(String fileMemory){
        int N = board.length;
        int charCount = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                board[i][j] = fileMemory.charAt(charCount);
                charCount++;
            }
        }
        char whosTurn = fileMemory.charAt(9);
        return whosTurn;
    }
}
