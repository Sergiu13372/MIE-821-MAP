package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Main extends Application {
	@Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/resources/example.fxml"));
    
        Scene scene = new Scene(root, 300, 275);
    
        stage.setTitle("Seminar4");
        stage.setScene(scene);
        stage.show();
    }
}
