/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 *
 * @author Pc
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "nbrEnfentBetweenDates",
        query = "SELECT COUNT(*) FROM Mariage m " +
                "WHERE m.id = :idFemme " +
                "AND m.dateDebut BETWEEN :dateDebut AND :dateFin"
    )
})


public class Femme extends Personne {
    

    public Femme(List<Mariage> mariages) {
        this.mariages = mariages;
    }

   /* public Femme(List<Mariage> mariages, String nom, String prenom, String telephone, Date dateNaissance) {
        super(nom, prenom, telephone, dateNaissance);
        this.mariages = mariages;
    } /
    */

    public Femme() {
    }

    public Femme(String nom, String prenom, String telephone, Date dateNaissance) {
        super(nom, prenom, telephone, dateNaissance);
    }

    @OneToMany(mappedBy = "femmes")
    private List<Mariage> mariages;
    
    
}