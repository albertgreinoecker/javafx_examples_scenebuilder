package at.ac.htlinn.javafx_examples.scenebuilder.ex_04_canvas_game;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * simple demo for working with css
 */
public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("/at/ac/htlinn/javafx_examples/scenebuilder/ex_04_canvas_game/Game.fxml"));
			Scene scene = new Scene(root,1200,1000);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
