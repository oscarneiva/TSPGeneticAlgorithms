package controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Point;

public class PointController {
    private Point point;
    private LinkedList<Point> points;

    public PointController(){
        generatePoints(20, 20);
    }

    public LinkedList<Point> getPoints() {
        return points;
    }
    
    // Generate a point that represents a city
    public void generatePoints(int number, int range){
        try{
            FileWriter fileWriter = new FileWriter("./data/points.csv", false);
            Random random = new Random();
            points = new LinkedList<>();

            char label = '@'; // Character that comes before A (Dec 64)

            for (int i = 0; i < number; i++) {
                int x = random.nextInt(range+1);
                int y = random.nextInt(range+1);
                label = (char) (label + 1);
                point = new Point(label,x,y);
                points.add(point);
                fileWriter.write(label + "," + x + "," + y);
                fileWriter.write(System.lineSeparator());
            }
            fileWriter.close();
        }catch(IOException error){
            System.out.println("Error while writing points in csv.");
        }
    } 
}
