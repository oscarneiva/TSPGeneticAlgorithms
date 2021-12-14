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
    
    public TourController(int numberOfTours){
        generateTour(numberOfTours);
    }

    public LinkedList<Tour> getTours() {
        return tours;
    }
    
    // Generate a population of tours
    public void generateTour(int numberOfTours){
        pointController = new PointController();
        char label = '@'; // Character that comes before A (Dec 64)
        
        int size = pointController.getPoints().size();
        
        tours = new LinkedList<>();
        for (int i = 0; i < numberOfTours; i++) {
            label = (char) (label + 1);
            
            Point[] points = new Point[size];
        
            for (int j = 0; j < size; j++) {
                points[j] = pointController.getPoints().get(j);
            }
            
            points = shuffle(points);
            tour = new Tour(label, points);
            tours.add(tour);
        }
    }

    public Point[] shuffle(Point[] arr){
        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            int x = random.nextInt(arr.length);
            int y = random.nextInt(arr.length);

            Point aux = arr[x];
            arr[x] = arr[y];
            arr[y] = aux;
        }

        return arr;
    }
}
