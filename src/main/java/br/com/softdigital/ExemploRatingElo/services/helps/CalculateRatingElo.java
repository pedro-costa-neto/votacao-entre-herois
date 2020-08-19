package br.com.softdigital.ExemploRatingElo.services.helps;

public class CalculateRatingElo {
    private int k = 0;
    private Double newRatingA;
    private Double newRatingB;

    public CalculateRatingElo(int k, Double ratingA, Double ratingB, int scoreA, int scoreB) {
        this.k = k;

        Double newScoreA = validateScore(scoreA, scoreB);
        Double newScoreB = validateScore(scoreB, scoreA);
        
        Double expectedScoreA = calculateExpectedScore(ratingB, ratingA);
        newRatingA = calculateNewRating(ratingA, newScoreA, expectedScoreA);

        Double expectedScoreB = calculateExpectedScore(ratingA, ratingB);
        newRatingB = calculateNewRating(ratingB, newScoreB, expectedScoreB);
    }

    private Double calculateExpectedScore(Double valueOne, Double valueTwo) {
        return 1/(1 + Math.pow(10.00, ((valueOne - valueTwo)/400)));
    }

    private Double calculateNewRating(Double rating, Double score, Double expectedScore) {
        return rating + k * (score - expectedScore);
    }

    private Double validateScore(int valueOne, int valueTwo) {
        if(valueOne > valueTwo) {
            return 1.0;
        } 
        else if(valueOne < valueTwo) {
            return 0.0;
        } 
        else {
            return 0.5;
        }
    }

    public Double getRatingA() {
        return newRatingA;
    }

    public Double getRatingB() {
        return newRatingB;
    }
}