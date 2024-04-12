/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author LENOVO
 */
public class MyDashScreen extends Application {
    
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
   
     
    
        
        
        
      
   Parent root = FXMLLoader.load(getClass().getResource("MyDash.fxml"));
primaryStage.setTitle("Dashoboard Employer");
primaryStage.setScene(new Scene(root));
primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
   
    
  
}
