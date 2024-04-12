/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.entity;


import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Lenovo
 */
public class Employe {
    
    private int id,cin,phone;
    private String nomprenom,sexe,dept,poste,gmail,image;
    private Date birth, date;
    private Double salary;
    private int datenaiss;

    public Employe(int id, int cin, int phone, String nomprenom, String sexe, String dept, String poste, String gmail, Date birth) {
        this.id = id;
        this.cin = cin;
        this.phone = phone;
        this.nomprenom = nomprenom;
        this.sexe = sexe;
        this.dept = dept;
        this.poste = poste;
        this.gmail = gmail;
        this.birth = birth;
    }
    
 
        public Employe( int cin,  int phone, String nomprenom, String sexe, String dept, String poste, String gmail, Date date) {
    
        this.cin = cin;
        this.phone = phone;
        this.nomprenom = nomprenom;
        this.sexe = sexe;
        this.dept = dept;
        this.poste = poste;
        this.gmail = gmail;
        this.birth = date;
    }
    
        
           public Employe( int cin,  int phone, String nomprenom, String sexe, String dept, String poste, String gmail, Date date,String image) {
    
        this.cin = cin;
        this.phone = phone;
        this.nomprenom = nomprenom;
        this.sexe = sexe;
        this.dept = dept;
        this.poste = poste;
        this.gmail = gmail;
        this.birth = date;
        this.image = image;
    }
    
      // cin,nomprenom,gmail,phonenumber,birthdate,sexe,poste,departement,image 
      
             
    public Employe(int cin, String nomprenom, String gmail, String poste,Double salary,Date date) {
    
        this.cin = cin;
        this.nomprenom = nomprenom;
        this.gmail = gmail;
        this.poste = poste;
        this.salary = salary;
        this.date = date;
       
    }
    
    
    public Employe(  int cin, String nomprenom, String gmail, int phone, Date birth, String sexe, String poste, String dept,String image) {
    
        this.cin = cin;
         this.nomprenom = nomprenom;
         this.gmail = gmail;
        this.phone = phone;
       this.birth = birth;
        this.sexe = sexe;
        this.poste = poste;
        this.dept = dept;
        this.image = image;
    }
    
        public Employe( int cin, String nomprenom, String gmail , Date birth,int phone,  String sexe, String poste, String dept,  String image) {
    
        this.cin = cin;
        this.phone = phone;
        this.nomprenom = nomprenom;
        this.sexe = sexe;
        this.dept = dept;
        this.poste = poste;
        this.gmail = gmail;
        this.birth = birth;
        this.image = image ;
    }
    
        
         public Employe( int cin, String nomprenom) {
    
        this.cin = cin;
        this.nomprenom = nomprenom;
      
    }
    

   

    public Employe() {
    }


   
   

   

    

   

  

   

    public int getId() {
        return id;
    }

    public int getCin() {
        return cin;
    }

    public int getPhone() {
        return phone;
    }

    public String getNomprenom() {
        return nomprenom;
    }

    public String getSexe() {
        return sexe;
    }

    public String getDept() {
        return dept;
    }

    public String getPoste() {
        return poste;
    }

    public String getGmail() {
        return gmail;
    }

    public Date getBirth() {
        return birth;
    }
    
    public String getImage() {
        return image;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setNomprenom(String nomprenom) {
        this.nomprenom = nomprenom;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
 public void setImage(String image) {
        this.gmail = image;
    }

  public Double getSalary(){
        return salary;
    }
    @Override
    public String toString() {
        return "Employe{" + "id=" + id + ", cin=" + cin + ", phone=" + phone + ", nomprenom=" + nomprenom + ", sexe=" + sexe + ", dept=" + dept + ", poste=" + poste + ", gmail=" + gmail + ", birth=" + birth + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.id;
        hash = 83 * hash + this.cin;
        hash = 83 * hash + this.phone;
        hash = 83 * hash + Objects.hashCode(this.nomprenom);
        hash = 83 * hash + Objects.hashCode(this.sexe);
        hash = 83 * hash + Objects.hashCode(this.dept);
        hash = 83 * hash + Objects.hashCode(this.poste);
        hash = 83 * hash + Objects.hashCode(this.gmail);
        hash = 83 * hash + Objects.hashCode(this.birth);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employe other = (Employe) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.cin != other.cin) {
            return false;
        }
        if (this.phone != other.phone) {
            return false;
        }
        if (!Objects.equals(this.nomprenom, other.nomprenom)) {
            return false;
        }
        if (!Objects.equals(this.sexe, other.sexe)) {
            return false;
        }
        if (!Objects.equals(this.dept, other.dept)) {
            return false;
        }
        if (!Objects.equals(this.poste, other.poste)) {
            return false;
        }
        if (!Objects.equals(this.gmail, other.gmail)) {
            return false;
        }
        if (!Objects.equals(this.birth, other.birth)) {
            return false;
        }
        return true;
    }


 


    
    
}
