package exception;

public class UndefinedOperationException extends Exception{
    @Override
    public String getMessage() {
        return "неизвестная операция";
    }
}
