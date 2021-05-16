package at.ac.htlinn.javafx_examples.scenebuilder.ex_01_first;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class FirstController {

	@FXML
	private TextField op2;

	@FXML
	private TextField op1;

	@FXML
	private ListView<String> operator;

	@FXML
	private Label result;

	@FXML
	private Label status;

	@FXML
	public void initialize() {
		ObservableList<String> items = FXCollections.observableArrayList("+", "-", "*", "/");
		operator.setItems(items);
	}

	@FXML
	void calculate(MouseEvent event) {
		double op1D = 0;
		double op2D = 0;
		try {
			op1D = Double.parseDouble(op1.getText());
			op2D = Double.parseDouble(op2.getText());
		} catch (NumberFormatException e) {
			status.setText("please enter valid numbers!!!");
			return;
		}

		String op = operator.getSelectionModel().getSelectedItem();
		double res = 0;
		switch (op) {
		case "+":
			res = op1D + op2D;
			break;
		case "-":
			res = op1D - op2D;
			break;
		case "*":
			res = op1D * op2D;
			break;
		case "/":
			res = op1D / op2D;
			break;
		}

		result.setText(res + "");
		status.setText(String.format("%.2f %s = %.2f", op1D, op, op2D));

	}

}
