package com.joelallison;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static void printBoard(int width, int height, String[][] board) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (board[i][j] == null){
                    board[i][j] = "-";
                }
                System.out.print("[" + board[i][j] + "] ");
            }
            System.out.println("");
        }
    }

    static int[] genCoords(int width, int height){
        Random random = new Random();

        return new int[] {random.nextInt(width), random.nextInt(height)};
    }

    public static void main(String[] args) {
        Random random = new Random();

        Scanner input = new Scanner(System.in);

        final int boardWidth = 10;
        final int boardHeight = 8;
        String[][] board = new String[boardWidth][boardHeight];

        //amount of treasure is 25% of board size
        final int amountOfTreasure = (int) ((boardWidth * boardHeight) * 0.25);
        final int maxCoins = 9;
        int playerCoins = 0;

        //put treasure onto board
        for (int i = 0; i < amountOfTreasure; i++) {
            int[] coords = genCoords(boardWidth, boardHeight);
            board[coords[0]][coords[1]] = Integer.toString(random.nextInt(maxCoins)+1);
        }

        System.out.println(" ".repeat(boardWidth / 2) + "--> TREASURE HUNT <--\n");

        boolean playing = false;
        //gameloop
        do{
            printBoard(boardWidth, boardHeight, board);
        }while(playing);


    }
}