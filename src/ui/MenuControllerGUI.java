package ui;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import model.Contact;
import model.ContactManager;

public class MenuControllerGUI {

    @FXML
    private Pane mainPane;
    
    
    //TODO
    @FXML
    private TableView<Contact> tvContactList;

    @FXML
    private TableColumn<Contact, String> tcId;

    @FXML
    private TableColumn<Contact, String> tcName;

    @FXML
    private TableColumn<Contact, String> tcEmail;
    
    @FXML
    private TextField txtName;

    @FXML
    private TextField txtEmail;
    
    private ObservableList<Contact> observableList;
    private ContactManager contactManager;
    private int ID;
    
    
    
    public MenuControllerGUI() {
    	contactManager = new ContactManager();
    	ID = 2;
    }

   private void itializeTableView() {
	   observableList = FXCollections.observableArrayList(contactManager.getContacts());
	   
	   tvContactList.setItems(observableList);
	   tcId.setCellValueFactory(new PropertyValueFactory<Contact,String>("id"));
	   tcName.setCellValueFactory(new PropertyValueFactory<Contact,String>("name"));
	   tcEmail.setCellValueFactory(new PropertyValueFactory<Contact,String>("email"));
   }
    
    
    @FXML
    public void showForm1(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Formulary-1.fxml"));
    	fxmlLoader.setController(this);
    	Parent form1 = fxmlLoader.load();
    	mainPane.getChildren().setAll(form1);
    }

    @FXML
    public void showForm2(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Formulary-2.fxml"));
    	fxmlLoader.setController(this);
    	Parent form2 = fxmlLoader.load();
    	mainPane.getChildren().setAll(form2);
    }
    
    
    @FXML
    public void showListContact(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Formulary-3.fxml"));
    	fxmlLoader.setController(this);
    	Parent form3 = fxmlLoader.load();
    	mainPane.getChildren().setAll(form3);
    	
    	itializeTableView();
    }
    
    
    
    @FXML
    public void importContacts(ActionEvent event) {
    	
    }
     
    
    @FXML
    public void showInformation(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Contact Manager");
    	alert.setHeaderText("Juan Felipe Castillo Gomez");
    	alert.setContentText("Contact Manager Aplication");
    	alert.showAndWait();
    }
    
    
    
    @FXML
    public void addContact(ActionEvent event) {
    	String name = txtName.getText(); 
    	String email = txtEmail.getText();
    	String id = "";
    	
    	id+=ID;
    	
    	
    	Contact newContact = new Contact(id, name, email);
    	
    	
    	
    	if(contactManager.addNewContact(newContact) == true) {

            JOptionPane.showMessageDialog(null, "Se ha añadido correctamente el contacto");

        } else {
            JOptionPane.showMessageDialog(null, "No se ha podido añadir el contacto");
        }
    	
    	ID++;
    }
    
    
}

