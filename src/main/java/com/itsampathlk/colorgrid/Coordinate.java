/**
 * Author: Sampath Thennakoon
 * Version: 1.0
 * Date: 30.11.2021 4.00 PM
 */

package com.itsampathlk.colorgrid;

public class Coordinate {

    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Coordinate getNorth() {
        return new Coordinate(x, y - 1);
    }

    public Coordinate getSouth() {
        return new Coordinate(x, y + 1);
    }

    public Coordinate getWest() {
        return new Coordinate(x - 1, y);
    }

    public Coordinate getEast() {
        return new Coordinate(x + 1, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinate that = (Coordinate) o;

        if (x != that.x) return false;
        return y == that.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
