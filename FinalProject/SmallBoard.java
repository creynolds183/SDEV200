package FinalProject;

public class SmallBoard extends Board{

    public SmallBoard(){

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = "";
            }
        }
    }

    public String toString(){
        String boardString = "";

        for (int row = 0; row < 3; row++) {
            boardString = boardString + "\n";
            for (int col = 0; col < 3; col++) {
                if(board[row][col].equals("")){
                    if(col == 0){
                        boardString = boardString + " ";
                    }else{
                        boardString = boardString + "|" + " ";
                    }
                } else if(col == 0){
                    boardString = boardString + board[row][col];
                }else{
                    boardString = boardString + "|" + board[row][col];
                }
            }
        }

        return boardString;
    }
    public void PlaceElement(String e, int currentSlot){
        switch(currentSlot){
            case 1:
                board[0][0] = e;
                break;
            case 2:
                board[0][1] = e;
                break;
            case 3:
                board[0][2] = e;
                break;
            case 4:
                board[1][0] = e;
                break;
            case 5:
                board[1][1] = e;
                break;
            case 6:
                board[1][2] = e;
                break;
            case 7:
                board[2][0] = e;
                break;
            case 8:
                board[2][1] = e;
                break;
            case 9:
                board[2][2] = e;
                break;
        }

        checkWin();
    }
}
