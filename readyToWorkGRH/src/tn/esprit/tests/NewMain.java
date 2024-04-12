/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.tests;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import tn.esprit.connection.MaConnexion;
import tn.esprit.entity.Employe;
import tn.esprit.services.EmployeService;

/**
 *
 * @author ELAA
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       MaConnexion con = new MaConnexion();
       EmployeService es=new EmployeService();
       
     /*  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate date = LocalDate.parse("06/05/2023", formatter);
    
   //Employe e1 = new Employe(2, 25, 3, "Malek", "Jelassi", "dgfddf", "jgfgh", "sdfezedf", date);
        
    //es.ajouter(e1);
      Employe e1=new Employe(2,25,3,"Malek","Jelassi","dgfddf","jgfgh","sdfezedf",06/05/2023);*/
        
    // es.ajouter(e1);
//         TODO code application logic here
    }
    
}
