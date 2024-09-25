package Hw1.Exe6;

import java.util.Scanner;

public class TicTacToe {
    private char[][] board = new char[3][3];
    private char currentPlayer = 'X';

    public TicTacToe() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') return false;
            }
        }
        return true;
    }

    public boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) return true;
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) return true;
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) return true;
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) return true;
        return false;
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printBoard();
            System.out.println("Người chơi " + currentPlayer + ", chọn hàng và cột (0-2): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            if (board[row][col] == '-') {
                board[row][col] = currentPlayer;
                if (checkWin()) {
                    printBoard();
                    System.out.println("Người chơi " + currentPlayer + " thắng!");
                    break;
                }
                if (isBoardFull()) {
                    printBoard();
                    System.out.println("Trò chơi hòa!");
                    break;
                }
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Vị trí đã được chọn, chọn vị trí khác.");
            }
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.playGame();
    }
}
