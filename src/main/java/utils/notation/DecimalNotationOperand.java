package utils.notation;

public class DecimalNotationOperand extends AbstractNotationOperand {

    public DecimalNotationOperand(String operand) {
        this.value = Integer.parseInt(operand);
    }
    public DecimalNotationOperand(Integer operand) {
        this.value = operand;
    }

}
