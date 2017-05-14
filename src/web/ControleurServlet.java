package web;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.CatalogueMetierImpl;
import metier.Produit;

public class ControleurServlet extends HttpServlet {
	
	CatalogueMetierImpl metier;
	@Override
	public void init() throws ServletException{
		metier=new CatalogueMetierImpl();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProduitModel model=new ProduitModel();
		request.setAttribute("model", model);
		String action=request.getParameter("action");
		
		if(action !=null){
			if(action.equals("chercher")){
				model.setMotCle(request.getParameter("motCle"));
				List<Produit> produits=metier.produitsParMC(model.getMotCle());
				model.setProduits(produits);
				
			}
			else if(action.equals("delete")){
				String ref=request.getParameter("ref");
				metier.deleteProduit(ref);
				model.setProduits(metier.listProduits());
			}
			else if(action.equals("editer")){
				String ref=request.getParameter("ref");
				Produit p=metier.getProduit(ref);
				model.setProduit(p);
				model.setMode("edit");
				model.setProduits(metier.listProduits());
			
			}
			
			else if(action.equals("save")){
				model.getProduit().setReference(request.getParameter("reference"));
				model.getProduit().setDesignation(request.getParameter("designation"));
				model.getProduit().setPrix(Double.parseDouble(request.getParameter("prix")));
				model.getProduit().setQuantite(Integer.parseInt(request.getParameter("quantite")));
				model.setMode(request.getParameter("mode"));
				
					if(model.getMode().equals("ajout")){
					metier.addProduit(model.getProduit());
					}
					else if(model.getMode().equals("edit")){
						metier.updateProduit(model.getProduit());
						}
			   model.setProduits(metier.listProduits());
			}
		}
		
		
		
		
		//request.getRequestDispatcher("vueProduits.jsp").forward(request, response);
		this.getServletContext().getRequestDispatcher("/vueProduits.jsp").forward(request,response);
		
	}
	
}
