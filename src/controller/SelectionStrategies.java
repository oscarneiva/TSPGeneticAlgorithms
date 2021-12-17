package controller;

import model.Tour;

import java.util.Random;

public class SelectionStrategies {
    private Tour[] matingPool;
    private TourController tourController;
    private Random random = new Random();

    public SelectionStrategies(){
        tourController = new TourController(10,20,20);
    }

    public Tour[] rouletteWheelSelection(int numberOfElements){
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
        
        return matingPool;
    }

    public Tour[] stochasticUniSampling(int numberOfGenerations){
        double sumFitness = 0.0;
        double[] randomValue = new double[4];
        Tour selectedTour = null;
        matingPool = new Tour[numberOfGenerations];

        for (int i = 0; i < numberOfGenerations; i++) {
            for (int j = 0; j < tourController.getTours().size(); j++) {
                sumFitness = sumFitness + tourController.getTours().get(j).getFitness();
            }

            randomValue[0] = 0 + (sumFitness - 0) * random.nextDouble();
            if (randomValue[0] < sumFitness/2) {
                randomValue[1] = sumFitness / 2 + randomValue[0];
                randomValue[2] = (randomValue[1] - randomValue[0])/2 + randomValue[1];
                randomValue[3] = (randomValue[1] - randomValue[0])/2 + randomValue[0];
                if (randomValue[2] > sumFitness) randomValue[2] = randomValue[2] - sumFitness;
                if (randomValue[3] > sumFitness) randomValue[3] = randomValue[3] - sumFitness;
            }else if (randomValue[0] > sumFitness/2) {
                randomValue[1] = randomValue[0] - sumFitness / 2;
                randomValue[2] = (randomValue[1] - randomValue[0])/2 + randomValue[1];
                randomValue[3] = (randomValue[1] - randomValue[0])/2 + randomValue[0];
                if (randomValue[2] > sumFitness) randomValue[2] = randomValue[2] - sumFitness;
                if (randomValue[3] > sumFitness) randomValue[3] = randomValue[3] - sumFitness;
            }else{
                randomValue[1] = 3*sumFitness/4;
                randomValue[2] = sumFitness;
                randomValue[3] = sumFitness/4;
            }

            double rangeMin = 0;
            double rangeMax = 0;

            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < tourController.getTours().size(); k++) {
                    rangeMax = rangeMax + tourController.getTours().get(k).getFitness();
                    if(rangeMin < randomValue[j] &&
                            randomValue[j] < rangeMax){
                        selectedTour = tourController.getTours().get(k);
                    }
                    rangeMin = rangeMin + tourController.getTours().get(k).getFitness();
                }
                matingPool[i*4+j] = selectedTour;
            }
        }

        return matingPool;
    }

    public void tournamentSelection(){

    }

    public void truncationSelection(){

    }

    public Tour[] getMatingPool() {
        return matingPool;
    }
}
