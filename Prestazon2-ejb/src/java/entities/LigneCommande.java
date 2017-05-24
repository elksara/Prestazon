/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 21303936
 */
@Entity
@Table(name = "LIGNE_COMMANDE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LigneCommande.findAll", query = "SELECT l FROM LigneCommande l")
    , @NamedQuery(name = "LigneCommande.findByIdLignecommande", query = "SELECT l FROM LigneCommande l WHERE l.idLignecommande = :idLignecommande")
    , @NamedQuery(name = "LigneCommande.findByQuantite", query = "SELECT l FROM LigneCommande l WHERE l.quantite = :quantite")})
public class LigneCommande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_LIGNECOMMANDE")
    private Integer idLignecommande;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITE")
    private int quantite;
    @JoinColumn(name = "IDCOMMANDE", referencedColumnName = "IDCOMMANDE")
    @ManyToOne
    private Commande idcommande;
    @JoinColumn(name = "REFERENCE", referencedColumnName = "REFERENCE")
    @ManyToOne
    private Produit reference;

    public LigneCommande() {
    }

    public LigneCommande(Integer idLignecommande) {
        this.idLignecommande = idLignecommande;
    }

    public LigneCommande(Integer idLignecommande, int quantite) {
        this.idLignecommande = idLignecommande;
        this.quantite = quantite;
    }

    public Integer getIdLignecommande() {
        return idLignecommande;
    }

    public void setIdLignecommande(Integer idLignecommande) {
        this.idLignecommande = idLignecommande;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Commande getIdcommande() {
        return idcommande;
    }

    public void setIdcommande(Commande idcommande) {
        this.idcommande = idcommande;
    }

    public Produit getReference() {
        return reference;
    }

    public void setReference(Produit reference) {
        this.reference = reference;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLignecommande != null ? idLignecommande.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LigneCommande)) {
            return false;
        }
        LigneCommande other = (LigneCommande) object;
        if ((this.idLignecommande == null && other.idLignecommande != null) || (this.idLignecommande != null && !this.idLignecommande.equals(other.idLignecommande))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.LigneCommande[ idLignecommande=" + idLignecommande + " ]";
    }
    
}
