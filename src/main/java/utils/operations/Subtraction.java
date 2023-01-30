package utils.operations;

import exception.IncorrectLatinNotationValueException;
import exception.MathException;
import utils.notation.AbstractNotationOperand;
import utils.notation.DecimalNotationOperand;
import utils.notation.LatinNotationOperand;

import java.util.Queue;

public class Subtraction extends AbstractOperation {

    private final String operator = AbstractOperation.SUBTRACTION;

    @Override
    protected DecimalNotationOperand calcDecimal(Queue<DecimalNotationOperand> operands) throws MathException {
        return new DecimalNotationOperand(operands.stream()
                .map(AbstractNotationOperand::getValue)
                .mapToInt(Integer::intValue)
                .reduce((a, b) -> a - b).orElseThrow(MathException::new));
    }

    @Override
    protected LatinNotationOperand calcLatin(Queue<LatinNotationOperand> operands) throws IncorrectLatinNotationValueException, MathException {
        return new LatinNotationOperand(operands.stream()
                .map(AbstractNotationOperand::getValue)
                .mapToInt(Integer::intValue)
                .reduce((a, b) -> a - b).orElseThrow(MathException::new));
    }

}
