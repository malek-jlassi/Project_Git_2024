/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import tn.esprit.entity.Employe;
import tn.esprit.services.EmployeService;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AddEmployeController implements Initializable {

    @FXML
    private DatePicker datenaissance;
    @FXML
    private TextField name;
    @FXML
    private TextField phone;
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

//    void getDate(ActionEvent event) {
//        Date d = Date.valueOf(datenaissance.getValue());
////System.out.println(myDate.toString());
//
////String myFormattedDate = myDate. format (DateTineFormatter.ofPattern(“MM-dd-yyyy"));
////myLabel.setText(myFormattedDate);}
//    }

    @FXML
    private void ajout(ActionEvent event) {

        int cinNum = Integer.parseInt(cin.getText());
        String gmail = email.getText();
        String nomprenom = name.getText();
        int telephone = Integer.parseInt(phone.getText());
         Date d = Date.valueOf(datenaissance.getValue());
        String sexe = genre.getText();
        String position = poste.getText();
        String departement = dept.getText();

        Employe p = new Employe(cinNum, telephone, nomprenom, sexe, departement, position, gmail, d);
        EmployeService pe = new EmployeService();
        pe.ajouter(p);

    }

}
