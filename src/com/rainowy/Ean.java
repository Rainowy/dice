package src.com.rainowy;

public class Ean {

    public boolean check(String ean) {
        boolean status;
        int sum = 0;
        String[] digits = isValid(ean).split("");

        for (int i = 0; i < (digits.length - 1); i++) {
            sum += Integer.parseInt(digits[i]) * ((i % 2 == 0) ? 1 : 3);
        }
        int checksumDigit = (10 - (sum % 10)) % 10;

        status = (Integer.parseInt(digits[digits.length - 1]) == checksumDigit);

        return status;
    }

    public String isValid(String ean) {

        if (!ean.isEmpty()) {
            ean = ean.replaceAll("[^\\d.]", "");

            int eanLength = ean.length();
            String eanWithZero = "0" + ean;

            switch (eanLength) {
                case 8, 13 -> ean = ean;
                case 7, 12 -> ean = eanWithZero;
                case 9, 14 -> ean = eanWithZero.substring(0, eanWithZero.length() - 2);
                case 10, 15 -> ean = ean.substring(0, eanLength - 2);
                default -> throw new IllegalArgumentException("Unexpected value: " + ean);
            }
        } else throw new IllegalArgumentException("Ean is empty " + ean);
        return ean;
    }
}
