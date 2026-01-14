import java.util.Scanner;

public class CreditCardNumberValidation{
    /** Return true if the card number is valid */
    public static boolean isValid(String number){
        int evenSum = getDigit(number);
        int oddSum = sumOfOddPlace(number);
        int sum = oddSum + evenSum;
        
        return sum % 10 == 0;
    }

    /** Get the result from Step 2 */
    public static int sumOfDoubleEvenPlace(int number){
        return 1 + (number % 10);
    }

    /** Return this number if it is a single digit, otherwise,
     * return the sum of the two digits */
    public static int getDigit(String number){
        int sum = 0;

        for (int i = 0; i < number.length(); i += 2){
            char evenNum = number.charAt(i); 
            int digit = Character.getNumericValue(evenNum);
            digit *= 2;
            if (digit < 10) {
                sum += digit;
            } else {
                sum += sumOfDoubleEvenPlace(digit);
            }
        }
        return sum;
    }

    /** Return sum of odd-place digits in number */
    public static int sumOfOddPlace(String number){
        int sum = 0;

        for (int i = 1; i < number.length(); i += 2){
            char oddNum = number.charAt(i);
            int digit = Character.getNumericValue(oddNum);
            sum += digit; 
        }
        return sum;
    }

    /** Return true if the number d is a prefix for number */
    public static boolean prefixMatched(String number, int d){
        /* this functions was part of the sample code but I do not
        * understand how it is needed to get the desired results. */
        return true;
    }

    /** Return the number of digits in d */
    public static int getSize(String d){
        /* this functions was part of the sample code but I do not
        * understand how it is needed to get the desired results. */
        return 1;
    }

    /** Return the first k number of digits from number. If the
     * number of digits in number is less than k, return number. */
    public static long getPrefix(String number, int k){
        /* this functions was part of the sample code but I do not
        * understand how it is needed to get the desired results. */
        return 1;
    }

    public static void main(String[] args) {
        /* Get credit card number from input */
        Scanner userNum = new Scanner(System.in);
        System.out.println("Input a credit card number");

        String cardNumber = userNum.nextLine();

        if (isValid(cardNumber)) {
            System.out.println(cardNumber + " is valid");
        } else {
            System.out.println(cardNumber + " is invalid");   
        }
    }
}