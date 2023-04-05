
<head>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.9.2/html2pdf.bundle.min.js"></script>
    <link rel="stylesheet" href="public/bootstrap.min.css">
	<link rel="stylesheet" href="public/bootstrap.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>

<body>
<div class="jumbotron text-center">
  <div class="container">
  <h2>Panels with Contextual Classes</h2>
  <div class="panel-group">

    <div class="panel panel-primary">
      <div class="panel-heading">
     
      <button type="submit" name="action" value="imprimer" class="btn  btn-default"  id="print-button">Imprimer</button>
      <button type="submit" name="action" value="imprimer1" class="btn  btn-default" ">Imprimer1</button>
     
      </div>
      <div class="panel-body">
					<div class="container">
						<div class="row" style="background-color: #540759; top: 450px;border-radius: 10px;">
							<div class="col-4" style="background-color: #540759; top: 450px;border-radius: 10px;">
							 <table class="table text-white">
							 <tr>
							 <th><strong>Prenom: ${cv.firstname}</strong><br></th>
							 </tr>
							 <tr>
							 <th><strong>Nom: ${cv.lastname}</strong><br></th>
							 </tr>
							 <tr>
							 <th><strong>Address: ${cv.adresse}</strong><br></th>
							 </tr>
							 </table>
							</div>
							<div class="col-8" style="background-color: #540759; top: 450px;border-radius: 10px;">
								<table class="table text-white">
								<tr><th align="right"><strong >Age: </strong> ${cv.age} ans<br></th></tr>
								<tr><th><strong>Email:</strong> ${cv.email}<br></th></tr>
								</table>
							</div>
							
						</div>
						<div class="row mt-2">
							<div class="col-4 text-warning" style="background-color: #015D53;">specialite</div>
							<div class="col-8">
							<table class="table table-striped">
								<tr><td>${cv.specialite}<br></td></tr>
							</table>
							</div>
						</div>
						
						<div class="row mt-2">
							<div class="col-4"style="background-color:pink;">niveauEtude</div>
							<div class="col-8">
							<table class="table table-striped">
								<tr><td>${cv.niveauEtude}<br></td></tr>
							</table>
							</div>
						</div>
						
						<div class="row mt-2">
							<div class="col-4"style="background-color:pink;">experienceProfessionnelle</div>
							<div class="col-8">
							<table class="table table-striped">
								<tr><td>${cv.experienceProfessionnelle}<br></td></tr>
							</table>
							</div>
						</div>
						
					</div>
				</div>
    </div>

  </div>
</div>
</div>
<!-- scripte pour generer un pdf apartire de la page jsp  -->
 <script>
        var printButton = document.getElementById("print-button");
        printButton.addEventListener("click", function() {
            
        	// Supprimez le bouton "Imprimer" de la copie HTML
        	  var noPrintElements = document.querySelectorAll(".btn");
        	  for (var i = 0; i < noPrintElements.length; i++) {
        	    noPrintElements[i].parentNode.removeChild(noPrintElements[i]);
        	  }
            // Convertir la page en PDF
            html2pdf().from(document.body).save();
        });
 </script>
 <!-- scripte pour generer un pdf apartire de la page jsp  -->
</body>




 