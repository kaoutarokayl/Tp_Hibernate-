    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.util.Date;
import java.util.List;
import ma.projet.classes.Categorie;
import ma.projet.classes.Commande;
import ma.projet.classes.LigneCommandeProduit;
import ma.projet.classes.Produit;
import ma.projet.service.CategorieService;
import ma.projet.service.CommandeService;
import ma.projet.service.LigneCommandeProduitService;
import ma.projet.service.ProduitService;

public class Test {
   public static void main(String[] args) {
    // Création d'une catégorie
    Categorie categorie = new Categorie();
    categorie.setCode("CAT001");
    categorie.setLibelle("Informatique");

    // Instanciation du service CategorieService
    CategorieService categorieService = new CategorieService();

    // Sauvegarde de la catégorie
    if (categorieService.create(categorie)) {
        System.out.println("Catégorie enregistrée avec succès : " + categorie.getLibelle());
    } else {
        System.out.println("Erreur lors de l'enregistrement de la catégorie.");
    }

    // Création d'un produit
    Produit produit = new Produit();
    produit.setReference("  ES12");
    produit.setPrix(120);
    produit.setCategorie(categorie); // Assurez-vous que la catégorie est persistée avant de l'associer au produit
 
    produit.setReference("  ZR85");
    produit.setPrix(100);
    produit.setCategorie(categorie); // Assurez-vous que la catégorie est persistée avant de l'associer au produit
    produit.setReference("  EE85");
    produit.setPrix(200);
    produit.setCategorie(categorie); // Assurez-vous que la catégorie est persistée avant de l'associer au produit


    // Création d'une commande
    Commande commande = new Commande();
    commande.setDate(new Date());

    // Création d'une ligne de commande pour le produit
    LigneCommandeProduit ligneCommandeProduit = new LigneCommandeProduit();
    ligneCommandeProduit.setQuantite(7);
        ligneCommandeProduit.setQuantite(14);
    ligneCommandeProduit.setQuantite(5);

    ligneCommandeProduit.setProduit(produit);
    ligneCommandeProduit.setCommande(commande);

    // Instanciation des services
    ProduitService produitService = new ProduitService();
    CommandeService commandeService = new CommandeService();
    LigneCommandeProduitService ligneCommandeProduitService = new LigneCommandeProduitService();

    // Sauvegarde du produit
    if (produitService.create(produit)) {
        System.out.println("Produit enregistré avec succès : " + produit.getReference());
    } else {
        System.out.println("Erreur lors de l'enregistrement du produit.");
    }

    // Sauvegarde de la commande
    if (commandeService.create(commande)) {
        System.out.println("Commande enregistrée avec succès : " + commande.getId());
    } else {
        System.out.println("Erreur lors de l'enregistrement de la commande.");
    }

    // Sauvegarde de la ligne de commande
    if (ligneCommandeProduitService.create(ligneCommandeProduit)) {
        System.out.println("Ligne de commande enregistrée avec succès.");
    } else {
        System.out.println("Erreur lors de l'enregistrement de la ligne de commande.");
    }
// Question 4 : Afficher les produits commandés entre deux dates
        Date dateDebut = new Date(); // Remplacez par votre date de début
        Date dateFin = new Date(); // Remplacez par votre date de fin
        afficherProduitsEntreDates(dateDebut, dateFin, commandeService);

        // Question 5 : Afficher les produits dans une commande donnée
        int commandeId = 4; // ID de la commande
        afficherProduitsDansCommande(commandeId, commandeService);

        // Question 6 : Afficher les produits avec un prix supérieur à 100 DH
        afficherProduitsAvecPrixSuperieur(100, produitService);
    }

    private static void afficherProduitsEntreDates(Date dateDebut, Date dateFin, CommandeService commandeService) {
        List<Produit> produits = commandeService.getProduitsEntreDates(dateDebut, dateFin);
        System.out.println("Produits commandés entre " + dateDebut + " et " + dateFin + ":");
        for (Produit produit : produits) {
            System.out.println("Référence: " + produit.getReference() + ", Prix: " + produit.getPrix() + " DH");
        }
    }

    private static void afficherProduitsDansCommande(int commandeId, CommandeService commandeService) {
        List<Produit> produits = commandeService.getProduitsParCommande(commandeId);
        System.out.println("Produits dans la commande ID " + commandeId + ":");
        for (Produit produit : produits) {
            System.out.println("Référence: " + produit.getReference() + ", Prix: " + produit.getPrix() + " DH");
        }
    }

    private static void afficherProduitsAvecPrixSuperieur(double prixLimite, ProduitService produitService) {
        List<Produit> produits = produitService.getProduitsAvecPrixSuperieur(prixLimite);
        System.out.println("Produits avec un prix supérieur à " + prixLimite + " DH:");
        for (Produit produit : produits) {
            System.out.println("Référence: " + produit.getReference() + ", Prix: " + produit.getPrix() + " DH");
        }
        
    }
    
}