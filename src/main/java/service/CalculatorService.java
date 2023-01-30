package service;

import exception.*;
import utils.notation.AbstractNotationOperand;
import utils.notation.OperandsList;
import utils.operations.*;

public class CalculatorService implements CalculatorServiceInterface {

    public String calc(String arg) throws IncorrectMathFormatException, UndefinedOperationException, MathException, IncorrectLatinNotationValueException, MixNotationException {

        AbstractNotationOperand result = null;

        String[] operandsArray = getOperandsArray(arg);

        if(operandsArray.length > 3 || operandsArray.length < 1){
            throw new IncorrectMathFormatException();
        }

        AbstractOperation operation = new UndefinedOperation();
        OperandsList operands = new OperandsList();
        for (String operand: operandsArray) {

            if(getOperator(operand) instanceof UndefinedOperation){
                operands.add(operand);
            }else{
                operation = getOperator(operand);
            }

            if(operands.size() >= operation.getOperandsCount()){
                    result = operation.calc(operands);

                operands.clear();
            }
        }
        return result!=null?result.toString():"";
    }

    private String[] getOperandsArray(String arg){
        return arg.split("\\s");
    }

    private AbstractOperation getOperator(String arg){
        return switch (arg) {
            case AbstractOperation.ADDITION -> new Addition();
            case AbstractOperation.DIVISION -> new Division();
            case AbstractOperation.MULTIPLICATION -> new Multiplication();
            case AbstractOperation.SUBTRACTION -> new Subtraction();
            default -> new UndefinedOperation();
        };
    }
}
