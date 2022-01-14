package controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.ComputerRepairRequest;
import model.RepairedForm;
import repository.RepairedFormRepository;
import repository.RequestRepository;

public class ComputerRepairShopController implements Initializable{

	private RepairedFormRepository repairedFormRepo;
	private RequestRepository requestRepo;
	
	private ObservableList<ComputerRepairRequest> list;
	
	@FXML private TextField name_tf;
	@FXML private TextField address_tf;
	@FXML private TextField phone_tf;
	@FXML private TextField computer_model_tf;
	@FXML private TextField problem_tf;
	
	@FXML private DatePicker datepicker;
	@FXML private Button addRequestBtn;
	@FXML private Button clearFieldsBtn;
	
	@FXML private TextField request_tf;
	@FXML private TextField services_tf;
	@FXML private TextField price_tf;
	@FXML private TextField employee_tf;
	@FXML private Button searchBtn;
	@FXML private Button addRepairFormBtn;
	@FXML private DatePicker datepicker2;
	
	@FXML
	private TableView<ComputerRepairRequest> requestTableView;
	@FXML
	private TableColumn<ComputerRepairRequest,Integer> requestIDCol;
	@FXML
	private TableColumn<ComputerRepairRequest,String> modelCol;
	@FXML
	private TableColumn<ComputerRepairRequest,String> problemCol;
	@FXML
	private TableColumn<ComputerRepairRequest,String> requestDateCol;
	
	@FXML
	private TextField firstNameField;
	@FXML
	private TextField lastNameField;
	@FXML
	private TextField emailField;
	
	public ComputerRepairShopController() {
		this.repairedFormRepo = new RepairedFormRepository();
		this.requestRepo = new RequestRepository();
		this.list = FXCollections.observableArrayList();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		requestIDCol.setCellValueFactory(new PropertyValueFactory<ComputerRepairRequest,Integer>("ID")); 
		modelCol.setCellValueFactory(new PropertyValueFactory<ComputerRepairRequest,String>("model")); 
		problemCol.setCellValueFactory(new PropertyValueFactory<ComputerRepairRequest,String>("problemDescription"));
		requestDateCol.setCellValueFactory(new PropertyValueFactory<ComputerRepairRequest,String>("date"));
		
		for(ComputerRepairRequest elem: requestRepo.findAll()){
			list.add(elem);
		}
		
		System.out.println(requestTableView);
		System.out.println(list);
		
		requestTableView.setItems(list);
	}
	
    @FXML
    public void clearFields(ActionEvent event) throws IOException {
        name_tf.setText("");
        address_tf.setText("");
        phone_tf.setText("");
        computer_model_tf.setText("");
        problem_tf.setText("");
        datepicker.setValue(null);
    }
    
    @FXML
    public void addRequest(ActionEvent event) throws IOException {
    	String name = name_tf.getText();
    	if (name.equals("")) {
    		name_tf.setStyle("-fx-border-color: red;");
    		return;
    	}
    	else {
    		name_tf.setStyle("-fx-border-color: none;");
    	}
    	
    	String address = address_tf.getText();
    	if (address.equals("")) {
    		address_tf.setStyle("-fx-border-color: red;");
    		return;
    	}
    	
    	String phone = phone_tf.getText();
    	if (phone.equals("")) {
    		phone_tf.setStyle("-fx-border-color: red;");
    		return;
    	}
    	
    	String computer_model = computer_model_tf.getText();
    	if (computer_model.equals("")) {
    		computer_model_tf.setStyle("-fx-border-color: red;");
    		return;
    	}
    	
    	String problem = problem_tf.getText();
    	if (problem.equals("")) {
    		problem_tf.setStyle("-fx-border-color: red;");
    		return;
    	}
    	
    	LocalDate date = datepicker.getValue();
    	if (date.toString().equals("")) {
    		datepicker.setStyle("-fx-border-color: red;");
    		return;
    	}
    	
    	Integer ID = 0;
    	
    	for(ComputerRepairRequest elem: requestRepo.findAll()){
			if (elem.getID()>ID) {
				ID = elem.getID();
			}
		}
    	
    	ComputerRepairRequest req = new ComputerRepairRequest(ID+1, name, address, phone, computer_model, date.toString(), problem);
    	this.requestRepo.add(req);
    	this.list.add(req);
    	
    	System.out.println(this.requestRepo.findAll().toString());
    	this.clearFields(event);
    }
    
    @FXML
    public void search(ActionEvent event) throws IOException {
    	// TO DO
    	String model = request_tf.getText();
    	
    	requestTableView.setItems(list);
    }
    
    @FXML
    public void addRepairForm(ActionEvent event) throws IOException {
    	String services = services_tf.getText();
    	String price = price_tf.getText();
    	String employee = employee_tf.getText();
    	String date = datepicker2.getValue().toString();
    	
		ComputerRepairRequest req = requestTableView.getSelectionModel().getSelectedItem();
		
    	Integer ID = 0;
    	
    	for(RepairedForm elem: repairedFormRepo.findAll()){
			if (elem.getID()>ID) {
				ID = elem.getID();
			}
		}

		this.repairedFormRepo.add(new RepairedForm(ID+1, req, services, Integer.parseInt(price), date, employee));
		
		System.out.println("Repaired form: "+this.repairedFormRepo.findAll().toString());
    }
}
