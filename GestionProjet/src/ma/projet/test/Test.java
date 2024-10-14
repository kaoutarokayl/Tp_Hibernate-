/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.util.Date;
import java.util.List;
import ma.projet.classes.Tache;
import ma.projet.service.TacheService;

/**
 *
 * @author Pc
 */
public class Test {
    public static void main(String[] args) {
        TacheService ts = new TacheService();
        ts.create(new Tache("Maintenance", new Date(12/10/2024), new Date(20/10/2024), 3000));
        ts.create(new Tache("Controle", new Date(12/10/2024), new Date(12/11/2024),2500));
        ts.create(new Tache("ServiceInformation", new Date(12/10/2024), new Date(15/10/2024),1000));
        List<Tache> taches = ts.getTachesPrixSup1000();
        if (taches != null) {
            for (Tache tache : taches) {
                System.out.println("Tâche : " + tache.getNom() + ", Prix : " + tache.getPrix());
            }
        } else {
            System.out.println("Aucune tâche trouvée.");
        }
    }
}

