package controller;

import model.Tour;

import java.util.Random;

public class SelectionStrategies {
    private TourController tourController;
    private Tour[] matingPool;
    private Random random = new Random();

    public SelectionStrategies(){
        tourController = new TourController(10,20,20);
    }

    public void rouletteWheelSelection(int numberOfElements){
        double sumFitness = 0.0;
        Tour selectedTour = null;
        matingPool = new Tour[numberOfElements];

        for (int i = 0; i < numberOfElements; i++) {
            for (int j = 0; j < tourController.getTours().size(); j++) {
                sumFitness = sumFitness + tourController.getTours().get(j).getFitness();
            }

            double randomValue = 0 + (sumFitness - 0) * random.nextDouble();
            double rangeMin = 0;
            double rangeMax = 0;

            for (int j = 0; j < tourController.getTours().size(); j++) {
                rangeMax = rangeMax + tourController.getTours().get(j).getFitness();
                if(rangeMin < randomValue &&
                        randomValue < rangeMax){
                    selectedTour = tourController.getTours().get(j);
                }
                rangeMin = rangeMin + tourController.getTours().get(j).getFitness();
            }

            matingPool[i] = selectedTour;
        }
        for (int i = 0; i < numberOfElements; i++) {
            System.out.println(matingPool[i].getLabel());
        }
    }

    public void stochasticUniSampling(){

    }

    public void tournamentSelection(){

    }

    public void truncationSelection(){

    }

    public Tour[] getMatingPool() {
        return matingPool;
    }
}
