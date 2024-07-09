import java.util.Scanner;

public class class11project2 {

       public static String addBinary(String a, String b) {
        String[] partsA = a.split("\\.");
        String[] partsB = b.split("\\.");

        String integerPartA = partsA[0];
        String integerPartB = partsB[0];

        String fractionalPartA = partsA.length > 1 ? partsA[1] : "";
        String fractionalPartB = partsB.length > 1 ? partsB[1] : "";

        // Pad the fractional parts with trailing zeros to make them the same length
        while (fractionalPartA.length() < fractionalPartB.length())
            fractionalPartA += "0";
        while (fractionalPartB.length() < fractionalPartA.length())
            fractionalPartB += "0";

        a = integerPartA + fractionalPartA;
        b = integerPartB + fractionalPartB;

        int s = 0; // Initialize result
        String result = ""; // Initialize result

        // Traverse both strings starting from last characters
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || s == 1) {
            // Compute sum of last digits and carry
            s += ((i >= 0) ? a.charAt(i) - '0' : 0);
            s += ((j >= 0) ? b.charAt(j) - '0' : 0);

            // If current digit sum is 1 or 3, add 1 to result
            result = (char) (s % 2 + '0') + result;

            // Compute carry
            s /= 2;

            // Move to next digits
            i--;
            j--;
        }
        if (fractionalPartA!="")

        result = result.substring(0, result.length() - fractionalPartB.length()) + "."
                + result.substring(result.length() - fractionalPartB.length());

        return result;
    }

    // Method to perform binary subtraction
    public static String subtractBinary(String a, String b) {
        String[] partsA = a.split("\\.");
        String[] partsB = b.split("\\.");

        String integerPartA = partsA[0];
        String integerPartB = partsB[0];

        String fractionalPartA = partsA.length > 1 ? partsA[1] : "";
        String fractionalPartB = partsB.length > 1 ? partsB[1] : "";

        // Pad the fractional parts with trailing zeros to make them the same length
        while (fractionalPartA.length() < fractionalPartB.length())
            fractionalPartA += "0";
        while (fractionalPartB.length() < fractionalPartA.length())
            fractionalPartB += "0";

        a = integerPartA + fractionalPartA;
        b = integerPartB + fractionalPartB;

        int borrow = 0; // Initialize borrow
        String result = ""; // Initialize result

        // Traverse both strings starting from last characters
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0) {
            // Subtract the borrow from the current digit
            int sub = ((a.charAt(i) - '0') - (j >= 0 ? b.charAt(j) - '0' : 0) - borrow);
            if (sub < 0) {
                // If the subtracted value is negative, add 2 to it and consider it as borrow
                sub = sub + 2;
                borrow = 1;
            } else {
                borrow = 0;
            }

            // Concatenate the result
            result = sub + result;

            // Move to next digits
            i--;
            j--;
        }
        if (fractionalPartA!="")
        result = result.substring(0, result.length() - fractionalPartB.length()) + "."
                + result.substring(result.length() - fractionalPartB.length());

        return result;
    }

    // Method to perform binary multiplication
    public static String multiplyBinary(String a, String b) {
        String integerResult = Double.toString(Double.parseDouble(a) * Double.parseDouble(b));

        return integerResult;
    }

  
public static String divideBinary(String dividend, String divisor) {
    int dividendPoint = dividend.indexOf(".");
    int divisorPoint = divisor.indexOf(".");

    // If there's no decimal point, treat it as if it's at the end of the string
    dividendPoint = (dividendPoint != -1) ? dividendPoint : dividend.length();
    divisorPoint = (divisorPoint != -1) ? divisorPoint : divisor.length();

    // Remove decimal point from dividend and divisor
    dividend = dividend.replace(".", "");
    divisor = divisor.replace(".", "");

    // Calculate the position of the decimal point in the result
    int point = (dividend.length() - dividendPoint) - (divisor.length() - divisorPoint);

    // Perform long division
    String quotient = "";
    String remainder = "";

    for (int i = 0; i < dividend.length(); i++) {
        remainder += dividend.charAt(i);
        if (remainder.length() < divisor.length() || (remainder.length() == divisor.length() && remainder.compareTo(divisor) < 0)|| remainder.equals("00.0")||Double.parseDouble(remainder)<Double.parseDouble(divisor)) {
            quotient += "0";
        } else {
            quotient += "1";
            remainder = subtractBinary(remainder, divisor);
        }
    }

    // Insert the decimal point at the correct position
    if (point > 0) {
        quotient = quotient.substring(0, quotient.length() - point) + "." + quotient.substring(quotient.length() - point);
    } else {
        for (int i = 0; i < Math.abs(point); i++) {
            quotient = quotient + "0";
        }
        if (quotient.charAt(0) != '0') {
            quotient = "0." + quotient;
        }
    }

    // Remove trailing zeros
    /*while (quotient.contains(".") && quotient.charAt(quotient.length() - 1) == '0') {
        quotient = quotient.substring(0, quotient.length() - 1);
    }*/

    // Remove unnecessary leading zeros
    while (quotient.length() > 1 && quotient.charAt(0) == '0' && quotient.charAt(1) != '.') {
        quotient = quotient.substring(1);}
    

    return quotient;
}


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please choose an operation: ");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");

        int operation = scanner.nextInt();

        System.out.println("Please enter the first binary number: ");
        String a = scanner.next();

        System.out.println("Please enter the second binary number: ");
        String b = scanner.next();

        String result = "";
        switch (operation) {
            case 1:
                result = addBinary(a, b);
                break;
            case 2:
                result = subtractBinary(a, b);
                break;
            case 3:
                result = multiplyBinary(a, b);
                break;
            case 4:
                result = divideBinary(a, b);
                break;
            default:
                System.out.println("Invalid operation");
                return;
        }

        System.out.println("The result is: " + result);
    }
}