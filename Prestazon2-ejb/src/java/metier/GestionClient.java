/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import controllers.ClientFacade;
import entities.Client;
import entities.Compte;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author 21303936
 */
@Stateless
@LocalBean
public class GestionClient {

        @EJB 
        ClientFacade clientFacade;
    public void creerClient(String nom, String prenom) {
        Client c = new Client();
        c.setNom(nom);
        c.setPrenom(prenom);
        clientFacade.create(c);
    }
    
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
      
    public void creerClient(String nom, String prenom, Compte compte) {
        Client c = new Client();
        c.setNom(nom);
        c.setPrenom(prenom);      
        clientFacade.create(c);
        c.getCompteCollection().add(compte);
    }
    
    
    public void ajouterCompte(Client client, Compte compte) {
        Client c = clientFacade.find(client);
        c.getCompteCollection().add(compte);
    }
    
    
    
    
}
