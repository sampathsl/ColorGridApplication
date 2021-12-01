/**
 * Author: Sampath Thennakoon
 * Version: 1.0
 * Date: 30.11.2021 4.31 PM
 */

package com.itsampathlk.colorgrid;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Block implements Comparable<Block> {

    private char color;
    private Set<Node> nodes;

    public Block(char color) {
        this.color = color;
        nodes = new HashSet<>();
    }

    public Set<Node> allNodes() {
        return nodes;
    }

    public Set<Coordinate> getAllCoordinates() {
        return nodes.stream().map(Node::getCoordinate).collect(Collectors.toSet());
    }

    public boolean addNode(Node node) {
        if (node != null && !nodes.contains(node)
                && node.getColor() == this.color) {
            return nodes.add(node);
        }
        return false;
    }

    public boolean hasNode(Node node) {
        if (node == null)
            return false;
        return nodes.stream().anyMatch(n -> n.getNodeId() == node.getNodeId());
    }

    public void display() {
        nodes.forEach(n -> System.out.print(n.toString()));
    }

    public int size() {
        return nodes.size();
    }

    @Override
    public int compareTo(Block o) {
        return o.size() - this.size();
    }

}
