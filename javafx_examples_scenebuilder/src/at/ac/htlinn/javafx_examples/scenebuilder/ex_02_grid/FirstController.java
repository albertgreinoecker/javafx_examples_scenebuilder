package at.ac.htlinn.javafx_examples.scenebuilder.ex_02_grid;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;



public class FirstController {	
	@FXML
	Label status;

	@FXML
	Button b00, b01, b02;
	
	ArrayList<Button> btns = new ArrayList<>();
	
	@FXML
	public void initialize() {
		btns.add(b00);
		btns.add(b01);
		
	}

	@FXML
	void clickAny(ActionEvent event) {
		Button b = (Button)event.getSource();
		int cnt = Integer.parseInt(b.getText());
		b.setText((cnt+1) + ""); 
		String id = b.getId();
		status.setText("Button " + id + " wurde gedrückt!");
	}
}
