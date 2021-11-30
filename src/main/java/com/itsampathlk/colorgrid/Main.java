/**
 * Author: Sampath Thennakoon
 * Version: 1.0
 * Date: 30.11.2021 5.45 PM
 */

package com.itsampathlk.colorgrid;

public class Main {

    public static void main(String[] args) {

        // Set Default values
        int WIDTH = 10;
        int HEIGHT = 10;

        if (args.length == 2) {
            try {
                WIDTH = Integer.valueOf(args[0]);
                HEIGHT = Integer.valueOf(args[1]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        ColorChallenge challenge = new ColorChallenge();
        challenge.initializeGame(WIDTH, HEIGHT);
        System.out.println("============INPUT GRID==========");
        challenge.printGrid();
        System.out.println("============OUTPUT GRID==========");
        Block block = challenge.getLargestInterconnectedBlock();
        if (block != null) {
            challenge.printGridWithBlock(block);
        }
    }

}
