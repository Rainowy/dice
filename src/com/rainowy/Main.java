package com.rainowy;

import java.util.Locale;

public class Main {

    private static final int min = 1;
    private static final int max = 7;
    private static final int nrOfTours = 5;
    private static final int nrOfThrows = 10;
    private static final User firstUser = new User("Pierwszy gracz", 0);
    private static final User secondUser = new User("Drugi gracz", 0);
    private static final String firstUserWon = "Wygrywa pierwszy gracz";
    private static final String secondUserWon = "Wygrywa drugi gracz";
    private static int currentTour;

    public static void main(String[] args) {

        while (currentTour < nrOfTours - 1) {
            for (int i = 1; i <= nrOfTours; i++) {
                currentTour = i;
                System.out.println("TURA NR. " + currentTour);
                computeRound(firstUser);
                computeRound(secondUser);
            }
        }
        printMessage();
    }

    public static void computeRound(User user) {

        int currentThrow = 0;

        while (currentThrow < nrOfThrows - 1) {
            for (int i = 1; i <= nrOfThrows; i++) {
                currentThrow = i;
                double diceNumber = getRandomNumber(min, max) + getRandomNumber(min, max);
                if (currentThrow == 1) System.out.println("RZUCA " + user.getName().toUpperCase(Locale.ROOT));
                System.out.print("Rzut numer " + currentThrow + ": ");

                if (currentThrow == 1 && (diceNumber == 7 || diceNumber == 11)) {
                    System.out.println(user.getName() + " zdobywa " + diceNumber + " punktów w pierwszym rzucie i wygrywa turę.");
                    user.setPoints(user.getPoints() + diceNumber);
                    return;
                } else if (currentThrow == 1 && (diceNumber == 2 || diceNumber == 12)) {
                    System.out.println(user.getName() + "zdobywa " + diceNumber + " punktów w pierwszym rzucie i przegrywa turę.");
                    user.setPoints(user.getPoints() + 120);
                    return;
                } else if (diceNumber == 5) {
                    System.out.println(user.getName() + " zdobywa " + diceNumber + " punktów i wygrywa turę przed czasem.");
                    user.setPoints(user.getPoints() + diceNumber);
                    return;
                } else {
                    System.out.println(user.getName() + " zdobywa " + diceNumber + " punktów i rzuca ponownie");
                    double pointsToAdd = diceNumber / currentThrow;
                    user.setPoints(user.getPoints() + pointsToAdd);
                }
            }
        }
    }

    private static void printMessage() {
        System.out.printf("Gracz pierwszy: liczba punktów:  %.1f \n", firstUser.getPoints());
        System.out.printf("Gracz drugi: liczba punktów %.1f \n", secondUser.getPoints());
        System.out.println((firstUser.getPoints() > secondUser.getPoints()) ? (firstUserWon) : secondUserWon);
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
