/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.LigneCommande;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 21303936
 */
@Local
public interface LigneCommandeFacadeLocal {

    void create(LigneCommande ligneCommande);

    void edit(LigneCommande ligneCommande);

    void remove(LigneCommande ligneCommande);

    LigneCommande find(Object id);

    List<LigneCommande> findAll();

    List<LigneCommande> findRange(int[] range);

    int count();
    
}
