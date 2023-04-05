<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="public/bootstrap.min.css">
<link rel="stylesheet" href="public/bootstrap.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>espacecandidat</title>
</head>
<body>
	
	<div class="jumbotron text-center" style="background-color: #06668C">
		<h1>Bienvenue</h1>
		<p class="font-weight-bold " style="color: white;">${ sessionScope.firstname }
			${ sessionScope.lastname }</p>
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-8">
				<c:if test="${not empty errorremplir}">
					<div id="alert" class="alert alert-danger">${errorremplir}</div>
				</c:if>
			</div>
			<div class="col-sm-8">
				<c:if test="${not empty success}">
					<div id="alert" class="alert alert-light">${success}</div>
				</c:if>
			</div>
		</div>

	</div>

	<div class="container">
		<div class="row bg-secondary">
			<div class="col-8 mt-4 bg-secondary"
				style="background: url('public/media/jobcandidat.jpg'); background-size: 800px 500px; background-repeat: no-repeat;">
				<div class="col-sm-4">
					<div class="card bg-secondary mb-3"
						style="max-width: 20rem; background-color: #EB9F04">
						<div class="card-header"
							style="max-width: 20rem; background-color: #EB9F04">OFFRES
							FAVORIS</div>
						<div class="card-body"></div>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="card bg-secondary mb-3" style="max-width: 20rem;">
						<div class="card-header  bg-success">OFFRES FAVORIS</div>
						<div class="card-body"></div>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="card bg-secondary mb-3" style="max-width: 20rem;">
						<div class="card-header  bg-primary">OFFRES FAVORIS</div>
						<div class="card-body"></div>
					</div>
				</div>
			</div>

			<div class="col-4 mt-4" style="background-color: #a37f07">

				<div class="list-group mt-2">
					<a href="#"
						class="btn btn-outline-secondary list-group-item list-group-item-action  mb-2"
						style="background-color: #edb232; color: white;"
						data-toggle="modal" data-target="#myModalCV"><i class="glyphicon glyphicon-pencil" style=" font-size: 20px;color:white;"> Créer mon CV</i></a> <a
						href="#"
						class="btn btn-outline-secondary  list-group-item list-group-item-action  mb-2"
						style="background-color: #edb232; color: white;">Les offres
						d'emploi</a>
						<a href="#" class="btn btn-outline-secondary  list-group-item list-group-item-action  mb-2"
						style="background-color: #8BA503; color: white;"><span class="glyphicon glyphicon-cog"></span> &nbsp;Gérer mon CV</a>
					<a href="#"
						class="btn btn-outline-secondary  list-group-item list-group-item-action  mb-2"
						style="background-color: #edb232; color: white;">Gérer mon Profil</a>
						<form action="candidat" method="post">
						  <button type="submit" name="action" value="report" class="btn btn-outline-secondary  list-group-item list-group-item-action  mb-2" style="background-color: #edb232; color: white;text-align: center;">
						  <i class="glyphicon glyphicon-eye-open" style="color:white"></i>&nbsp;Voir Cv </button>
						</form>
						<form action="Logout" method="get">
						<a type="submit" class="btn btn-outline-secondary  list-group-item list-group-item-action " style="background-color: #BD3100; color: white;">Déconnexion</a>
						</form>
				</div>
			</div>
			<!-- modales pour creation cv  -->
			<!-- Modal -->
			<div class="modal fade" id="myModalCV" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog modal-dialog-scrollable">
					<div class="modal-content">
						<!-- Modal Header -->
						<div class="modal-header" style="background-color: #540759;">
							<img id="image-1" alt="" src="public/media/acc_candidats1.jpg" />
						</div>

						<!-- Modal Body -->
						<div class="modal-body">
							<form class="form-horizontal" role="form" action="candidat"
								method="post">
								<table class="table table-hover">
									<tr class="form-group" style="margin-bottom: 30px;">
										<td>Prenom:</td>
										<td class="col-sm-10"><input type="text" name="firstname"
											class="form-control" id="inputEmail3" placeholder="firstname" /></td>
									</tr>
									<tr class="form-group">
										<td>Nom:</td>
										<td class="col-sm-10"><input type="text" name="lastname"
											class="form-control" id="inputEmail3" placeholder="lastname" /></td>
									</tr>
									<tr class="form-group">
										<td>Email:</td>
										<td class="col-sm-10"><input type="email" name="email"
											class="form-control" id="inputEmail3" placeholder="email" /></td>
									</tr>
									<tr class="form-group">
										<td>Address:</td>
										<td class="col-sm-10"><input type="text" name="address"
											class="form-control" id="inputEmail3" placeholder="address" /></td>
									</tr>
									<tr class="form-group">
										<td>Age:</td>
										<td class="col-sm-10"><input type="number" name="age"
											class="form-control" id="inputEmail3" placeholder="age" /></td>
									</tr>
									<tr class="form-group">
										<td>Spécialité:</td>
										<td class="col-sm-10"><input type="text"
											name="specialite" class="form-control" id="inputEmail3"
											placeholder="Prenom" /></td>
									</tr>
									<tr class="form-group">
										<td>NiveauEtude:</td>
										<td class="col-sm-10"><input type="text"
											name="niveauetude" class="form-control" id="inputEmail3"
											placeholder="Prenom" /></td>
									</tr>
									<tr class="form-group">
										<td>ExperienceProfessionnelle:</td>
										<td class="col-sm-10"><textarea class="form-control"
												name="experience" id="message-text"></textarea></td>
									</tr>
								</table>
								<!-- Modal Footer -->
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Close</button>
									<button type="submit" name="action" value="enregistrerCv"
										class="btn" style="background-color: #015D53; color: white;">Enregistrer</button>
								</div>
							</form>
						</div>
						<!-- modales pour creation cv  -->
					</div>
				</div>
				<!-- partie ofrre  -->
				<div class="row">
					<div class="col-sm-8 bg-secondary">
						<ul class="list-group alert alert-success">
							<li
								class="list-group-item d-flex justify-content-between align-items-center ">
								Cras justo odio <span class="badge bg-danger">66</span>
							</li>
							<li
								class="list-group-item d-flex justify-content-between align-items-center">
								Dapibus ac facilisis in <span class="badge bg-danger">77</span>
							</li>
							<li
								class="list-group-item d-flex justify-content-between align-items-center">
								Morbi leo risus <span class="badge bg-danger">5</span>
							</li>
						</ul>
					</div>
					<!-- partie ofrre  -->
					<div class="col-sm-4">col-sm-4</div>
				</div>
			</div>

			<script type="text/javascript">
				setTimeout(function() {

					// Closing the alert
					$('#alert').alert('close');
				}, 5000);
			</script>
</body>
</html>