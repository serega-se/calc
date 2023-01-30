package utils.operations;

import exception.UndefinedOperationException;
import utils.notation.DecimalNotationOperand;
import utils.notation.LatinNotationOperand;

import java.util.Queue;

public class UndefinedOperation extends AbstractOperation{

    private final int operandsCount = Integer.MAX_VALUE;

    @Override
    protected DecimalNotationOperand calcDecimal(Queue<DecimalNotationOperand> operands) throws UndefinedOperationException {
        throw new UndefinedOperationException();
    }

    @Override
    protected LatinNotationOperand calcLatin(Queue<LatinNotationOperand> operands) throws UndefinedOperationException {
        throw new UndefinedOperationException();
    }
}
