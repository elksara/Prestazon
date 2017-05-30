/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import controllers.ProduitFacade;
import entities.Produit;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author ngey
 */
@Stateless
public class GestionProduit implements GestionProduitLocal {

    @EJB
    private ProduitFacade produitFacade;

    @Override
    public void creerProduit(String type, String libelle, String description, float prixU, boolean estAffiche) {
        //Créée le nouveau Produit
        Produit p = new Produit();
        
        //set tous les attributs
        p.setType(type);
        p.setDescription(description);
        p.setEstaffiché(estAffiche);
        p.setLibelle(libelle);
        p.setPrixu(prixU);
        
    }

    @Override
    public Produit chercherProduit(String libelle) {
        return produitFacade.find(libelle);
    }

    @Override
    public List<Produit> listeProduit() {
        List<Produit> l =  produitFacade.findAll();
        return l;
    }

    @Override
    public void setQuantiteDisponible(Produit p, int q) {
        int qte = p.getQuantite();
        p.setQuantite(qte + q);
    }
    
    
}
