/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ELAA
 */
public class MaConnexion {
    
     String url ="jdbc:mysql://localhost:3306/readytowork";
    String user ="root";
    String pwd="";
   private Connection cnx;
   public static MaConnexion ct;

    public MaConnexion() {
        try {
            cnx = DriverManager.getConnection(url, user, pwd);
            System.out.println("Cnx etablie !!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static MaConnexion getInstance(){
        if(ct==null){
            ct= new MaConnexion();
        }
        return ct;
    }

    public Connection getCnx() {
        return cnx;
    }
    
}
