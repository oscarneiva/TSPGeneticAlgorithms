package model;

public class Tour {
    private char label;
    private Point[] points;
    private double fitness;

    public Tour(char label, Point[] points) {
        this.label = label;
        this.points = points;
    }
    
    public char getLabel() {
        return label;
    }

    public void setLabel(char label) {
        this.label = label;
    }

    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }

    public double getFitness() {
        double totalDistance = 0;
        
        for (int i = 0; i < points.length; i++) {
            if(i == points.length-1){ 
                totalDistance = totalDistance + Math.sqrt(Math.pow(points[i].getX() - points[0].getX(), 2) + Math.pow(points[i].getY() - points[0].getY(), 2));
            }else{ 
                totalDistance = totalDistance + Math.sqrt(Math.pow(points[i].getX() - points[i+1].getX(), 2) + Math.pow(points[i].getY() - points[i+1].getY(), 2));
            }
        }
        
        return 1/totalDistance;
    } 
}
