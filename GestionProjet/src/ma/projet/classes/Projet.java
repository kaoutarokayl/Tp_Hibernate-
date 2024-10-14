/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Pc
 */
@Entity

public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int id;

    @Column(name = "nom")
    private String nom;

   @Temporal(TemporalType.DATE)
    private Date dateDebut;

   @Temporal(TemporalType.DATE)
    private Date dateFin;
   
    @ManyToOne
    @JoinColumn(name = "chef_projet_id")
    private Employe chefProjet;
    
     @OneToMany(mappedBy = "projet")
    private List<Tache> taches;
     
    public Projet() {
    }

    public Projet(String nom, Date dateDebut, Date dateFin) {
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
    
   public void afficherTachesRealisees() {
    System.out.println("Projet : " + id + " Nom : " + nom + " Date début : " + dateDebut);
    System.out.println("Liste des tâches réalisées:");

    // Parcourez la liste des tâches du projet
    for (Tache tache : taches) {
        if (tache.getDateDebutReelle() != null && tache.getDateFinReelle() != null) {
            System.out.println("Num " + tache.getId() + " Nom " + tache.getNom() + " Date Début Réelle "
                    + tache.getDateDebutReelle() + " Date Fin Réelle " + tache.getDateFinReelle());
        }
    }
}
 

}