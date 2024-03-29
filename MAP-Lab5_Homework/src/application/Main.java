//--module-path "C:\Program Files\Java\javafx-sdk-17.0.1\lib" --add-modules javafx.controls,javafx.fxml

package application;

import controller.ControllerGUI;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	boolean isStarted = false;
	
	@Override
	public void start(Stage stage) {
		try {
			FXMLLoader loader=new FXMLLoader(getClass().getResource("/resources/view.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root, 600, 320);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
			stage.setTitle("Cars Dealership");
			stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent we) {
				ControllerGUI controller = loader.getController();
				if(!isStarted) {
					controller.initialize();
					isStarted = true;
				}
			}
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
