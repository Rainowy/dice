package src.com.rainowy;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        String Ean = "07567817239711";
        Calendar calendar = new Calendar();
        FizzBuzz fizzBuzz = new FizzBuzz();
        Ean ean = new Ean();

        ean.validateEan(Ean);
        fizzBuzz.buzz();
        calendar.checkDate();
        Dice.initRound();



//        Zadanie 5
//        SELECT COUNT(*) + 1 FROM ExportBatch;
    }
}
