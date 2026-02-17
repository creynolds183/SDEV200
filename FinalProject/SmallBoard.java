package FinalProject;

public class SmallBoard extends Board {

    // create a board
    public SmallBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = "";
            }
        }
    }

    // convert the board to a string, will be removed when JavaFX is added.
    public String toString(int rowNum) {
        String boardString = "";

        for (int col = 0; col < 3; col++) {
            if (board[rowNum][col].equals("")) {
                if (col == 0) {
                    boardString = boardString + " ";
                } else {
                    boardString = boardString + "|" + " ";
                }
            } else if (col == 0) {
                boardString = boardString + board[rowNum][col];
            } else {
                boardString = boardString + "|" + board[rowNum][col];
            }
        }

        return boardString;
    }

    //find the col and row on the board before placing element e in that slot
    @Override
    public int PlaceElement(String e, int currentSlot) {
        int row;
        int col;
        switch (currentSlot) {
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
                System.out.println("Choose a valid slot");
                return 0;
        }
        if (board[row][col] == "") {
            board[row][col] = e;
            return currentSlot;
        } else {
            System.out.println("Choose a valid slot");
            return 0;
        }
    }
}
