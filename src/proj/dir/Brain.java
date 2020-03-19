package proj.dir;

import java.util.Scanner;

public class Brain {
    private Scanner scanner = new Scanner(System.in);
    //region startGame
    public void startGame() {
        Board board = new Board();
        board.initializingBoard();
        System.out.println("----Tic Tac Toe----");
        board.setCurrentPlayerMark('X');
        while(!board.checkComputerWin()) {
            if (board.isBoardFull()){
                System.out.println("Board is Full");
                return;
            }
            board.printBoard();
            System.out.println("\n");
            System.out.println("Please choose the place you want to mark");
            int x = scanner.nextByte();
            int y = scanner.nextByte();
            if (x - 1 >= board.getWidth() || y - 1 >= board.getHeight()) {
                System.out.println("Incorrect input");
                System.out.println("Please Try again");
                continue;

            }
            if (! isPlaceEmpty(board, x, y)) {
                System.out.println("Sorry,the place  has already taken ");
                System.out.println("Please Try again");
                continue;
            } else {
                putMark(board, x, y);
                botPlaying(board);
            }

        }
    }
    //endregion
    //region putMark
    private void putMark(Board board, int x, int y) {
        board.getBoard()[x - 1][y - 1] = board.getCurrentPlayerMark();
        board.changeCurrentPlayer();
    }
    //endregion
    //region isPlaceEmpty
    private boolean isPlaceEmpty(Board board,int x,int y){
        if(board.getBoard()[x-1][y-1] == 'X' || board.getBoard()[x-1][y-1] == '0')
            return false;
        return true;
    }
    //endregion
    //region botPlaying
    private void botPlaying(Board board) {

    }
    //endregion

}
