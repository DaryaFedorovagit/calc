import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Пример: ");
        String prim = scanner.nextLine();
        System.out.println("Ответ: " + calc(prim));
    }

    public static String calc(String prim) {
        String res = "";
        String[] pr = prim.split(" ");
        if (pr.length != 3) {
            try {
                throw new IOException();
            } catch (IOException i) {
                System.out.println("т.к. формат математической операции не удовлетворяет заданию " +
                        "- два операнда и один оператор (+, -, /, *)");
                System.exit(1);
            }
        }
        if (isArabikNumber(pr[0]) && isRomanNumber(pr[2]) || (isRomanNumber(pr[0]) && isArabikNumber(pr[2]))) {
            try {
                throw new IOException();
            } catch (IOException i) {
                System.out.println("т.к. используются одновременно разные системы счисления");
                System.exit(1);
            }
        }
        if (isRomanNumber(pr[0]) && isRomanNumber(pr[2])) {
            int result = 0;
            int index1 = converter(pr[0]);
            int index2 = converter(pr[2]);
            if (index1 > 10 | index1 < 0 | index2 < 0 | index2 > 10) {
                try {
                    throw new IOException();
                } catch (IOException i) {
                    System.out.println("т.к. не удовлетворяет условиям задачи");
                    System.exit(1);
                }
            }
            if (prim.contains("+")) {
                result = index1 + index2;
            } else if (prim.contains("-")) {
                result = index1 - index2;
            } else if (prim.contains("*")) {
                result = index1 * index2;
            } else if (prim.contains("/")) {
                result = index1 / index2;
            }
            if (result <= 0) {
                try {
                    throw new IOException();
                } catch (IOException i) {
                    System.out.println("т.к. в римской системе нет отрицательных чисел");
                    System.exit(1);
                }
            } else res = converter2(result);
        } else {
            int x = Integer.parseInt(pr[0]);
            int y = Integer.parseInt(pr[2]);
            int result;
            if (x > 10 | x < 0 | y < 0 | y > 10) {
                try {
                    throw new IOException();
                } catch (IOException i) {
                    System.out.println("т.к. не удовлетворяет условиям задачи");
                    System.exit(1);
                }
            }
            if (prim.contains("+")) {
                result = x + y;
                res = Integer.toString(result);
            } else if (prim.contains("-")) {
                result = x - y;
                res = Integer.toString(result);
            } else if (prim.contains("*")) {
                result = x * y;
                res = Integer.toString(result);
            } else if (prim.contains("/")) {
                result = x / y;
                res = Integer.toString(result);
            }

        }
        return res;
    }


    public static boolean isRomanNumber(String prim) {
        return prim.matches("[IVXLCDM]+");
    }
    public static boolean isArabikNumber(String prim) {
        return prim.matches("[1234567890]+");
    }
    static String[] rim = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII",
            "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI",
            "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII",
            "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII",
            "LXXXVIII", "LXXXIX", "XCXCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C", "CI" };

    public static int converter(String s) {
        for (int i = 0; i < rim.length; i++) {
            if (s.equals(rim[i])) {
                return i;
            }
        }
        return -1;
    }
    public static String converter2(int result) {
        return rim[result];
    }
}
