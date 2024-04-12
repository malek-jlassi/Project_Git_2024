/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import tn.esprit.entity.Employe;
import tn.esprit.services.EmployeService;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class EmpCardController implements Initializable {

    @FXML
    private AnchorPane Card_Form;
    @FXML
    private Label emp_cin;
    @FXML
    private Label emp_nomprenom;
    
        private int cin;
    
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        customerDisplay() ;
    }    
    
       public void setData(EmployeService employe) {
        emp_cin.setText(String.valueOf(employe.getCin()));
        emp_nomprenom.setText(employe.getNomprenom());
    }
    // private ObservableList<GetEmploye> listC = FXCollections.observableArrayList();

     public void customerDisplay() {
        EmployeService empcrud = new EmployeService();
         System.out.println(empcrud.afficherCardEmp());
         //  System.out.println(empcrud.getEmployeByCin(empcrud.getCin()));
       // Employe employe = empcrud.getEmployeByCin(cin); // Retrieve employe data from the database by ID
        setData(empcrud);
    }
    
   
    
}
