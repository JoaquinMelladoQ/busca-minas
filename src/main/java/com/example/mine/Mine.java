package com.example.mine;
import java.util.Scanner;
import java.util.Random;

public class Mine {
    int rows, cols, mines;
    char[][] board;

    public Mine(int rows, int cols, int mines) {
        this.rows = rows;
        this.cols = cols;
        this.mines = mines;
        this.board = new char[rows][cols];
    }

    void generateMines() {
        Random random = new Random();
        int minesPlaced = 0;

        while (minesPlaced < mines) {
            int row = random.nextInt(rows);
            int col = random.nextInt(cols);

            if (board[row][col] != '*') {
                board[row][col] = '*';
                minesPlaced++;
            }
        }
    }

    public void play() {
        generateMines();
        Scanner scanner = new Scanner(System.in);
        int moves = 0;

        while (moves < 6) {
            System.out.println("Agrega tus coordenadas (fila): ");
            int row = scanner.nextInt();

            System.out.println("Agrega tus coordenadas (columna): ");
            int col = scanner.nextInt();

            if (row >= 0 && row < rows && col >= 0 && col < cols) {
                if (board[row][col] == '*') {
                    System.out.println("Lo lamento! Pisaste una mina en las coordenadas (" + (row) + ", " + (col) + ")!");
                    board[row][col] = 'X';
                    printBoard();
                    scanner.close();
                    return;
                } else {
                    moves++;
                }
            } else {
                System.out.println("Coordenadas invalidas. Intenta de nuevo.");
            }
        }

        System.out.println("Felicidades! Ganaste!");
        printBoard();
        scanner.close();
    }

    void printBoard() {
        System.out.println("Busca minas:");
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (board[i][j] == 'X') {
                    System.out.print("X ");
                } else {
                    System.out.print((board[i][j] == '*' ? "*" : "-") + " ");
                }
            }
            System.out.println();
        }
    }

}

