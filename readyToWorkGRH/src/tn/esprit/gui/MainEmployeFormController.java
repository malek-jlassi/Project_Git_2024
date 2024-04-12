/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import tn.esprit.connection.MaConnexion;
import tn.esprit.entity.Employe;
import tn.esprit.services.EmployeService;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class MainEmployeFormController implements Initializable {

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
    @FXML
    private Button dashboard_btn;
    @FXML
    private Button EmployeeBtn;
    @FXML
    private AnchorPane dashboard_form;
    @FXML
    private AnchorPane Employee_form;
    private TextField cin;
    private TextField nom;
    @FXML
    private Button SalaireBtn;
    @FXML
    private AnchorPane Salaire_Form;
    @FXML
    private Label username;
    private TextField addemployee_search;
    @FXML
    private TextField addemployee_cin;
    @FXML
    private TextField addemployee_nomprenom;
    @FXML
    private TextField addemployee_gmail;
    @FXML
    private DatePicker addemployee_datenaissance;
    @FXML
    private ComboBox<String> addemployee_sexe;
    @FXML
    private TextField addemployee_telephone;
    @FXML
    private ComboBox<String> addemployee_poste;
    @FXML
    private ComboBox<String> addemployee_departement;
    @FXML
    private ImageView addEmployee_image;
    @FXML
    private Button addemployee_impoterBtn;
    @FXML
    private TextField salary_employeeCIN;
    @FXML
    private Label salary_nomprenom;
    @FXML
    private Label salary_gmail;
    @FXML
    private Label salary_poste;
    @FXML
    private TextField salary_salary;
    @FXML
    private Button salary_clearBtn;
    @FXML
    private Button salary_modifierBtn;
    @FXML
    private TableView<Employe> salary_TableView;
    @FXML
    private TableColumn<Employe, String> salary_col_cin;
    @FXML
    private TableColumn<Employe, String> salary_col_nomprenom;
    @FXML
    private TableColumn<Employe, String> salary_col_gmail;
    @FXML
    private TableColumn<Employe, String> salary_col_poste;
   
    @FXML
    private Button logout;
    
      private Connection connect;
       private Statement statement;
    private PreparedStatement prepare;
    private ResultSet result;
      private double x = 0;
    private double y = 0;
    
    
    
    
    
     int c;
    int file;
    File pDir;
    File pfile;
    String lien;
    
    
    
    
    private Image image;
    @FXML
    private Button addemployee_clearBtn;
    @FXML
    private Button addemployee_suppBtn;
    @FXML
    private Button addemployee_modifierBtn;
    @FXML
    private Button addemployee_ajoutBtn;
    @FXML
    private Label home_totalEmployees;
    @FXML
    private TextField addEmployee_search;
    @FXML
    private Label home_totalPresents;
    @FXML
    private Label home_totalInactiveEm;
    @FXML
    private AreaChart<?, ?> home_chart;
    @FXML
    private BarChart<?, ?> dashbaord_IPD_chart;
    @FXML
    private LineChart<?, ?> employe_chart;
    
    
    @FXML
    private TableColumn<Employe, Double> salary_col_salary;
    @FXML
    private Label home_dept;

    /**
     * Initializes the controller class.
     */
     
    
    @FXML
     public void addEmployeeAdd() {

      
Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        
        
       String sql = "insert into employe(cin,nomprenom,gmail,phonenumber,birthdate,sexe,poste,departement,image) values"
                + "(?,?,?,?,?,?,?,?,?)";

        connect = MaConnexion.getInstance().getCnx();

        try {
            Alert alert;
            if (addemployee_cin.getText().isEmpty()
                    || addemployee_nomprenom.getText().isEmpty()
                    || addemployee_gmail.getText().isEmpty() 
                    || addemployee_datenaissance.getEditor().getText().isEmpty() 
                    || addemployee_telephone.getText().isEmpty()
                    || addemployee_sexe.getSelectionModel().getSelectedItem() == null
                    || addemployee_poste.getSelectionModel().getSelectedItem() == null
                    || addemployee_departement.getSelectionModel().getSelectedItem() == null
                    || getData.path == null || getData.path == "") {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Message d'erreur");
                alert.setHeaderText(null);
                alert.setContentText("Veuillez remplir tous les champs vides");
                alert.showAndWait();
            } 
            
            else if(addemployee_telephone.getText().toString().length()<8 || addemployee_telephone.getText().toString().length()>8 )
                {
                    alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur !!!");
                alert.setHeaderText(null);
                alert.setContentText("vérifier votre numéro de téléphone!!!");
                alert.showAndWait();
                }
            
            else if (!addemployee_gmail.getText().contains("@gmail")) {
    alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Erreur !!!");
    alert.setHeaderText(null);
    alert.setContentText("Veuillez vérifier votre adresse e-mail (doit être sous la forme xxx@gmail.com) !");
    alert.showAndWait();
}
            
            
            
            else {

                String check = "SELECT cin FROM employe WHERE cin = '"
                        + addemployee_cin.getText() + "'";

                statement = connect.createStatement();
                result = statement.executeQuery(check);

                if (result.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Message d'erreur");
                    alert.setHeaderText(null);
                    alert.setContentText("Employee Cin: " + addemployee_cin.getText() + " existait déjà !");
                    alert.showAndWait();
                } else {
                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, addemployee_cin.getText());
                    prepare.setString(2, addemployee_nomprenom.getText());
                    prepare.setString(3, addemployee_gmail.getText());
                    prepare.setString(4, addemployee_telephone.getText());
                   // prepare.setString(5, ((TextField)addemployee_datenaissance.getEditor()).getText());
                    
                     prepare.setString(5, String.valueOf(sqlDate));
                    prepare.setString(6, (String) addemployee_sexe.getSelectionModel().getSelectedItem());
                    prepare.setString(7, (String) addemployee_poste.getSelectionModel().getSelectedItem());
                    prepare.setString(8, (String) addemployee_departement.getSelectionModel().getSelectedItem());
                  

                    String uri = getData.path;
                    uri = uri.replace("\\", "\\\\");

                    prepare.setString(9, uri);
                   // prepare.setString(8, String.valueOf(sqlDate));
                    prepare.executeUpdate();

                 String insertInfo = "INSERT INTO employee_salary "
                            + "(cin,nomprenom,gmail,poste,salary,date) "
                            + "VALUES(?,?,?,?,?,?)";

                    prepare = connect.prepareStatement(insertInfo);
                    prepare.setString(1, addemployee_cin.getText());
                    prepare.setString(2, addemployee_nomprenom.getText());
                    prepare.setString(3, addemployee_gmail.getText());
                    prepare.setString(4, (String) addemployee_poste.getSelectionModel().getSelectedItem());
                  //  prepare.setString(4, (String) salary_poste.getText());
                    prepare.setString(5, "0.0");
                    prepare.setString(6, String.valueOf(sqlDate));
                    prepare.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Message d'information");
                    alert.setHeaderText(null);
                    alert.setContentText("Employé ajouté avec succès!");
                    alert.showAndWait();

                    addEmployeeShowListData();
                    addEmployeeReset();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
     
     
     
     
     
     
    @FXML
        public void addEmployeeUpdate() {

        String uri = getData.path;
        uri = uri.replace("\\", "\\\\");

        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        String sql = "UPDATE employe SET nomprenom = '"
                + addemployee_nomprenom.getText() + "', gmail = '"
                + addemployee_gmail.getText()+ "',birthdate = '" + sqlDate+  "', phonenumber = '"
                + addemployee_telephone.getText() +"', sexe = '"
                + addemployee_sexe.getSelectionModel().getSelectedItem() + "', poste = '"
                + addemployee_poste.getSelectionModel().getSelectedItem() + "', departement = '"
                + addemployee_departement.getSelectionModel().getSelectedItem() + "', image = '"
                + uri + "' WHERE cin ='"
                + addemployee_cin.getText() + "'";

        connect = MaConnexion.getInstance().getCnx();

        try {
            Alert alert;
            if (addemployee_cin.getText().isEmpty()
                   || addemployee_nomprenom.getText().isEmpty()
                    || addemployee_gmail.getText().isEmpty() 
                    || addemployee_datenaissance.getEditor().getText().isEmpty() 
                    || addemployee_telephone.getText().isEmpty()
                    || addemployee_sexe.getSelectionModel().getSelectedItem() == null
                    || addemployee_poste.getSelectionModel().getSelectedItem() == null
                    || addemployee_departement.getSelectionModel().getSelectedItem() == null
                    || getData.path == null || getData.path == "") {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Message d'erreur");
                alert.setHeaderText(null);
                alert.setContentText("Veuillez remplir tous les champs vides");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Message de confirmation");
                alert.setHeaderText(null);
                alert.setContentText("Êtes-vous sûr de vouloir METTRE À JOUR le CIN de l'employé : " + addemployee_cin.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

               if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(sql);

                     double salary = 0;

                    String checkData = "SELECT * FROM employee_salary WHERE cin = '"
                            + addemployee_cin.getText() + "'";

                    prepare = connect.prepareStatement(checkData);
                    result = prepare.executeQuery();

                    while (result.next()) {
                        salary = result.getDouble("salary");
                    }

                       String updateInfo = "UPDATE employee_salary SET nomprenom = '"
                            + addemployee_nomprenom.getText() + "', gmail = '"
                            + addemployee_gmail.getText() + "', poste = '"
                            + addemployee_poste.getSelectionModel().getSelectedItem()
                            + "' WHERE cin = '"
                            + addemployee_cin.getText() + "'";

                    prepare = connect.prepareStatement(updateInfo);
                    prepare.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Message d'information");
                    alert.setHeaderText(null);
                    alert.setContentText("Mise à jour réussie!");
                    alert.showAndWait();

                    addEmployeeShowListData();
                    addEmployeeReset();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
     
     
    @FXML
     public void addEmployeeDelete() {

        String sql = "DELETE FROM employe WHERE cin = '"
                + addemployee_cin.getText() + "'";

        connect = MaConnexion.getInstance().getCnx();

        try {

            Alert alert;
            if (addemployee_cin.getText().isEmpty()
                   || addemployee_nomprenom.getText().isEmpty()
                    || addemployee_gmail.getText().isEmpty() 
                    || addemployee_datenaissance.getEditor().getText().isEmpty() 
                    || addemployee_telephone.getText().isEmpty()
                    || addemployee_sexe.getSelectionModel().getSelectedItem() == null
                    || addemployee_poste.getSelectionModel().getSelectedItem() == null
                    || addemployee_departement.getSelectionModel().getSelectedItem() == null
                    || getData.path == null || getData.path == "") {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Message d'erreur");
                alert.setHeaderText(null);
                alert.setContentText("Veuillez remplir tous les champs vides");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Message de confirmation");
                alert.setHeaderText(null);
                alert.setContentText("Êtes-vous sûr de vouloir SUPPRIMER Employé CIN : " + addemployee_cin.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(sql);

                    String deleteInfo = "DELETE FROM employee_salary WHERE cin = '"
                            + addemployee_cin.getText() + "'";

                    prepare = connect.prepareStatement(deleteInfo);
                    prepare.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Message d'information");
                    alert.setHeaderText(null);
                    alert.setContentText("Supprimé avec succès !");
                    alert.showAndWait();

                    addEmployeeShowListData();
                    addEmployeeReset();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
     
    @FXML
         public void addEmployeeReset() {
        addemployee_cin.setText("");
        addemployee_nomprenom.setText("");
        addemployee_gmail.setText("");
        addemployee_datenaissance.getEditor().setText("");
        addemployee_telephone.setText("");
        addemployee_sexe.getSelectionModel().clearSelection();
        addemployee_poste.getSelectionModel().clearSelection();
        addemployee_departement.getSelectionModel().clearSelection();
        
        addEmployee_image.setImage(null);
        getData.path = "";
    }
    
    
          private String[] positionList = {"Devops Enginner", "Web Developer (Back End)", "Web Developer (Front End)", "Data scientist","Administrateur","QA Engineer","Designer"};
    @FXML
    public void addEmployeePositionList() {
        List<String> listP = new ArrayList<>();

        for (String data : positionList) {
            listP.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listP);
        addemployee_poste.setItems(listData);
    }

    private String[] listGender = {"Homme", "Femme", "Autre"};

    @FXML
    public void addEmployeeGenderList() {
        List<String> listG = new ArrayList<>();

        for (String data : listGender) {
            listG.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listG);
        addemployee_sexe.setItems(listData);
    }
    
     private String[] listDepartement = {"Departement Dev", "Departement Testing", "Departement Administrative", "Departement Design" , "Department Data science & Analystic"};

    @FXML
    public void addEmployeeDepartementList() {
        List<String> listG = new ArrayList<>();

        for (String data : listDepartement) {
            listG.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listG);
        addemployee_departement.setItems(listData);
    }

         
         
  //  private ObservableList<Employe> addEmployeeList;
    @FXML
    private AnchorPane main_form;

    

    
 
    
    
    
    
    
     public ObservableList<Employe> addEmployeeListData() {

        ObservableList<Employe> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM employe";

        connect = MaConnexion.getInstance().getCnx();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            Employe employeeD;

            while (result.next()) {
                employeeD = new Employe(result.getInt("cin"), result.getInt("phonenumber"),
                        result.getString("nomprenom"), result.getString("sexe"), result.getString("departement")
                        , result.getString("poste")
                        , result.getString("gmail"), result.getDate("birthdate"), result.getString("image"));
                listData.add(employeeD);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }
    private ObservableList<Employe> addEmployeeList;

    public void addEmployeeShowListData() {
        addEmployeeList = addEmployeeListData();

               tableEmploye.setItems(addEmployeeList);
        cinculumn.setCellValueFactory(new PropertyValueFactory<Employe, Integer>("cin"));
        nomprenomculumn.setCellValueFactory(new PropertyValueFactory<Employe, String>("nomprenom"));
        gmailculumn.setCellValueFactory(new PropertyValueFactory<Employe, String>("gmail"));
        
        birthculumn.setCellValueFactory(new PropertyValueFactory<Employe, Date>("birth"));
        phoneculumn.setCellValueFactory(new PropertyValueFactory<Employe, Integer>("phone"));
        sexeculumn.setCellValueFactory(new PropertyValueFactory<Employe, String>("Sexe"));
        posteculumn.setCellValueFactory(new PropertyValueFactory<Employe, String>("Poste"));
        deptculumn.setCellValueFactory(new PropertyValueFactory<Employe, String>("dept"));
     //   addEmployeeSearch();

    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @FXML
     public void addEmployeeSelect() {
        Employe employeeD = tableEmploye.getSelectionModel().getSelectedItem();
        int num = tableEmploye.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        addemployee_cin.setText(String.valueOf(employeeD.getCin()));
        addemployee_nomprenom.setText(employeeD.getNomprenom());
        addemployee_gmail.setText(employeeD.getGmail());
        addemployee_telephone.setText(String.valueOf(employeeD.getPhone()));  
        addemployee_datenaissance.getEditor().setText(String.valueOf(employeeD.getBirth())); 
        addemployee_sexe.setValue(employeeD.getSexe());
        addemployee_poste.setValue(employeeD.getPoste());
        addemployee_departement.setValue(employeeD.getDept());
   
        getData.path = employeeD.getImage();

        String uri = "file:" + employeeD.getImage();

        image = new Image(uri, 117, 150, false, true);
        addEmployee_image.setImage(image);
         
    }

 



@FXML
public void addEmployeeInsertImage() {
    String folderPath = "C:/xampp/htdocs/img"; // Replace with your desired folder path

    FileChooser fileChooser = new FileChooser();
    fileChooser.getExtensionFilters().add(
            new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif")
    );

    // Set initial directory for file chooser
    File initialDirectory = new File(folderPath);
    fileChooser.setInitialDirectory(initialDirectory);

    Window window = main_form.getScene().getWindow();
    File file = fileChooser.showOpenDialog(window);

    if (file != null) {
        String imagePath = file.getAbsolutePath();

        // Set image path and display the image
        getData.path = imagePath;
        image = new Image(file.toURI().toString(), 117, 150, false, true);
        addEmployee_image.setImage(image);
    }
}


       
    

    
       
       
       
 @FXML
public void addEmployeeSearch(KeyEvent event) {
    String searchKey = addemployee_search.getText().toLowerCase();
    
    FilteredList<Employe> filter = new FilteredList<>(addEmployeeList, predicateEmployeeData -> {
        if (searchKey == null || searchKey.isEmpty()) {
            return true;
        }

        return String.valueOf(predicateEmployeeData.getCin()).contains(searchKey) ||
                predicateEmployeeData.getNomprenom().toLowerCase().contains(searchKey) ||
                predicateEmployeeData.getGmail().toLowerCase().contains(searchKey) ||
                String.valueOf(predicateEmployeeData.getPhone()).contains(searchKey) ||
                predicateEmployeeData.getSexe().toLowerCase().contains(searchKey) ||
                predicateEmployeeData.getPoste().toLowerCase().contains(searchKey) ||
                predicateEmployeeData.getDept().toLowerCase().contains(searchKey) ||
                predicateEmployeeData.getBirth().toString().contains(searchKey);
    });

    SortedList<Employe> sortList = new SortedList<>(filter);
    sortList.comparatorProperty().bind(tableEmploye.comparatorProperty());
    tableEmploye.setItems(sortList);
}

        
        
       
    @FXML
    public void switchForm(ActionEvent event) {

        if (event.getSource() == dashboard_btn) {
            dashboard_form.setVisible(true);
            Employee_form.setVisible(false);
            Salaire_Form.setVisible(false);
            

        }  else if (event.getSource() == EmployeeBtn) {
            dashboard_form.setVisible(false);
            Employee_form.setVisible(true);
             Salaire_Form.setVisible(false);
           //  addEmployeeSearch();
             addEmployeeGenderList();
            addEmployeePositionList();
            
           // addEmployeeSearch();

        }
        else if (event.getSource() == SalaireBtn) {
            dashboard_form.setVisible(false);
            Employee_form.setVisible(false);
            Salaire_Form.setVisible(true);
            salaryShowListData();
        }
    } 

  
      public ObservableList<Employe> salaryListData() {

        ObservableList<Employe> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM employee_salary";

         connect = MaConnexion.getInstance().getCnx();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            Employe employeeD;

            while (result.next()) {
                employeeD = new Employe(result.getInt("cin"),
                         result.getString("nomprenom"),
                         result.getString("gmail"),
                         result.getString("poste"),
                         result.getDouble("salary"),
                 result.getDate("date"));

                listData.add(employeeD);
               
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
        
    }
    
      
    private ObservableList<Employe> salaryList;
      

    
    
  public void salaryShowListData() {
        salaryList = salaryListData();
        System.out.println("salary list is");
        System.out.println(salaryListData());
        salary_col_cin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        salary_col_nomprenom.setCellValueFactory(new PropertyValueFactory<>("nomprenom"));
        salary_col_gmail.setCellValueFactory(new PropertyValueFactory<>("gmail"));
        salary_col_poste.setCellValueFactory(new PropertyValueFactory<>("poste"));
        salary_col_salary.setCellValueFactory(new PropertyValueFactory<Employe, Double>("salary"));
        salary_TableView.setItems(salaryList);
        salary_TableView.refresh();

    }
      
      
    
    @FXML
     public void logout() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Message de confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Êtes-vous sûr de vouloir vous déconnecter ?");
        Optional<ButtonType> option = alert.showAndWait();
        try {
            if (option.get().equals(ButtonType.OK)) {

                logout.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                root.setOnMousePressed((MouseEvent event) -> {
                    x = event.getSceneX();
                    y = event.getSceneY();
                });

                root.setOnMouseDragged((MouseEvent event) -> {
                    stage.setX(event.getScreenX() - x);
                    stage.setY(event.getScreenY() - y);

                    stage.setOpacity(.8);
                });

                root.setOnMouseReleased((MouseEvent event) -> {
                    stage.setOpacity(1);
                });

                stage.initStyle(StageStyle.TRANSPARENT);

                stage.setScene(scene);
                stage.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

     
     
     
    @FXML
       public void salaryUpdate() {

        String sql = "UPDATE employee_salary SET salary = '" + salary_salary.getText()
                + "' WHERE cin = '" + salary_employeeCIN.getText() + "'";

       connect = MaConnexion.getInstance().getCnx();

        try {
            Alert alert;

            if (salary_employeeCIN.getText().isEmpty()
                    || salary_nomprenom.getText().isEmpty()
                    || salary_gmail.getText().isEmpty()
                    || salary_poste.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Message d'erreur");
                alert.setHeaderText(null);
                alert.setContentText("Veuillez d'abord sélectionner l'article");
                alert.showAndWait();
            } else {
                statement = connect.createStatement();
                statement.executeUpdate(sql);

                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Message d'information");
                alert.setHeaderText(null);
                alert.setContentText("Mise à jour réussie!");
                alert.showAndWait();

                salaryShowListData();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void salaryReset() {
        salary_employeeCIN.setText("");
        salary_nomprenom.setText("");
        salary_gmail.setText("");
        salary_poste.setText("");
        salary_salary.setText("");
    }

    
    
    @FXML
        public void salarySelect() {

        Employe employeeD = salary_TableView.getSelectionModel().getSelectedItem();
        int num = salary_TableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        salary_employeeCIN.setText(String.valueOf(employeeD.getCin()));
        salary_nomprenom.setText(employeeD.getNomprenom());
        salary_gmail.setText(employeeD.getGmail());
        salary_poste.setText(employeeD.getPoste());
        salary_salary.setText(String.valueOf(employeeD.getSalary()));

    }
     
        public void homeTotalEmployees() {

        String sql = "SELECT COUNT(id) FROM employe";

        connect = MaConnexion.getInstance().getCnx();
        int countData = 0;
        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                countData = result.getInt("COUNT(id)");
            }

            home_totalEmployees.setText(String.valueOf(countData));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
        
         public void homeEmployeeTotalPresent() {

        String sql = "SELECT COUNT(id) FROM employee_salary";

     connect = MaConnexion.getInstance().getCnx();
        int countData = 0;
        try {
            statement = connect.createStatement();
            result = statement.executeQuery(sql);

            while (result.next()) {
                countData = result.getInt("COUNT(id)");
            }
            home_totalPresents.setText(String.valueOf(countData));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

         public void homeTotalInactive() {

        String sql = "SELECT COUNT(id) FROM employee_salary WHERE salary = '0.0'";

        connect = MaConnexion.getInstance().getCnx();
        int countData = 0;
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                countData = result.getInt("COUNT(id)");
            }
            home_totalInactiveEm.setText(String.valueOf(countData));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
         
         
          public void homeTotalDepartements() {

        String sql = "SELECT COUNT(DISTINCT departement) FROM employe";

        connect = MaConnexion.getInstance().getCnx();
        int countData = 0;
        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                countData = result.getInt("COUNT(DISTINCT departement)");
            }

            home_dept.setText(String.valueOf(countData));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
        

         
    public void homeChart() {

        home_chart.getData().clear();

        String sql = "SELECT birthdate, COUNT(id) FROM employe GROUP BY birthdate ORDER BY TIMESTAMP(birthdate) ASC LIMIT 7";

        connect = MaConnexion.getInstance().getCnx();

        try {
            XYChart.Series chart = new XYChart.Series();

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                chart.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
            }

            home_chart.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
           
           
           public void homeChartemp() {

        dashbaord_IPD_chart.getData().clear();

        String sql = "SELECT poste, COUNT(id) FROM employe GROUP BY poste ORDER BY poste ASC LIMIT 7";

        connect = MaConnexion.getInstance().getCnx();

        try {
            XYChart.Series chart = new XYChart.Series();

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                chart.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
            }

            dashbaord_IPD_chart.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
        
           
          public void displayIPDChart() {

        employe_chart.getData().clear();

        String sql = "SELECT sexe, COUNT(id) FROM employe GROUP BY sexe";

         connect = MaConnexion.getInstance().getCnx();

        try {
            XYChart.Series chart = new XYChart.Series<>();

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                chart.getData().add(new XYChart.Data<>(result.getString(1), result.getFloat(2)));
            }

            employe_chart.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
       @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       // populateTable();
       addEmployeeShowListData();
       addEmployeePositionList();
        addEmployeeGenderList();
        addEmployeeDepartementList();
         salaryShowListData();
         
      // addEmployeeSearch();
         // addEmployeeSearch();
         homeTotalEmployees(); 
        homeEmployeeTotalPresent();
        homeTotalInactive();
        homeChart();
        homeChartemp();
        displayIPDChart();
        homeTotalDepartements();
        
         
    } 

}
