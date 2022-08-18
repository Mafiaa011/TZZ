package Calculator;
import java.util.List;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;
import static java.util.Arrays.asList;
public class ExpressionParser {
    private static final List<String> OPERATIONS = asList("+", "-", "*", "/");
    public String[] parse(String str) {
        String[] result = new String[3];
        String strOne = "";
        String operator = "";
        String strTwo = "";
        int markCount = 0;
        String[] strArray = str.split("");
        for (int i = 0; i < strArray.length; i++) {
            String current = strArray[i];
            if (current.equals("\"")) markCount++;
            if (markCount == 1) strOne += current;
            if (OPERATIONS.contains(current)) operator += current;
            if (markCount >= 3) strTwo += current;
        }
        boolean isNumber = isNumber(str);
        String[] arr = str.split(" ");
        String number = valueOf(arr[arr.length - 1]);
        result[0] = clear(strOne);
        result[1] = clear(operator);
        result[2] = isNumber ? number : clear(strTwo);
        return result;
    }
    private String clear(String str) {
        if (str.length() > 10) throw new RuntimeException("pizdec");
        return str.trim().replaceAll("\"", "");
    }
    private boolean isNumber(String str) {
        try {
            String[] arr = str.split(" ");
            int number = parseInt(arr[arr.length - 1]);
            if (number > 10) throw new RuntimeException("");
            return true;
        } catch (NumberFormatException th) {
            return false;
        }
    }
}