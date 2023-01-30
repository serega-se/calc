package utils.notation;

public abstract class AbstractNotationOperand {

    int value;

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public int getValue() {
        return value;
    }
}
