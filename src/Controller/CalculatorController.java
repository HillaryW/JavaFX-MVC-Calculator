package Controller;

import Model.CalculatorModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class CalculatorController {

    @FXML
    private Text output;

    @FXML
    private Text progress;

    private long num1 = 0;
    private String operator = "";
    private boolean start = true;

    private CalculatorModel model = new CalculatorModel();

    @FXML
    private void handleNumbers(ActionEvent event) {
        if (start) {
            output.setText("");
            start = false;
        }

        String value = ((Button)event.getSource()).getText();
        output.setText(output.getText() + value);
    }

    @FXML
    private void handleOperator(ActionEvent event) {
        String value = ((Button)event.getSource()).getText();

        if (!"=".equals(value)) {
            progress.setText("");
            if (!operator.isEmpty())
                return;
            operator = value;
            num1 = Long.parseLong(output.getText());
            progress.setText("" + num1);
            output.setText("");
        }
        else {
            progress.setText("");
            if (operator.isEmpty())
                return;

            output.setText(String.valueOf(model.calculateTwoNumbers(num1, Long.parseLong(output.getText()), operator)));
            operator = "";
            start = true;
        }
    }

}
