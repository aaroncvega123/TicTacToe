import java.util.Scanner;

public class boxes
{
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter an integer");
        int boxSize = keyboard.nextInt();
        int star1 = 2;
        int star2 = boxSize - 1;
        for(int i = 1; i <= boxSize; i++){
            if(i == 1 || i == boxSize){
                for(int j = 1; j <= boxSize; j++){
                    System.out.print("* ");
                }
            }
            else{
                for(int k = 1; k <= boxSize; k++){
                    if(k == 1 || k == boxSize){
                        System.out.print("* ");
                    }
                    else if(k == star1 || k == star2){
                        System.out.print("* ");
                    }
                    else{
                        System.out.print("  ");
                    }
                }
                star1++;
                star2--;
            }
            System.out.printf("%n");
        }
    }
}
