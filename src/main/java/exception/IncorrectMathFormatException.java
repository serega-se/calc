package exception;

public class IncorrectMathFormatException extends Exception{
    @Override
    public String getMessage() {
        return "формат математической операции не удовлетворяет заданию";
    }
}
