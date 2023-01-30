package exception;

public class MixNotationException extends Exception{
    @Override
    public String getMessage() {
        return "используются одновременно разные системы счисления";
    }
}
