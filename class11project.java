import java.util.Scanner;

public class class11project {
    private static final char[] digits = "0123456789ABCDEF".toCharArray();

    public static String convertBase(String num, int baseFrom, int baseTo) {
        String integerPart = num.split("\\.")[0];
        String fractionalPart = num.contains(".") ? num.split("\\.")[1] : "";

        long integerResult = convertIntegerPart(integerPart, baseFrom);
        String integerResultInBaseTo = convertToBase(integerResult, baseTo);

        String fractionalResultInBaseTo = "";
        if (!fractionalPart.isEmpty()) {
            double fractionalResult = convertFractionalPart(fractionalPart, baseFrom);
            fractionalResultInBaseTo = convertFractionToBase(fractionalResult, baseTo);
        }

        return fractionalPart.isEmpty() ? integerResultInBaseTo : integerResultInBaseTo + "." + fractionalResultInBaseTo;
    }

    private static long convertIntegerPart(String num, int baseFrom) {
        long result = 0;
        for (int i = 0; i < num.length(); i++) {
            result = result * baseFrom + Character.digit(num.charAt(i), baseFrom);
        }
        return result;
    }

    private static double convertFractionalPart(String num, int baseFrom) {
        double result = 0.0;
        for (int i = 0; i < num.length(); i++) {
            result += Character.digit(num.charAt(i), baseFrom) / Math.pow(baseFrom, i + 1);
        }
        return result;
    }

    private static String convertToBase(long num, int baseTo) {
        String result = "";
        while (num != 0) {
            result = digits[(int) (num % baseTo)] + result;
            num /= baseTo;
        }
        return result;
    }

    private static String convertFractionToBase(double num, int baseTo) {
        String result = "";
        while (num > 0) {
            double temp = num * baseTo;
            result += digits[(int) temp];
            num = temp - (int) temp;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number:");
        String num = scanner.nextLine();
        System.out.println("Enter the base of the number (2, 8, 10, 16):");
        int baseFrom = scanner.nextInt();
        System.out.println("Enter the base to convert to (2, 8, 10, 16):");
        int baseTo = scanner.nextInt();
        System.out.println("Converted number: " + convertBase(num, baseFrom, baseTo));
    }
}