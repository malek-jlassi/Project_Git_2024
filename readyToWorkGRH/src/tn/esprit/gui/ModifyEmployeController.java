/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class ModifyEmployeController implements Initializable {

    @FXML
    private DatePicker datenaissance;
    @FXML
    private TextField name;
    @FXML
    private TextField phone;
    @FXML
    private Text sexe;
    @FXML
    private TextField genre;
    @FXML
    private TextField dept;
    @FXML
    private TextField poste;
    @FXML
    private TextField cin;
    @FXML
    private TextField email;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modif(ActionEvent event) {
    }
    
}
