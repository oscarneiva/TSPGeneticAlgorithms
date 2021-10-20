package controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

import model.Point;
import model.Tour;

public class TourController {
    private PointController pointController;
    private Tour tour;
    private LinkedList<Tour> tours;
    
    public TourController(int number){
        generateTour(number);
    }

    public LinkedList<Tour> getTours() {
        return tours;
    }
    
    // Generate a population of tours
    public void generateTour(int number){
        pointController = new PointController();
        char label = '@'; // Character that comes before A (Dec 64)
        
        int size = pointController.getPoints().size();
        Point[] points = new Point[size];
        
        for (int i = 0; i < size; i++) {
            points[i] = pointController.getPoints().get(i);
        }
        
        tours = new LinkedList<>();
        for (int i = 0; i < number; i++) {
            label = (char) (label + 1);
            Collections.shuffle(Arrays.asList(points));
            tour = new Tour(label, points); 
            tours.add(tour);
        }
    }
}
