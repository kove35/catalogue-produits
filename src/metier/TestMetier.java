package metier;

import java.util.List;

public class TestMetier {

    public static void main( String[] args ) {
        IcatalogueMetier metier = new CatalogueMetierImpl();

        /*
         * metier.addProduit( new Produit( "REF05", "AA", 870, 3 ) );
         * metier.addProduit( new Produit( "REF06", "BB", 345, 12 ) );
         * metier.addProduit( new Produit( "REF07", "CC", 65, 3 ) );
         * metier.addProduit( new Produit( "REF08", "DD", 970, 3 ) );
         * metier.addProduit( new Produit( "REF09", "EE", 3445, 12 ) );
         * metier.addProduit( new Produit( "REF010", "FF", 125, 9 ) );
         */

        System.out.println( "----------------------------------------" );
        List<Produit> prods = metier.listProduits();
        for ( Produit p : prods ) {
            System.out.println( p.getDesignation() );
        }
        System.out.println( "------------------------------------------" );

        /*
         * List<Produit> prods2=metier.produitsParMC("AA"); for(Produit
         * p:prods2) { System.out.println(p.getDesignation()); }
         * System.out.println("-----------------------------------------"); try
         * { Produit p2=metier.getProduit("REF013");
         * System.out.println(p2.getDesignation());
         * 
         * } catch (Exception e) { System.out.println(e.getMessage()); }
         * System.out.println("-----------------------------------------"); try
         * { Produit p2=metier.getProduit("REF010"); p2.setPrix(9000);
         * //metier.updateProduit(p2); System.out.println(p2.getDesignation());
         * System.out.println(p2.getPrix());
         * 
         * } catch (Exception e) { System.out.println(e.getMessage()); }
         * System.out.println("-----------------------------------------");
         * metier.deleteProduit("REF010");
         */

    }
}
