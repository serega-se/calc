package exception;

public class UndefinedOperandException extends Exception{
    @Override
    public String getMessage() {
        return "неизвестный операнд";
    }
}
