package FinalProject;

import java.util.Scanner;

public class BigBoard extends Board {
    SmallBoard[][] smallBoardArray = new SmallBoard[3][3];
    Scanner input;

    // create the boards
    public BigBoard() {
        // Scanner for choosing a new board
        input = new Scanner(System.in);

        // board array for winning the game
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = "";
            }
        }

        // array of small boards
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                smallBoardArray[row][col] = new SmallBoard();
            }
        }
    }

    // make a string of the board for testing does not work.
    public String toString() {
        String boardString = "";

        for (int x = 0; x < 3; x++) {
            for (int z = 0; z < 3; z++) {
                for (int y = 0; y < 3; y++) {
                    boardString = boardString + smallBoardArray[x][z].toString(y);
                }
                boardString = boardString + "\n";
            }
        }
        return boardString;
    }

    // based on the selected slot set the row and col for the smallboard before
    // placing an element in that board
    @Override
    public int PlaceElement(String e, int currentSlot) {
        // create temporary variables
        int row;
        int col;

        // check what board to place in
        switch (currentSlot) {
            case 0:
                // if a small board is at a win state the player can select any board
                System.out.println(e + " Pick any board");
                int anySlot = input.nextInt();
                if (anySlot > 0 && anySlot < 10) {
                    return PlaceElement(e, anySlot);
                } else {
                    System.out.println("Choose a valid board");
                    return PlaceElement(e, 0);
                }
            case 1:
                row = 0;
                col = 0;
                break;
            case 2:
                row = 0;
                col = 1;
                break;
            case 3:
                row = 0;
                col = 2;
                break;
            case 4:
                row = 1;
                col = 0;
                break;
            case 5:
                row = 1;
                col = 1;
                break;
            case 6:
                row = 1;
                col = 2;
                break;
            case 7:
                row = 2;
                col = 0;
                break;
            case 8:
                row = 2;
                col = 1;
                break;
            case 9:
                row = 2;
                col = 2;
                break;
            default:
                return 0;
        }
        // based on the board selected place an element in it
        if (smallBoardArray[row][col].checkWin() == "") {
            System.out.println(e + " Pick a Slot on board " + currentSlot);
            int slot = input.nextInt();
            if (!(smallBoardArray[row][col].PlaceElement(e, slot) == 0)) { // if a board is at a win state choose any
                                                                           // board
                if (smallBoardArray[row][col].checkWin() == "") { // after placing a token if the small board is at a
                                                                  // winstate at that win state to the big board array
                    return slot;
                } else {
                    board[row][col] = smallBoardArray[row][col].checkWin();
                    return slot;
                }
            } else {
                System.out.println(e + " Pick a valid slot");
                return PlaceElement(e, currentSlot);
            }
        } else {
            return PlaceElement(e, 0);
        }
    }
}
