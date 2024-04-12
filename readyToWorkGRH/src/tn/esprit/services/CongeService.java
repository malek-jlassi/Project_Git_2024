/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static javax.management.remote.JMXConnectorFactory.connect;
import tn.esprit.connection.MaConnexion;
import tn.esprit.entity.Congé;
import tn.esprit.gui.GetEmploye;
import tn.esprit.interfaces.IService;

/**
 *
 * @author emna
 */
public class CongeService implements IService<Employe> {

    Connection cnx;

    public CongeService() {
        cnx = MaConnexion.getInstance().getCnx();

    }

    @Override
    public void ajouter(Congé t) {
        String sql = "insert into employe(idC,description,statut) values"
                + "(?,?,?)";

        /*   try {
Statement st = cnx.createStatement ();
st.executeUpdate (sql) ;
System.out.println("Personne ajouté");
} catch (SQLException ex) {
System.out.println("Erreur d'insertion");}*/
        try {
            PreparedStatement st = cnx.prepareStatement(sql);

            st.setInt(1, t.getidc());
            st.setString(2, t.getdescription());
            st.setString(3, t.getstatusl());
            st.executeUpdate();
            System.out.println("conge ajouté !!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Employe> afficher() {
        List<Employe> Employes = new ArrayList<>();
        try {
           
            String sql="select * from employe";
            Statement st = cnx.createStatement();
            
            ResultSet rs= st.executeQuery(sql);
            while(rs.next()){
                //cin,nomprenom,gmail,phonenumber,birthdate,sexe,poste,departemen
                Employe p = new Employe(rs.getInt("cin"), rs.getInt("phonenumber"),
                        rs.getString("nomprenom"), rs.getString("sexe"), rs.getString("departement")
                        , rs.getString("poste")
                        , rs.getString("gmail"), rs.getDate("birthdate"), rs.getString("image"));
                Employes.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Employes;
    }

    
    public boolean ModifierConge(Congé e) throws SQLDataException {

               
                String query = "UPDATE `employe` SET `cin`=? , `nomprenom`=? WHERE `id` = ?";
		PreparedStatement st;
        try {
                st = cnx.prepareStatement(query);
                st.setInt(1,e.getCin());
                /*st.setInt(2,e.getNbreplaces());
                st.setInt(3,e.getNbreparticipants());
                st.setDate(4,e.getDateDebut());
                st.setDate(5,e.getDateFin());
                st.setString(6,e.getTitre());
                st.setInt(7,e.getId());*/
                st.executeUpdate();
                return true;
                
        } catch (SQLException ex) {
            Logger.getLogger(EmployeService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
                
               
    }
    
    @Override
    public void supprimer(Employe t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getCin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNomprenom() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}