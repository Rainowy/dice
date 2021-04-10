package src.com.rainowy;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {

//        Dice.initRound();

        Ean instance = new Ean();
        String Ean = "0075678164125";
        System.out.println(instance.check(Ean) ? "Prawidłowy kod EAN " + Ean : "Nieprawidłowy kod EAN " + Ean);

    }


}
