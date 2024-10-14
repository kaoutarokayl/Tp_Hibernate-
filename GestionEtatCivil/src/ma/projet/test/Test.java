/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.util.Date;
import java.util.List;
import ma.projet.beans.Femme;
import ma.projet.beans.Homme;
import ma.projet.service.FemmeService;
import ma.projet.service.HommeService;

/**
 *
 * @author Pc
 */
public class Test {
     public static void main(String[] args) {
         FemmeService fs = new FemmeService(); 
         HommeService hs = new HommeService();
         
            fs.create(new Femme("f1","a","0606060606",new Date(8/8/1999)));
            fs.create(new Femme("f2","b","0612345678",new Date(24/2/1991)));
            fs.create(new Femme("f3","c","0678965432",new Date(30/3/1992)));
            fs.create(new Femme("f4","d","0673892622",new Date(27/5/1992)));
            fs.create(new Femme("f5","e","0698476444",new Date(22/1/1993)));
            fs.create(new Femme("f6","f","0674883883",new Date(7/2/1994)));
            fs.create(new Femme("f7","g","0647474839",new Date(3/7/1995)));
            fs.create(new Femme("f8","h","0693884766",new Date(10/6/1996)));
            fs.create(new Femme("f9","i","0673883826",new Date(31/12/1997)));
            fs.create(new Femme("f10","j","0637738382",new Date(9/10/1998)));
            hs.create(new Homme("h1","k","0673635437",new Date(11/3/1989)));
            hs.create(new Homme("h2","l","0657849383",new Date(26/9/1988)));
            hs.create(new Homme("h3","m","0674833287",new Date(17/4/1989)));
            hs.create(new Homme("h4","n","0637383827",new Date(23/9/1990)));
            hs.create(new Homme("h5","o","0637328283",new Date(9/8/1990)));
         
         List<Femme> femmes = fs.getAll();
            if (femmes != null) {
                for (Femme femme : femmes) {
                    System.out.println("ID : " + femme.getId());
                    System.out.println("NOM : " + femme.getNom());
                    System.out.println("PRENOM : " + femme.getPrenom());
                    System.out.println("TELEPHONE : " + femme.getTelephone());
                    System.out.println("DATE : " + femme.getDateNaissance());
                    
                    System.out.println("*****");
                }
            } else {
                System.out.println("Aucun femme trouvé.");
            }
            
          // Afficher la femme la plus âgée
        Femme femmeAgee = femmes.stream().min((f1, f2) -> f1.getDateNaissance().compareTo(f2.getDateNaissance())).orElse(null);
        
        System.out.println("Femme la plus âgée : " + (femmeAgee != null ? femmeAgee.getNom() : "Aucune femme"));
   
            
            
         
         
         
         
         
         
         
         
         
         
         
         
}
}