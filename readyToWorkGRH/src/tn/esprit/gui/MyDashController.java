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
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class MyDashController implements Initializable {
@FXML
    private Button dashboard_btn;

    @FXML
    private Button EmployeeBtn;

    @FXML
    private Button service_btn;

    @FXML
    private Button customers_btn;
    @FXML
     private AnchorPane dashboard_form;
    @FXML
     private AnchorPane Employee_form;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
    
     public void switchForm(ActionEvent event) {

        if (event.getSource() == dashboard_btn) {
            dashboard_form.setVisible(true);
            Employee_form.setVisible(false);
            //service_form.setVisible(false);
            //customers_form.setVisible(false);

        }  else if (event.getSource() == EmployeeBtn) {
            dashboard_form.setVisible(false);
            Employee_form.setVisible(true);
           // service_form.setVisible(false);
            //customers_form.setVisible(false);

            //orderDisplayCard();
            //orderDisplayOrder();
            //displayTotal();

        }} 
}
