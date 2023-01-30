package utils.notation;

import exception.IncorrectLatinNotationValueException;

import java.util.HashMap;
import java.util.Map;

public class LatinNotationOperand extends AbstractNotationOperand {

    public LatinNotationOperand(String operand) throws IncorrectLatinNotationValueException {
        if(!checkLatinFormat(operand)){
            throw new IncorrectLatinNotationValueException();
        }
        this.value = convertLatinToInt(operand);
    }

    public LatinNotationOperand(Integer operand) throws IncorrectLatinNotationValueException {
        if(operand < 0) {
            throw new IncorrectLatinNotationValueException();
        }

        this.value = operand;
    }

    private static boolean checkLatinFormat(String input) {
        return input.matches("^[M|C|X|I|V|L|D]{0,9}$");
    }

    @Override
    public String toString() {
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] units = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return thousands[value / 1000] + hundreds[(value % 1000) / 100] + tens[(value % 100) / 10] + units[value % 10];
    }

    private static int convertLatinToInt(String s)
    {
        Map<Character, Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        s = s.replace("IV","IIII");
        s = s.replace("IX","VIIII");
        s = s.replace("XL","XXXX");
        s = s.replace("XC","LXXXX");
        s = s.replace("CD","CCCC");
        s = s.replace("CM","DCCCC");
        int number = 0;

        for (int i = 0; i < s.length(); i++)
        {
            number = number + (map.get(s.charAt(i)));
        }
        return number;
    }
}
