package com.joelallison;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static void printBoard(int width, int height, String[][] board, Boolean[][] knownSpots) {
        System.out.println("");
        System.out.print("  ");
        for (int i = 1; i <= width; i++) {
            System.out.print(" " + i + " ");
        }System.out.println("");
        for (int i = 0; i < height; i++) {
            System.out.print(i+1 + " ");
            for (int j = 0; j < width; j++) {
                if (knownSpots[i][j] == true){
                    if (board[i][j] == null){
                        board[i][j] = "x";
                    }
                    System.out.print("[" + board[i][j] + "]");
                }else{
                    System.out.print("[-]");
                }
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

        final int boardWidth = 9;
        final int boardHeight = 9;
        String[][] board = new String[boardWidth][boardHeight];
        Boolean[][] known = new Boolean[boardWidth][boardHeight];

        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < boardHeight; j++) {
                known[i][j] = false;
            }
        }

        //amount of treasure is 25% of board size
        final int amountOfTreasure = (int) ((boardWidth * boardHeight) * 0.25);
        final int maxCoins = 9;
        int playerCoins = 0;
        // declared as -1 so that point 0,0 isn't checked and used to increment player score
        int[] playerGuess = new int[]{-1,-1};

        //put treasure onto board
        for (int i = 0; i < amountOfTreasure; i++) {
            int[] coords = genCoords(boardWidth, boardHeight);
            board[coords[0]][coords[1]] = Integer.toString(random.nextInt(maxCoins)+1);
        }

        //convoluted way of doing padding d(^-^)
        System.out.println(new String(new char[(boardWidth/2)-1]).replace("\0", " ") + "  --> TREASURE HUNT <--\n");
        System.out.println("This is your board:");

        //gameloop
        while (true){
            System.out.println("");

            if(playerGuess[0] != -1  && board[playerGuess[1]][playerGuess[0]] != null){
                System.out.println("You found treasure! Your score increased by " + board[playerGuess[1]][playerGuess[0]]);
                playerCoins += Integer.parseInt(board[playerGuess[1]][playerGuess[0]]);
            }System.out.println("Score: " + playerCoins);

            printBoard(boardWidth, boardHeight, board, known);



            System.out.println("\n(type 'q' to quit if you want... but otherwise...)\n\nGuess coordinates [1-9 either axis, formatted 'xy']:");
            String storedGuess = input.next();
            if (storedGuess.equalsIgnoreCase(("q"))){break;}

            playerGuess[0] = Integer.parseInt(String.valueOf(storedGuess.charAt(0))) - 1;
            playerGuess[1] = Integer.parseInt(String.valueOf(storedGuess.charAt(1))) - 1;

            known[playerGuess[1]][playerGuess[0]] = true;


        }


    }
}