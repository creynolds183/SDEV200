import java.util.Scanner;

public class MultidimensionalArraysEqualCheck {
    public static boolean equals(int[][] m1, int[][] m2) {
        /* keep track of the amount of numbers that match in each point */
        int equalityNumber = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (m1[row][col] == m2[row][col]){
                    equalityNumber++;
                }
            }
        }
        /* if the 2d array is always a 3 by 3 this should be 9 if they are identical */
        return (equalityNumber == 9);
    } 

    public static int[][] ConvertArray(String[] stringArray) {
        int[] intArray = new int[stringArray.length];
        int[][] completeArray = new int[3][3];

        for (int i = 0;i < stringArray.length;i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                completeArray[row][col] = intArray[row * 3 + col];
            }
        }

        return completeArray;
    }

    public static void main(String[] args) {
        /* get two inputs and convert them into 2d arrays */
        Scanner input1 = new Scanner(System.in);
        System.out.print("Enter m1 (a 3 by 3 matrix) row by row: ");
        String m1String = input1.nextLine();
        String[] m1TempArray = m1String.split(" ");
        int[][] m1 = ConvertArray(m1TempArray);

        Scanner input2 = new Scanner(System.in);
        System.out.print("Enter m2 (a 3 by 3 matrix) row by row: ");
        String m2String = input2.nextLine();
        String[] m2TempArray = m2String.split(" ");
        int[][] m2 = ConvertArray(m2TempArray);

        /* check if they are identical and print the result */
        if (equals(m1, m2)) {
            System.out.println("The two arrays are strictly identical");
        } else {
            System.out.println("The two arrays are not strictly identical");
        }

    }
}
