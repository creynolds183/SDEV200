package FinalProject;

//test class to be removed when JavaFX is added.
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
        
        Game ticTacToe = new Game();
        System.out.println(ticTacToe.run() + " Wins!");


    }
}
