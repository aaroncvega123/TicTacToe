
public class iluvyou
{
    public static void main(String[] args){
        int nthNumber = 3;
        int everything = 0;
        for(int i = 0; i < 100; i++){
            everything = everything + nthNumber;
            nthNumber = nthNumber + 5;
        }
        System.out.println(everything);
    }
}
