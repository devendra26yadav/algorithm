package RedixSort;

public class BaseConverter {

    // Convert a decimal number to a string in the given base
    public static String convertToBase(int num, int base) {
        if (base < 2 || base > 36) {
            throw new IllegalArgumentException("Base must be between 2 and 36");
        }

        if (num == 0) {
            return "0";
        }

        String digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        boolean negative = num < 0;
        num = Math.abs(num);

        StringBuilder result = new StringBuilder();

        while (num > 0) {
            int remainder = num % base;
            result.insert(0, digits.charAt(remainder));
            num /= base;
        }

        if (negative) {
            result.insert(0, '-');
        }

        return result.toString();
    }

    // Example usage
    public static void main(String[] args) {
        int number = 255;

        System.out.println("Binary: " + convertToBase(number, 2));
        System.out.println("Octal: " + convertToBase(number, 8));
        System.out.println("Hexadecimal: " + convertToBase(number, 16));
        System.out.println("Base-36: " + convertToBase(number, 36));
        System.out.println(convertToBase(115,7));
        int[] arr={48,1,6,23,37,19,21};
        for (int j : arr) {
            System.out.println(j+" -> "+convertToBase(j, 7));
        }
    }
}
