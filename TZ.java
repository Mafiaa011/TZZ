package Calculator;

import java.util.Scanner;

import static java.lang.System.out;

public class TZ {
    private static final Scanner SCANNER = new Scanner(System.in);
    static final Operations OPERATIONS = new Operations();
    private static final ExpressionParser PARSER = new ExpressionParser();

    public static void main(String[] args) throws Exception {
        while (true) {
            out.println("Vvedite virazenie[\"a\" + \"b\", \"a\" - \"b\", \"a\" * x, \"a\" / x]");
            String myInput = SCANNER.nextLine();

//            try {
                String[] expression = PARSER.parse(myInput);
                String result = calculate(expression[0], expression[2], expression[1]);
                out.println("\"" + valide(result) + "\"");
//            } catch (Exception th) {
//                out.println("No valid");
//            }
        }
    }

    private static String valide(String str) {
        if (str.length() > 40) {
            return str.substring(0, 40) + "...";
        }
        return str;
    }

    public static String calculate(String letter1, String letter2, String operations) {
        switch (operations) {
            case "+":
                return OPERATIONS.sum(letter1, letter2);
            case "-":
                return OPERATIONS.subtraction(letter1, letter2);
            case "*":
                return OPERATIONS.multiplication(letter1, letter2);
            case "/":
                return OPERATIONS.split(letter1, letter2);
            default:
                throw new RuntimeException("Neverniy znak operacii");
        }
    }
}