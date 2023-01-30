package exception;

public class MathException extends Exception{
    @Override
    public String getMessage() {
        return "некорректная математическая операция";
    }
}
