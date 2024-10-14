/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author Pc
 */
@Entity
public class Homme extends Personne {
    @ManyToMany(mappedBy = "homme")
    private List<Mariage> mariages;

    public Homme() {
    }

    public Homme(String nom, String prenom, String telephone, Date dateNaissance) {
        super(nom, prenom, telephone, dateNaissance);
    }

 
}