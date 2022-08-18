package Calculator;



public final class Operations {

    public  String sum(String strOne, String strTwo) {
        return strOne + strTwo;
    }

    public String subtraction(String strOne, String strTwo) {
        return strOne.replaceAll(strTwo, "");
    }

    public String multiplication(String strOne, String strTwo) {
        int multiply = Integer.parseInt(strTwo);
        return String.valueOf(strOne).repeat(Math.max(0, multiply));

    }

    public String split(String strOne, String strTwo) {
        int x = strOne.length()/Integer.parseInt(strTwo);
        return strOne.substring(0, x);
    }



}



