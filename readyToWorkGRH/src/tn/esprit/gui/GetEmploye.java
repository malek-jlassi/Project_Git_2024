/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author LENOVO
 */
public class GetEmploye extends Application {
   
    @Override
    public void start(Stage primaryStage) throws Exception {
    /*   Button btn = new Button();
        btn.setText("Say 'Hello World'");
        
         

        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        //root.getClass().getResource("../tn.esprit.gui/AddEmploye.fxml");
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();*/
      
   Parent root = FXMLLoader.load(getClass().getResource("EmpCard.fxml"));
primaryStage.setTitle("Display Employer");
primaryStage.setScene(new Scene(root));
primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
    
    
    // FOLLOW THE PARAMETERS
    /*public GetEmploye(Integer cin, String nomprenom){
        this.cin = cin;
        this.nomprenom = nomprenom;
    }

    public Integer getCin() {
        return cin;
    }

    public String getNomprenom() {
        return nomprenom;
    }*/
    
}
