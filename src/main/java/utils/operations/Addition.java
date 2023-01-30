package utils.operations;

import exception.IncorrectLatinNotationValueException;
import utils.notation.AbstractNotationOperand;
import utils.notation.DecimalNotationOperand;
import utils.notation.LatinNotationOperand;

import java.util.Queue;

public class Addition extends AbstractOperation {

    private final String operator = AbstractOperation.ADDITION;

    @Override
    protected DecimalNotationOperand calcDecimal(Queue<DecimalNotationOperand> operands){
        return new DecimalNotationOperand(operands.stream()
                .map(AbstractNotationOperand::getValue)
                .mapToInt(Integer::intValue)
                .sum());
    }

    @Override
    protected LatinNotationOperand calcLatin(Queue<LatinNotationOperand> operands) throws IncorrectLatinNotationValueException {
        return new LatinNotationOperand(operands.stream()
                .map(AbstractNotationOperand::getValue)
                .mapToInt(Integer::intValue)
                .sum());
    }

}
