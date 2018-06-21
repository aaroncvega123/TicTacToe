import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class TicTacToeMain
{
    public static TicTacToe use = new TicTacToe();

    public static void main(String[] args){
        boolean isTrue = true;
        Scanner keyboard = new Scanner(System.in);
        Scanner inputSave = null;
        PrintWriter outputSave = null;

        while(true){
            clearScreen();
            use.TicTacToeClass();
            mainMenu();
            int menuInput = keyboard.nextInt();
            boolean isTrue2 = true;
            while(true){
                if(menuInput >= 1 && menuInput <= 3){
                    break;
                }
                else{
                    clearScreen();
                    mainMenu();
                    menuInput = keyboard.nextInt();
                }
            }
            //this section contains functions for the main menu
            char whosTurn = 'H';
            if(menuInput == 1){
                int player = (int )(Math.random() * 2 + 1);
                if(player == 1){
                    whosTurn = 'H';
                }
                else if(player == 2){
                    whosTurn = 'C';
                }
            }
            else if(menuInput == 3){
                break;
            }
            // this section loads saved games
            else if(menuInput == 2){
                while(true){
                    System.out.print('\u000c');
                    int saveInput = keyboard.nextInt();
                    System.out.println("Enter file number and press enter");
                    System.out.println("1");
                    System.out.println("2");
                    System.out.println("3");
                    saveInput = keyboard.nextInt();
                    if(saveInput <= 1 && saveInput >= 3){
                        String saveMenuChoice = saveInput + ".txt";
                        try {
                            inputSave = new Scanner(new FileInputStream(saveMenuChoice));
                            outputSave = new PrintWriter(new FileOutputStream(saveMenuChoice));
                        } catch (FileNotFoundException e) {
                            System.out.println("File not found");
                        }
                        String fileMemory = inputSave.next();
                        use.loadSave(fileMemory);
                        break;
                    }
                    else{
                        clearScreen();

                    }
                }
            }
            //this section is where gameplay happens
            //H stands for Human. C stands for computer.
            gameplay(whosTurn);
        }
        clearScreen();
        System.out.println("Thanks for playing");
    }

    public static void mainMenu(){
        System.out.println("Welcome to TicTacToe!");
        System.out.println("1 - New Game");
        System.out.println("2 - Load Saved Game");
        System.out.println("3 - Exit");
    }

    public static void clearScreen(){
        System.out.print('\u000C');
    }

    public static void gameplay(char whosTurn){
        Scanner keyboard = new Scanner(System.in);
        while(true){
            char piece = ' ';
            while(true){
                if(use.numTurns() == 0){
                    piece = 'X';
                }
                if(whosTurn == 'H' && use.isWinner(piece) == false){
                    clearScreen();
                    System.out.println("Please enter row and column number (1 - 3)");
                    while(true){
                        System.out.printf("%n");
                        use.displayBoard();
                        int moveRow = keyboard.nextInt() - 1;
                        int moveCol = keyboard.nextInt() - 1;
                        if(use.isValid(moveRow, moveCol) == true){
                            use.playMove(piece, moveRow, moveCol);
                            break;
                        }
                        else if(use.isValid(moveRow, moveCol) == false){
                            clearScreen();
                            System.out.print("Invalid entry. Try Again");
                            System.out.printf("%n");
                        }
                    }
                    if(piece == 'X'){
                        piece = 'O';
                    }
                    else if(piece == 'O'){
                        piece = 'X';
                    }
                    whosTurn = 'C';
                }
                else if(whosTurn == 'C' && use.isWinner(piece) == false){

                    while(true){
                        int moveRow = (int )(Math.random() * 3 + 0);
                        int moveCol = (int )(Math.random() * 3 + 0);
                        if(use.isValid(moveRow, moveCol) == true){
                            use.playMove(piece, moveRow, moveCol);
                            break;
                        }
                    }
                    if(piece == 'X'){
                        piece = 'O';
                    }
                    else if(piece == 'O'){
                        piece = 'X';
                    }
                    whosTurn = 'H';
                }
                if(use.isFull() == true){
                    if(use.isCat()){
                        clearScreen();
                        System.out.println("Draw! Press enter to go to main menu.");
                        use.displayBoard();
                        String enter = keyboard.next();
                        if(enter == ""){
                            break;
                        }
                    }
                    else if(use.isWinner('X') == true){
                        clearScreen();
                        System.out.println("X wins! Press enter for main menu.");
                        System.out.printf("%n");
                        use.displayBoard();
                        try{
                            System.in.read();
                        }
                        catch(Exception e){
                        }
                        break;
                    }
                    else if(use.isWinner('O') == true){
                        clearScreen();
                        System.out.println("O wins! Press enter for main menu.");
                        System.out.printf("%n");
                        use.displayBoard();
                        try{
                            System.in.read();
                        }
                        catch(Exception e){
                        }
                        break;
                    }
                }
                else if(use.isWinner('X') == true){
                    clearScreen();
                    System.out.println("X wins! Press enter for main menu.");
                    System.out.printf("%n");
                    use.displayBoard();
                    try{
                        System.in.read();
                    }
                    catch(Exception e){
                    }
                    break;
                }
                else if(use.isWinner('O') == true){
                    clearScreen();
                    System.out.println("O wins! Press enter for main menu.");
                    System.out.printf("%n");
                    use.displayBoard();
                    try{
                        System.in.read();
                    }
                    catch(Exception e){
                    }
                    break;
                }
            }
            break;
        }
    }
}
