package exception;

public class IncorrectLatinNotationValueException extends Exception{
    @Override
    public String getMessage() {
        return "некорректное число в римской системе";
    }
}
