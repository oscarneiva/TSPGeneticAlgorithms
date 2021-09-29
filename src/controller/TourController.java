/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.util.Random;
import model.Point;
import model.Tour;

/**
 *
 * @author Oscar Neiva
 */
public class TourController {
    private PointController pointController;
    
    public void generateTour(int number, int size){
        Random random = new Random();
        pointController = new PointController();
        char label = '@'; // Character that comes before A (Dec 64)
        Point[] points = new Point[size];
        
        label = (char) (label + 1);
        for (int i = 0; i < size; i++) {
            points[i] = pointController.getPoints().get(random.nextInt(20));
        }
        
        Tour tour = new Tour(label, points);
        System.out.println(tour.getFitness());
    }
}
