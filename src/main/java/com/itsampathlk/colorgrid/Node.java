/**
 * Author: Sampath Thennakoon
 * Version: 1.0
 * Date: 30.11.2021 4.16 PM
 */

package com.itsampathlk.colorgrid;

public class Node {

    private int nodeId;
    private char color;
    private Coordinate coordinate;

    public Node(int nodeId, char color, Coordinate coordinate) {
        this.nodeId = nodeId;
        this.color = color;
        this.coordinate = coordinate;
    }

    public Node(int nodeId, char color, int x, int y) {
        this.nodeId = nodeId;
        this.color = color;
        this.coordinate = new Coordinate(x, y);
    }

    public int getNodeId() {
        return nodeId;
    }

    public void setNodeId(int nodeId) {
        this.nodeId = nodeId;
    }

    public char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (nodeId != node.nodeId) return false;
        if (color != node.color) return false;
        return coordinate.equals(node.coordinate);
    }

    @Override
    public int hashCode() {
        int result = nodeId;
        result = 31 * result + (int) color;
        result = 31 * result + coordinate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Node{" +
                "nodeId=" + nodeId +
                ", color=" + color +
                ", coordinate=" + coordinate +
                '}';
    }
}
