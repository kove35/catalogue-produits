<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<script type="text/javascript">
	function confirmer(url){
		var rep=confirm("Etes vous sûre de vouloir supprimer?");
		if (rep==true){
			document.location=url; 
		}
	}
</script>
</head>
<body>
	
		<div>
			<form class="form" method="post" action="controleur.php">
					<p>
						
						<input  type="text" id="Mot_cle" name="motCle" placeholder="entrez le mot clé">
						<input  type="submit" value="chercher"  name="action" >
					</p>
			</form>
		</div>
		<div>
		 <form class="form" method="post" action="controleur.php">
		 <input type="hidden" name="mode" value="${model.mode }" />
			<p>Ajouter un nouveau produit</p>
			
			<c:if test="${model.mode=='ajout' }">
			<p>
				<label for ="reference" > REF :</label>
				<input type="text" name="reference" value="${model.produit.reference }" />
				
			</p>
			</c:if>
			<c:if test="${model.mode=='edit'}">
			 <label for ="reference" > REF :</label>
				<input type="hidden" name="reference" value="${model.produit.reference }" />
				<p>${model.produit.reference }</p>
			</c:if>
			<p>
				<label for ="designation">DESIGNATION :</label>
				<input type="text" name="designation" value="${model.produit.designation }"/>
				
			</p>
			<p>
				<label for ="prix">PRIX :</label>
				<input type="text" name="prix" value="${model.produit.prix }"/>
				
			</p>
			<p>
				<label for ="quantite">QUANTITE :</label>
				<input type="text" name="quantite" value="${model.produit.quantite }"/>
				
			</p>
			<p>
				<input  type="submit" name="action" value="save">
			</p>
			</form>
		</div>
		<div>
			<table class="table2">
				<tr>
					<th>REF</th><th>DES</th><th>PRIX</th><th>QUANTITE</th>
				</tr>	
				<c:forEach items="${model.produits}" var="p">
					<tr>
						<td>${p.reference}</td>
						<td>${p.designation}</td>
						<td>${p.prix}</td>
						<td>${p.quantite}</td>
						<td><a href="javascript:confirmer('Controleur.php?action=delete&ref=${p.reference }')"></>Supprimer </a></td>
						<td><a href="Controleur.php?mode=edit&action=editer&ref=${p.reference }"></>Editer </a></td>
					</tr>
				</c:forEach>
			</table>
			
		</div>
	

</body>
</html>