package utils.notation;

import exception.IncorrectLatinNotationValueException;
import org.apache.commons.lang3.StringUtils;

import java.util.LinkedList;
import java.util.Queue;

public class OperandsList {
    Queue<DecimalNotationOperand> decimalOperands = new LinkedList<>();
    Queue<LatinNotationOperand> latinOperands = new LinkedList<>();


    public void add(String arg) throws IncorrectLatinNotationValueException {
        if(StringUtils.isNumeric(arg)){
            decimalOperands.add(new DecimalNotationOperand(arg));
        }else{
            latinOperands.add(new LatinNotationOperand(arg));
        }
    }

    public void clear(){
        decimalOperands.clear();
        latinOperands.clear();
    }

    public int size(){
        return decimalOperands.size() + latinOperands.size();
    }

    public boolean isDecimalOperandsList(){
        return !decimalOperands.isEmpty() && latinOperands.isEmpty();
    }

    public boolean isLatinOperandsList(){
        return decimalOperands.isEmpty() && !latinOperands.isEmpty();
    }

    public Queue<DecimalNotationOperand> getDecimalOperands() {
        return decimalOperands;
    }

    public Queue<LatinNotationOperand> getLatinOperands() {
        return latinOperands;
    }

    public boolean isEmpty(){
        return decimalOperands.isEmpty() && latinOperands.isEmpty();
    }
}
