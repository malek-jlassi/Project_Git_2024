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
import tn.esprit.entity.Employe;
import tn.esprit.gui.GetEmploye;
import tn.esprit.interfaces.IService;

/**
 *
 * @author ELAA
 */
public class EmployeService implements IService<Employe> {

    Connection cnx;

    public EmployeService() {
        cnx = MaConnexion.getInstance().getCnx();

    }

    @Override
    public void ajouter(Employe t) {
        String sql = "insert into employe(cin,nomprenom,gmail,phonenumber,birthdate,sexe,poste,departement) values"
                + "(?,?,?,?,?,?,?,?)";

        /*   try {
Statement st = cnx.createStatement ();
st.executeUpdate (sql) ;
System.out.println("Personne ajouté");
} catch (SQLException ex) {
System.out.println("Erreur d'insertion");}*/
        try {
            PreparedStatement st = cnx.prepareStatement(sql);

            st.setInt(1, t.getCin());
            st.setString(2, t.getNomprenom());
            st.setString(3, t.getGmail());
            st.setInt(4, t.getPhone());
            st.setDate(5, (Date) t.getBirth());

            st.setString(6, t.getSexe());
            st.setString(7, t.getPoste());
            st.setString(8, t.getDept());

            st.executeUpdate();
            System.out.println("employé ajouté !!!");
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

    
    public boolean ModifierEmployer(Employe e) throws SQLDataException {

               
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
    
    public List<Employe> afficherCardEmp() {
        List<Employe> Employes = new ArrayList<>();
        try {
           
            String sql="select cin, nomprenom from employe";
            Statement st = cnx.createStatement();
            
            ResultSet rs= st.executeQuery(sql);
            while(rs.next()){
                //cin,nomprenom,gmail,phonenumber,birthdate,sexe,poste,departemen
                Employe p = new Employe(rs.getInt("cin"),
                        rs.getString("nomprenom"));
                Employes.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Employes;
    }

    
    
    
   /* public void orderEmployeID() {

        String sql = "SELECT MAX(id) FROM employe";

       // connect = database.connectDB();
        int cID = 0;
        try {

           // prepare = connect.prepareStatement(sql);
            //result = prepare.executeQuery();
             Statement st = cnx.createStatement();
            
            ResultSet rs= st.executeQuery(sql);

            if (rs.next()) {
                 rs.getInt("MAX(id)");
            }
        }
         /*   String checkID = "SELECT MAX(customer_id) FROM receipt";

           // statement = connect.createStatement();
           // result = statement.executeQuery(checkID);

            if (result.next()) {
                cID = result.getInt("MAX(customer_id)");
            }

            if (customerID == 0) {
                customerID += 1;
            } else if (cID == customerID) {
                customerID = cID + 1;
            }

            data.cID = customerID;

        } catch (Exception e) {
        };

    }
    
     public ObservableList<GetEmploye> employeGetData() {
        orderEmployeID();

        String sql = "SELECT * FROM employe";

        ObservableList<GetEmploye> listData = FXCollections.observableArrayList();
    try {

          //  prepare = connect.prepareStatement(sql);
           // result = prepare.executeQuery();
 Statement st = cnx.createStatement();
            
            ResultSet rs= st.executeQuery(sql);
            GetEmploye getC;

            while (rs.next()) {
                // SET THE MATCH DATA TYPE TO OUR ARGUMENTS
                getC = new GetEmploye(
                        rs.getInt("cin"),
                        rs.getString("nomprenom"));

                listData.add(getC);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
     }
     */
    
    public Employe getEmployeByCin(int cin) {
    Employe employe = null;
    try {
        String sql = "SELECT * FROM employe WHERE cin = ?";
        PreparedStatement statement = cnx.prepareStatement(sql);
        statement.setInt(1, cin);
        ResultSet resultSet = statement.executeQuery();
        
        if (resultSet.next()) {
            int id = resultSet.getInt("id");
            int phone = resultSet.getInt("phonenumber");
            String nomprenom = resultSet.getString("nomprenom");
            String sexe = resultSet.getString("sexe");
            String dept = resultSet.getString("departement");
            String poste = resultSet.getString("poste");
            String gmail = resultSet.getString("gmail");
            Date birth = resultSet.getDate("birthdate");
            
            employe = new Employe(id, cin, phone, nomprenom, sexe, dept, poste, gmail, birth);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return employe;
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
