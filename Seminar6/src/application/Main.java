package application;
	
import java.util.Optional;

import controller.ComputerRepairShopController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/MainViewSem6.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {

				@Override
				public void handle(WindowEvent we) {
					ComputerRepairShopController controller=loader.getController();
					
//					Alert alert = new Alert(AlertType.CONFIRMATION);
//					alert.setTitle("Exit program");
//					alert.setHeaderText("Salvati modificari inainte de inchidere?");
					//alert.setContentText("Choose your option.");

//					ButtonType buttonTypeOne = new ButtonType("Cancel");
////					ButtonType buttonTypeTwo = new ButtonType("Salvare");
//					ButtonType buttonTypeThree = new ButtonType("Inchidere fara salvare");
					//ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

//					alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeThree);

//					Optional<ButtonType> result = alert.showAndWait();
//					if (result.get() == buttonTypeOne){
//					    alert.close();
//					    we.consume();
//					}
//					else if (result.get() == buttonTypeTwo) {
//						ComputerRepairShopController controller=loader.getController();
//					    try {
//							controller.writeToFile("jucator.txt");
//							controller.writeToFile("echipa.txt");
//							controller.writeToFile("teren.txt");
//							controller.writeToFile("meci.txt");
//						} catch (Exception e) {
//							System.out.println("Eroare la scriere in fisier in Main.");
//						}
//					} 
//					else if (result.get() == buttonTypeThree) {
//					    alert.close();
//					}
					
					

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
