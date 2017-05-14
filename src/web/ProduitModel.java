package web;

import java.util.ArrayList;
import java.util.List;

import metier.Produit;

public class ProduitModel {
	private String motCle;
	Produit produit=new Produit();
	List<Produit> produits=new ArrayList<Produit>();
	private String mode="ajout";
	
	
	
	public String getMotCle() {
		return motCle;
	}
	
	public List<Produit> getProduits() {
		return produits;
	}
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
		
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}
	
	

}
