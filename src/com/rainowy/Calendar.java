package src.com.rainowy;
import java.util.Scanner;

public class Calendar {

    private boolean validYear = false;
    private boolean validMonth = true;
    private boolean validDay = false;
    private int nrOfDays;

    public void checkDate() {

        Scanner scan = new Scanner(System.in);
        System.out.println("Wprowadź rok w zakresie 2001 - 2099");
        validateInput(scan);
        int year = scan.nextInt();
        System.out.println("Wprowadź poprawny miesiąc 1 - 12");
        validateInput(scan);
        int month = scan.nextInt();
        System.out.println("Wprowadź dzień");
        validateInput(scan);
        int day = scan.nextInt();

        valiDate(year, month, day);

        if (validYear && validMonth && validDay) {
            System.out.printf("Wprowadzona data: %s.%s.%s ", year, month, day);
        }
        if (!validYear) {
            System.out.println("Nieprawidłowy rok");
            return;
        }
        if (!validMonth) {
            System.out.println("Nieprawidłowy miesiąc");
            return;
        }
        if (!validDay) System.out.println("Nieprawidłowy dzień");
    }

    private void valiDate(int year, int month, int day) {
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> nrOfDays = 31;
            case 4, 6, 9, 11 -> nrOfDays = 30;
            case 2 -> nrOfDays = februaryDays(year);
            default -> validMonth = false;
        }
        validYear = year >= 2001 && year <= 2099 ? true : false;
        validDay = day >= 1 && day <= nrOfDays ? true : false;
    }

    private void validateInput(Scanner scan) {
        while (!scan.hasNextInt()) {
            System.out.println("Wprowadź cyfrę");
            scan.next();
        }
    }

    private int februaryDays(int year) {
        boolean leapYear = year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
        if (!leapYear) {
            return 28;
        }
        return 29;
    }
}
