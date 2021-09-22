/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tspgeneticalgorithms;

/**
 *
 * @author Oscar Neiva
 */
public class Point {
    private String label;
    private int x;
    private int y;
    
    public Point(String label, int x, int y) {
        this.label = label;
        this.x = x;
        this.y = y;
    }
    
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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
}
