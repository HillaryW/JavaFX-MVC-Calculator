package Model;

public class CalculatorModel {
    
    public long calculateTwoNumbers(long num1, long num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0)
                    return 0;

                return num1 / num2;
        }

        System.out.println("Unknown operator - " + operator);
        return 0;
    }
}
