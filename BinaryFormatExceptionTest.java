import java.util.Scanner;

class BinaryFormatException extends NumberFormatException{

}
public class BinaryFormatExceptionTest{
    
    public static Double Bin2Dec(String binaryString){
        if (binaryString.matches("[01]+")){
            return Double.longBitsToDouble(Long.parseLong(binaryString));
        } else{
            throw new BinaryFormatException();
        }
    }

    public static void main(String[] args) {
        Scanner UserString = new Scanner(System.in);
        System.out.println("Input a binary number");

        String BinaryString = UserString.nextLine();

    try{
        Double num = Bin2Dec(BinaryString);
        System.out.println(num);
    }
    catch (BinaryFormatException ex){
        System.out.println("Not a binary number");
    }
    } 

    
}
