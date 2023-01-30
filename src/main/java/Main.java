import service.CalculatorService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputString = new Scanner(System.in);
        CalculatorService calculator = new CalculatorService();

        System.out.println("Operation:");
        do {
            try {
                if (inputString.hasNextLine()) {
                    System.out.println(calculator.calc(inputString.nextLine()));
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (inputString.hasNext());
    }
}
