package utils.operations;

import exception.*;
import utils.notation.AbstractNotationOperand;
import utils.notation.DecimalNotationOperand;
import utils.notation.LatinNotationOperand;
import utils.notation.OperandsList;

import java.util.Queue;

public abstract class AbstractOperation {

    public static final String ADDITION = "+";
    public static final String DIVISION = "/";
    public static final String MULTIPLICATION = "*";
    public static final String SUBTRACTION = "-";

    private final int operandsCount = 2;

    public int getOperandsCount() {
        return operandsCount;
    }

    public AbstractNotationOperand calc(OperandsList operands) throws IncorrectMathFormatException, MixNotationException, UndefinedOperationException, MathException, IncorrectLatinNotationValueException {
        if(operands.isEmpty() || operands.size() > this.getOperandsCount()){
            throw new IncorrectMathFormatException();
        }

        if(operands.isDecimalOperandsList()){
            return calcDecimal(operands.getDecimalOperands());
        }

        if(operands.isLatinOperandsList()){
            return calcLatin(operands.getLatinOperands());
        }

        throw new MixNotationException();
    }

    protected abstract DecimalNotationOperand calcDecimal(Queue<DecimalNotationOperand> operands) throws MathException, UndefinedOperationException;
    protected abstract LatinNotationOperand calcLatin(Queue<LatinNotationOperand> operands) throws UndefinedOperationException, MathException, IncorrectLatinNotationValueException;

}
