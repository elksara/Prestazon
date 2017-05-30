/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import entities.Produit;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ngey
 */
@Local
public interface GestionProduitLocal {

    void creerProduit(String type, String libelle, String description, float prixU, boolean estAffiche);

    Produit chercherProduit(String libelle);

    List<Produit> listeProduit();

    void setQuantiteDisponible(Produit p, int q);
    
}
