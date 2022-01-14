package controller;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;

import java.math.*;

public class controller {
	String currencies[] = { "RON", "EUR", "USD", "GBP", "CND", "AUD"};
	double convertRon[] = {1, 4.95, 4.37, 5.81, 3.44, 3.14};
	
	@FXML
	private ComboBox<String> combo_1, combo_2;
	
    @FXML
    private Button button;
    @FXML
    private TextField textfield;
    @FXML
    private Label text;
    
    @FXML
    public void buttonPressed(ActionEvent event){
        try {
        	int choice_1 = 0;
            for(int i = 0; i <= 5 ; i++)
            	if(combo_1.getValue() == currencies[i]) {
            		choice_1 = i;
            		break;
            	}
            
            int choice_2 = 0;
            for(int i = 0; i <= 5 ; i++)
            	if(combo_2.getValue() == currencies[i]) {
            		choice_2 = i;
            		break;
            	}

            double initial_value = Integer.parseInt(textfield.getText());
            double result_value = roundDoubleToTwo(initial_value * convertRon[choice_1] / convertRon[choice_2]);
            
            String str = result_value + " " + currencies[choice_2];
            text.setText(str);
        }
        catch(NumberFormatException e){
            text.setText("No value");
        }
    }
    
    public void initialize() {
		combo_1.getItems().addAll(currencies);
		combo_1.setValue(currencies[0]);
		
		combo_2.getItems().addAll(currencies);
		combo_2.setValue(currencies[1]);
	}
    
    public Double roundDoubleToTwo(Double value) {
        BigDecimal bd = new BigDecimal(value).setScale(2, RoundingMode.HALF_UP);
        double result = bd.doubleValue();
        return result;
    }
}