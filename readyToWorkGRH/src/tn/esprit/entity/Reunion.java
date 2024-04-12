import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Reunion {
    private String nom;
    private LocalDateTime dateHeure;
    private List<String> participants;

    // Constructeur
    public Reunion(String nom, LocalDateTime dateHeure) {
        this.nom = nom;
        this.dateHeure = dateHeure;
        this.participants = new ArrayList<>();
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public LocalDateTime getDateHeure() {
        return dateHeure;
    }

    public List<String> getParticipants() {
        return participants;
    }

    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDateHeure(LocalDateTime dateHeure) {
        this.dateHeure = dateHeure;
    }

    // Méthode pour ajouter un participant
    public void ajouterParticipant(String participant) {
        this.participants.add(participant);
    }
    // Méthode pour supprimer tous les participants
    public void supprimerTousLesParticipants() {
        this.participants.clear();
    }
     // Méthode pour supprimer un participant spécifique
    public void supprimerParticipant(String participant) {
        this.participants.remove(participant);
    }

    // Méthode pour afficher les détails de la réunion
    public void afficherDetails() {
        System.out.println("Nom de la réunion: " + nom);
        System.out.println("Date et heure: " + dateHeure);
        System.out.println("Participants: " + participants);
        //System.out.println("Details are done");
    }

  
}
