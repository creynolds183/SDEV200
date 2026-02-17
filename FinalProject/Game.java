package FinalProject;

import java.util.Scanner;

//expandable game class could be turned into a multi game software
public class Game {
    // Tic tac toe board variables to be intialized for each game, multiple games
    // could be played
    public BigBoard board;
    public Scanner input;

    // Game constructor
    public Game() {
        board = new BigBoard();
        input = new Scanner(System.in);
    }

    // Run the game until a winstate is reached print the win state(Will be changed
    // with JavaFX where a Loop will be uneeded.)
    public String run() {
        System.out.println(board.toString()); //first placement is always X
        int nextBoard = board.PlaceElement("X", 0);
        while (board.checkWin().equals("")) {
            System.out.println(board.toString());
            if (board.checkWin() == ""){ //check for a win state to end loop early
                nextBoard = board.PlaceElement("O", nextBoard);
            }else{
                continue;
            }
            if (board.checkWin() == ""){ // check for a win state to end loop early
                nextBoard = board.PlaceElement("X", nextBoard);
            }else{
                continue;
            }
            // if (nextBoard == 0) {
            //     System.out.print("O pick any valid board");
            //     System.out.println(board.toString());
            //     nextBoard = input.nextInt();
            //     while (nextBoard < 1 || nextBoard > 9) {
            //         System.out.println(" OChoose a valid board");
            //         nextBoard = input.nextInt();
            //         nextBoard = input.nextInt();
            //     }
            //     nextBoard = board.PlaceElement("O", nextBoard);
            // }else{
            //     nextBoard = board.PlaceElement("O", nextBoard);
            // }

            // if (nextBoard == 0) {
            //     System.out.print("X pick any valid board");
            //     System.out.println(board.toString());
            //     nextBoard = input.nextInt();
            //     while (nextBoard < 1 || nextBoard > 9) {
            //         System.out.println("Choose a valid board");
            //         System.out.println(board.toString());
            //         nextBoard = input.nextInt();
            //     }
            //     nextBoard = board.PlaceElement("X", nextBoard);
            // } else {
            //     nextBoard = board.PlaceElement("X", nextBoard);
            // }
        }
        input.close();
        return board.checkWin();
    }
}
