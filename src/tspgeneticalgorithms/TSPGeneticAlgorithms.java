/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tspgeneticalgorithms;

import controller.PointController;
import controller.TourController;

/**
 *
 * @author Oscar Neiva
 */
public class TSPGeneticAlgorithms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Point pointA = new Point("A", 2, 2);
//        Point pointB = new Point("B", 1, 1);
//        Point pointC = new Point("C", 1, 2);
//
//        Point[] points = new Point[]{pointA, pointB, pointC};
//        
//        Tour tour = new Tour("A", points);
//        System.out.println(tour.getFitness());
        
        TourController tourController = new TourController();
        tourController.generateTour(1, 20);
    }
    
}
