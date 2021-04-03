package com.rainowy;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static int currentTour = 0;
    private static int firstUserPoints = 0;
    private static int secondUserPoints = 0;


//    private static int diceNumber = getRandomNumber(1, 7) + getRandomNumber(1, 7);

    public static void main(String[] args) {
        // write your code here

        int min = 1;
        int max = 7;
        int nrOfTours = 5;
//        int currentTour = 0;

//        System.out.println("hello");
//        System.out.println(getRandomNumber(1, 7));
//        System.out.println(hey);

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            list.add(getRandomNumber(1, 7) + getRandomNumber(1, 7));

        }
//        list.stream()
//                .forEach(System.out::println);

        while (currentTour < nrOfTours -1) {

            for (int i = 1; i <= nrOfTours; i++) {
                currentTour =i;
                System.out.println("TURA NR. " + currentTour);
                firstUserRound();
                secondUserRound();
            }
        }
        System.out.println("Gracz pierwszy: liczba punktów " + firstUserPoints);
        System.out.println("Gracz drugi: liczba punktów " + secondUserPoints);


    }

    public static void firstUserRound(){

        String firstUser = "Gracz pierwszy ";

        int nrOfThrows = 10;
        int currentThrow = 0;
//        boolean finishRound = false;

        while(currentThrow < nrOfThrows -1){

            for (int i = 1; i <= nrOfThrows ; i++) {
                currentThrow = i;
                if(currentThrow ==1) System.out.println("RZUCA PIERWSZY GRACZ");
                System.out.print("Rzut numer " + currentThrow + ": ");
                int diceNumber = getRandomNumber(1, 7) + getRandomNumber(1, 7);
//                System.out.println(currentThrow);
                if(currentThrow == 1 && (diceNumber == 7 || diceNumber == 11 )) {
                    System.out.println(firstUser + "zdobywa " + diceNumber + " punktów w pierwszym rzucie i wygrywa turę.");
                    return;
                }
                else if(currentThrow ==1 && (diceNumber == 2 || diceNumber == 12 )) {
                    System.out.println(firstUser + "zdobywa " + diceNumber + " punktów w pierwszym rzucie i przegrywa turę.");
                    firstUserPoints += 120;
                    return;
                }
                else if(diceNumber == 5){
                    System.out.println(firstUser + "zdobywa " + diceNumber + " punktów i wygrywa turę przed czasem.");
                    return;
                }
                else {
                    System.out.println(firstUser + "zdobywa " + diceNumber + " punktów i rzuca ponownie");
                    firstUserPoints += diceNumber/currentThrow;
                }
            }
        }
    }

    public static void secondUserRound(){

        String secondUser = "Gracz drugi";

        int nrOfThrows = 10;
        int currentThrow = 0;
//        boolean finishRound = false;

        while(currentThrow < nrOfThrows -1){

            for (int i = 1; i <= nrOfThrows ; i++) {
                currentThrow = i;
                if(currentThrow ==1) System.out.println("RZUCA DRUGI GRACZ");
                System.out.print("Rzut numer " + currentThrow + ": ");
                int diceNumber = getRandomNumber(1, 7) + getRandomNumber(1, 7);
//                System.out.println(currentThrow);
                if(currentThrow == 1 && (diceNumber == 7 || diceNumber == 11 )) {
                    System.out.println(secondUser + "zdobywa " + diceNumber + " punktów w pierwszym rzucie i wygrywa turę.");
                    return;
                }
                else if(currentThrow ==1 && (diceNumber == 2 || diceNumber == 12 )) {
                    System.out.println(secondUser + "zdobywa " + diceNumber + " punktów w pierwszym rzucie i przegrywa turę.");
                    secondUserPoints += 120;
                    return;
                }
                else if(diceNumber == 5){
                    System.out.println(secondUser + "zdobywa " + diceNumber + " punktów i wygrywa turę przed czasem.");
                    return;
                }
                else {
                    System.out.println(secondUser + "zdobywa " + diceNumber + " punktów i rzuca ponownie");
                    secondUserPoints += diceNumber/currentThrow;
                }
            }
        }
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
