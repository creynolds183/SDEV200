package FinalProject;
// Board class used by both SmallBoard and LargeBoard 
public abstract class Board {
    String[][] board = new String[3][3];

    public Board() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = "";
            }
        }
    }

    public Board(String[][] board) {
        this.board = board;
    }

    public String checkWin(){
        //hard code certain elements for column and diagonal checks.
        String elementOne = board[0][0];
        String elementTwo = board[0][1];
        String elementThree = board[0][2];
        String elementFive = board[1][1];
        String elementSeven = board[2][0];
        String elementNine = board[2][2];
        int elementAmount = 0; //for checking if the board is full

        //check for horizontal win state
        for (int row = 0; row < 3; row++) {
            String firstElement = board[row][0];
            if(board[row][1].equals(firstElement) && board[row][2].equals(firstElement) && !firstElement.equals("")){
                return firstElement;
            }
        }
        //check for vertical win state in each column and diagonal
        if (board[1][0].equals(elementOne) && board[2][0].equals(elementOne) && !elementOne.equals("")){ //check Column one
            return elementOne;
        }else if (board[1][1].equals(elementTwo) && board[2][1].equals(elementTwo) && !elementTwo.equals("")){ //check Column two
            return elementTwo;
        }else if (board[1][2].equals(elementThree) && board[2][2].equals(elementThree) && !elementThree.equals("")){ //check Column three
            return elementThree;
        }else if(elementFive.equals(elementOne) && elementFive.equals(elementNine) && !elementFive.equals("")){ //check first diagonal
            return elementFive;
        } else if(elementFive.equals(elementThree) && elementFive.equals(elementSeven) && !elementFive.equals("")){
            return elementFive;
        }

        //check all the elements in the board if it is full without a winstate it should return nobody
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (!board[row][col].equals("")){
                    elementAmount++;
                }
            }
        }
        if (elementAmount == 9){
            return "Nobody";
        }

        return "";
    }
}
