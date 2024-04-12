/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import tn.esprit.entity.Employe;
import tn.esprit.services.EmployeService;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AfficheEmployeController implements Initializable {

    @FXML
    private TextField search;
    @FXML
    private TableView<Employe> tableEmploye;
    @FXML
    private TableColumn<Employe, Integer> cinculumn;
    @FXML
    private TableColumn<Employe, String> nomprenomculumn;
    @FXML
    private TableColumn<Employe, String> gmailculumn;
    @FXML
    private TableColumn<Employe, Date> birthculumn;
    @FXML
    private TableColumn<Employe, Integer> phoneculumn;
    @FXML
    private TableColumn<Employe, String> sexeculumn;
    @FXML
    private TableColumn<Employe, String> posteculumn;
    @FXML
    private TableColumn<Employe, String> deptculumn;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO$=
        
   populateTable();
   }
    //public void setList(String table) {
    //     this.table.setTableView(table);
    //}

    public void populateTable() {
        EmployeService empcrud = new EmployeService();
        System.out.println(empcrud.afficher());
         ObservableList<Employe> emp = FXCollections
                .observableArrayList(empcrud.afficher());
        this.tableEmploye.setItems(emp);
        this.cinculumn.setCellValueFactory(new PropertyValueFactory<Employe, Integer>("cin"));
        this.nomprenomculumn.setCellValueFactory(new PropertyValueFactory<Employe, String>("nomprenom"));
        this.gmailculumn.setCellValueFactory(new PropertyValueFactory<Employe, String>("gmail"));

    }

    @FXML
    private void ajout(ActionEvent event) {
    }

    @FXML
    private void modif(ActionEvent event) {
    }

    @FXML
    private void supp(ActionEvent event) {
    }

}
