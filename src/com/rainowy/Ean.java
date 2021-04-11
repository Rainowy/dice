package src.com.rainowy;

import java.util.stream.IntStream;

public class Ean {

    public void validateEan(String ean) {

        String validatedEan = validateInput(ean);
        String[] digits = validatedEan.split("");
        int sum = IntStream
                .range(0, digits.length - 1)
                .map(d -> Integer.parseInt(digits[d]) * ((d % 2 == 0) ? 1 : 3))
                .sum();

        int checksumDigit = (10 - (sum % 10)) % 10;
        boolean result = Integer.parseInt(digits[digits.length - 1]) == checksumDigit;
        System.out.println(result ? validatedEan + " - EAN prawidłowy " : validatedEan + " - EAN nieprawidłowy ");
    }

    private String validateInput(String ean) {

        if (!ean.isEmpty()) {
            ean = ean.replaceAll("[^\\d.]", "");

            int eanLength = ean.length();
            String zeroLeadingEan = "0" + ean;

            return switch (eanLength) {
                case 8, 13 -> ean;
                case 7, 12 -> zeroLeadingEan;
                case 9, 14 -> zeroLeadingEan.substring(0, zeroLeadingEan.length() - 2);
                case 10, 15 -> ean.substring(0, eanLength - 2);
                default -> throw new IllegalArgumentException("Unexpected value: " + ean);
            };
        } else throw new IllegalArgumentException("Ean is empty!");
    }
}
