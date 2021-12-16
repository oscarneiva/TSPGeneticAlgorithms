package tspgeneticalgorithms;

import controller.SelectionStrategies;
import controller.TourController;

public class TSPGeneticAlgorithms {
    public static void main(String[] args) {
        //TourController tourController = new TourController(3,20,20);
        //System.out.println(tourController.getTours().get(0).getFitness());
        SelectionStrategies selectionStrategies = new SelectionStrategies();
        selectionStrategies.rouletteWheelSelection(3);
    }
}
