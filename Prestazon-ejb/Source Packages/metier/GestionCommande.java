/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import controllers.ClientFacade;
import controllers.CommandeFacade;
import controllers.LigneCommandeFacade;
import entities.Client;
import entities.Commande;
import entities.LigneCommande;
import entities.Produit;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Sara
 */
@Stateless
@LocalBean
public class GestionCommande {
    
    @EJB 
    ClientFacade clientFacade;
    CommandeFacade commandeFacade;
    LigneCommandeFacade ligneCommandeFacade;
    

    public void creerCommande(Date date, String etat, Client idClient) {
        Commande c = new Commande();
        c.setDatecommande(date);
        c.setEtatcommande("En cours");
        c.setIdclient(idClient);
        commandeFacade.create(c);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public Commande chercherCommande(int idCommande) {
        Commande c = commandeFacade.find(idCommande);
        if (c != null){
            return c;
        }else {
            return null;
        }
    }
    
    public Collection listeCommandes(Client client){
        Client c = clientFacade.find(client);
        List<Commande> listeCommande = commandeFacade.findAll();
        List<Commande> listeC = null;
        for (Commande o : listeCommande){
            if (o.getIdclient().getIdclient() == client.getIdclient()){
                listeC.add(o);
            }
        }
        return listeC;
    }
    
    public Collection listeProduits(Commande commande){
        Commande c = commandeFacade.find(commande);
        Collection<LigneCommande> liste = c.getLigneCommandeCollection();
        Collection<Produit> res = null;
        for (LigneCommande lc : liste){
            res.add(lc.getReference());
        }
        return res;
    }
    
    public void gererQuantiteProduit(Commande c, Produit p, int q){
        Commande commande = commandeFacade.find(c);
        Collection<LigneCommande> lc = c.getLigneCommandeCollection();
        for (LigneCommande l : lc){
            if(ligneCommandeFacade.find(l).getReference().equals(p)){
                l.setQuantite(q);
            }
        }
    }
    
   public Commande consulterCommande(int idClient){
       Commande commande = commandeFacade.find(idClient);
       return commande;
   }
   
   public void produitsDisponibles(int idcommande){
       Commande c = commandeFacade.find(idcommande);
       c.setEtatcommande("Disponible");           
   }
   
   public float getSommePanier(Commande idCommande){
       Float total = (float) 0;
       Commande c = commandeFacade.find(idCommande);
       Collection<LigneCommande> lc = c.getLigneCommandeCollection();
        for (LigneCommande l : lc){
            total = total + l.getReference().getPrixu();
        }
        return total ;
   }
}
