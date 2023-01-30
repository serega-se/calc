import exception.IncorrectLatinNotationValueException;
import exception.IncorrectMathFormatException;
import exception.MixNotationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import service.CalculatorService;

class CalculateServiceTest {

    @InjectMocks
    private CalculatorService calculatorService = new CalculatorService();

    @Test
    @DisplayName("DecimalAddition 1 + 2")
    void testDecimalAddition() throws Exception {
        String result = calculatorService.calc("1 + 2");
        Assertions.assertEquals("3", result);
    }

    @Test
    @DisplayName("DecimalDivision 1 / 1")
    void testDecimalDivision() throws Exception {
        String result = calculatorService.calc("6 / 3");
        Assertions.assertEquals("2", result);
    }

    @Test
    @DisplayName("DecimalMultiplicationn 1 * 1")
    void testDecimalMultiplication() throws Exception {
        String result = calculatorService.calc("1 * 1");
        Assertions.assertEquals("1", result);
    }

    @Test
    @DisplayName("DecimalSubtraction 1 - 1")
    void testDecimalSubtraction() throws Exception {
        String result = calculatorService.calc("1 - 1");
        Assertions.assertEquals("0", result);
    }

    @Test
    @DisplayName("LatinDivision VI / III")
    void testLatinDivision() throws Exception {
        String result = calculatorService.calc("VI / III");
        Assertions.assertEquals("II",result);
    }

    @Test
    @DisplayName("LatinSubtraction I - II")
    void testLatinSubtraction() throws Exception {
        Assertions.assertThrows(IncorrectLatinNotationValueException.class, () -> {
            String result = calculatorService.calc("I - II");
        });
    }

    @Test
    @DisplayName("MixNotation I + 1")
    void testMixNotation() throws Exception {
        Assertions.assertThrows(MixNotationException.class, () -> {
            String result = calculatorService.calc("I + 1");
        });
    }

    @Test
    @DisplayName("IncorrectMathFormat 1 + 2 + 3")
    void testIncorrectMathFormat() throws Exception {
        Assertions.assertThrows(IncorrectMathFormatException.class, () -> {
            String result = calculatorService.calc("1 + 2 + 3");
        });
    }
}
