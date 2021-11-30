/**
 * Author: Sampath Thennakoon
 * Version: 1.0
 * Date: 30.11.2021 5.02 PM
 */

package com.itsampathlk.colorgrid;

import java.util.*;

public class ColorChallenge {

    private int colNum;
    private int rowNum;
    protected static final char[] COLORS = {'R', 'B', 'G'};
    private HashMap<Coordinate, Node> grid;

    public void initializeGame(int colNum, int rowNum) {
        this.colNum = colNum;
        this.rowNum = rowNum;
        // Randomly Generate Grid For Testing
        Random random = new Random();
        this.grid = new HashMap<>();
        for (int count = 0; count < colNum * rowNum; count++) {
            int x = count % colNum;
            int y = (int) Math.floor(count / colNum);
            this.grid.put(new Coordinate(x, y), new Node(count, COLORS[random.nextInt(3)], x, y));
        }
    }

    public Node getNode(int x, int y) {
        return this.grid.get(new Coordinate(x, y));
    }

    public void printGrid() {
        for (int rowCount = 0; rowCount < rowNum; rowCount++) {
            for(int columnCount = 0; columnCount < colNum; columnCount++) {
                if(columnCount == this.colNum - 1 ) {
                    System.out.println(getNode(columnCount, rowCount).getColor());
                } else {
                    System.out.print(getNode(columnCount, rowCount).getColor() + ", ");
                }
            }
        }
    }

    public void printGridWithBlock(Block block) {
        for (int rowCount = 0; rowCount < rowNum; rowCount++) {
            for(int columnCount = 0; columnCount < colNum; columnCount++) {
                Node n = getNode(columnCount, rowCount);
                char color = block.hasNode(n) ? '*' : n.getColor();
                if(columnCount == this.colNum - 1 ) {
                    System.out.println(color);
                } else {
                    System.out.print(color + ", ");
                }
            }
        }
    }

    private List<Node> findNeighouringNodes(Node n, Block block) {
        List<Node> nodes = new ArrayList<>();
        Coordinate coordinate = n.getCoordinate();
        Node northNode = this.grid.get(coordinate.getNorth());
        if (northNode != null && northNode.getColor() == n.getColor() && !block.hasNode(northNode)) {
            nodes.add(northNode);
        }
        Node southNode = this.grid.get(coordinate.getSouth());
        if (southNode != null && southNode.getColor() == n.getColor() && !block.hasNode(southNode)) {
            nodes.add(southNode);
        }
        Node eastNode = this.grid.get(coordinate.getEast());
        if (eastNode != null && eastNode.getColor() == n.getColor() && !block.hasNode(eastNode)) {
            nodes.add(eastNode);
        }
        Node westNode = this.grid.get(coordinate.getWest());
        if (westNode != null && westNode.getColor() == n.getColor() && !block.hasNode(westNode)) {
            nodes.add(westNode);
        }
        return nodes;
    }

    public Block getInterconnectedBlock(int x, int y) {

        Coordinate startCoordinate = new Coordinate(x, y);
        Node startNode = this.grid.get(startCoordinate);
        Block block = new Block(startNode.getColor());
        block.addNode(startNode);

        LinkedList<Node> nodesToVisit = new LinkedList<>();
        nodesToVisit.addAll(findNeighouringNodes(startNode, block));

        while(!nodesToVisit.isEmpty()) {
            Node nextNode = nodesToVisit.remove();
            block.addNode(nextNode);
            nodesToVisit.addAll(findNeighouringNodes(nextNode, block));
        }

        return block;
    }

    public Block getLargestInterconnectedBlock() {
        Set<Coordinate> allCoords = new HashSet<>(this.grid.keySet());
        List<Block> allBlocks = new ArrayList<>();
        while(!allCoords.isEmpty()) {
            Coordinate coord = allCoords.iterator().next();
            Block newBlock = getInterconnectedBlock(coord.getX(), coord.getY());
            allBlocks.add(newBlock);
            allCoords.removeAll(newBlock.getAllCoordinates());
        }
        Collections.sort(allBlocks);
        return !allBlocks.isEmpty() ? allBlocks.get(0) : null;
    }

}
