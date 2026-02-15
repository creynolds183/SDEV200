package FinalProject;

import java.util.Scanner;

public class BoardTest {
    public static void main(String[] args) {
        /* String[][] testBoardOne = {{"", "X", "X"}, {"","",""}, {"","",""}};
        Board testBoard = new Board(testBoardOne);
        System.out.println(testBoard.CheckWin() + "test1");

        String[][] testBoardTwo = {{"X", "O", ""}, {"X","","O"}, {"","O","O"}};
        testBoard = new Board(testBoardTwo);
        System.out.println(testBoard.CheckWin() + "test2");

        String[][] testBoardThree = {{"X", "O", ""}, {"O","X","O"}, {"","O",""}};
        testBoard = new Board(testBoardThree);
        System.out.println(testBoard.CheckWin() + "test3");

        String[][] testBoardFour = {{"X", "O", "X"}, {"X","O","X"}, {"O","X","O"}};
        testBoard = new Board(testBoardFour);
        System.out.println(testBoard.CheckWin() + "test4"); */ //old code for testing my abstract board classes methods before creating the subclasses.

        SmallBoard testBoard = new SmallBoard();
        String currentTurn = "X";
        while(testBoard.checkWin().equals("")){
            Scanner input = new Scanner(System.in);
            System.out.println("Give a slot");

            int slot = input.nextInt();
            testBoard.PlaceElement(currentTurn, slot);

            if (currentTurn.equals("X")){
                currentTurn = "O";
            } else{
                currentTurn = "X";
            }

            System.out.println(testBoard.toString());
        }

        System.out.println(testBoard.checkWin());

    }
}
