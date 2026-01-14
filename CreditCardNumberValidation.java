import java.util.Scanner;

public class CreditCardNumberValidation{
    /** Return true if the card number is valid */
    public static boolean isValid(String number){
        int evenSum = 0;

        for (int i = 0; i < number.length(); i += 2){
            char oddNum = number.charAt(i);
            int digit = oddNum;

            evenSum += getDigit(digit);
        }
        for (int i = 1; i < number.length(); i += 2){

        }
        return false;
    }

    /** Get the result from Step 2 */
    public static int sumOfDoubleEvenPlace(int number){
        return 1;
    }

    /** Return this number if it is a single digit, otherwise,
     * return the sum of the two digits */
    public static int getDigit(int number){
        return 1;
    }

    /** Return sum of odd-place digits in number */
    public static int sumOfOddPlace(String number){
        return 1;
    }

    /** Return true if the number d is a prefix for number */
    public static boolean prefixMatched(String number, int d){
        return true;
    }

    /** Return the number of digits in d */
    public static int getSize(String d){
        return 1;
    }

    /** Return the first k number of digits from number. If the
     * number of digits in number is less than k, return number. */
    public static long getPrefix(String number, int k){
        return 1000000000;
    }

    public static void main(String[] args) {
        /* Get credit card number from input */
        Scanner userNum = new Scanner(System.in);
        System.out.println("Input a credit card number");

        String cardNumber = userNum.nextLine();

        isValid(cardNumber);
    }
}