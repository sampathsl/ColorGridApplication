/**
 * Author: Sampath Thennakoon
 * Version: 1.0
 * Date: 30.11.2021 5.45 PM
 */

package com.itsampathlk.colorgrid;

public class Main {

    public static void main(String[] args) {

        // Set Default values
        int rows = 10;
        int columns = 10;

        if (args.length == 2) {
            try {
                rows = Integer.valueOf(args[0]);
                columns = Integer.valueOf(args[1]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        ColorChallenge challenge = new ColorChallenge();
        challenge.initializeGame(columns, rows);
        System.out.println("============INPUT GRID==========");
        challenge.printGrid();
        System.out.println("============OUTPUT GRID==========");
        Block block = challenge.getLargestInterconnectedBlock();
        if (block != null) {
            challenge.printGridWithBlock(block);
        }
    }

}
