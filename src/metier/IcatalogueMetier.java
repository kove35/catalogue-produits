package metier;

import java.util.List;

public interface IcatalogueMetier {
	public void addProduit(Produit p);
	public List<Produit> listProduits();
	public List<Produit> produitsParMC(String mc);
	public Produit getProduit(String ref);
	public void updateProduit(Produit p);
	public void deleteProduit(String ref);
	

}
