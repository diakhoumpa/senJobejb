<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="public/bootstrap.min.css">
<link rel="stylesheet" href="public/bootstrap.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>


	<div class="container-fluid" style="background-color: #015D53;">

		<div class="jumbotron"
			style="background-image: url('public/media/sen.jpg'); background-size: 1400px 400px; background-repeat: no-repeat;">
			<div class="mt-3 mb-5">
				<br>
				<br>
				<br>
				<div class="container">
					<div class="row">
						<div class="col-8">
						<c:if test="${not empty message}">
					     <div class="alert alert-dismissible alert-danger">${message}</div>
				        </c:if>
				        </div>
						<div class="col-4">
							<br>
							<br>
							<br>
							<br>
							<br>
							<br> <br>
							<br>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="container" style="background-color: #540759; top: 450px; position: absolute; margin-left: 80px; border-radius: 20px;">
			<div class="row p-5">
			    <c:if test="${not empty error}">
					<div class="alert alert-dismissible alert-danger">${error}</div>
				</c:if>
				<div class="col-6 mt-4"
					style="background-image: url('public/media/jobconfiance.jpg'); background-size: 650px 400px; background-repeat: no-repeat; border-radius: 10px;">

				</div>
				<div class="col-6 mt-4">
					<div class="panel panel-info">
						<div class="panel-heading">
							<div class="panel-title">Sign In</div>
							<div
								style="float: right; font-size: 80%; position: relative; top: -10px">
								<a href="#">Forgot password?</a>
							</div>
						</div>
						<div style="padding-top: 30px" class="panel-body">

							<div style="display: none" id="login-alert"
								class="alert alert-danger col-sm-12"></div>

							<form id="loginform" class="form-horizontal" role="form" action="Login" method="post">

								<div style="margin-bottom: 25px" class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-user"></i></span> <input
										id="login-username" type="text" class="form-control"
										name="email" value="" placeholder="username or email">
								</div>

								<div style="margin-bottom: 25px" class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-lock"></i></span> <input
										id="login-password" type="password" class="form-control"
										name="password" placeholder="password">
								</div>



								<div class="input-group">
									<div class="checkbox">
										<label> <input id="login-remember" type="checkbox"
											name="remember" value="1"> Remember me
										</label>
									</div>
								</div>


								<div style="margin-top: 10px" class="form-group">
									<!-- Button -->

									<div class="col-sm-12 controls">
										<button type="submit" name="action" value="connexion" class="btn btn-success">Connexion</button>
										<a id="btn-fblogin" href="#" class="btn btn-primary"data-toggle="modal" data-target="#myModalHorizontal">Inscrire</a>

									</div>
								</div>


								<div class="form-group">
									<div class="col-md-12 control">
										<div
											style="border-top: 1px solid #888; padding-top: 15px; font-size: 85%">
											Don't have an account! <a href="#"
												onClick="$('#loginbox').hide(); $('#signupbox').show()">
												Sign Up Here </a>
										</div>
									</div>
								</div>
							</form>



						</div>
					</div>

				</div>
			</div>
		</div>
		<!-- Modal -->
		<div class="modal fade" id="myModalHorizontal" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<!-- Modal Header -->
					<div class="modal-header"style="background-color: #540759;">
					    <c:if test="${not empty errorremplir}">
					    <div class="alert alert-dismissible alert-danger">${error}</div>
				        </c:if>
						<h4 class="modal-title text-secondary" id="myModalLabel">Incription SenEuleuK</h4>
					</div>

					<!-- Modal Body -->
					<div class="modal-body">
						<form class="form-horizontal" role="form" action="candidat" method="post">
							<div class="form-group">
								<label class="col-sm-2 control-label" for="inputEmail3">Prenom:</label>
								<div class="col-sm-10"><input type="text" name="firstname" class="form-control" id="inputEmail3" placeholder="Prenom" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="inputEmail3">Nom:</label>
								<div class="col-sm-10"><input type="text"  name="lastname" class="form-control" id="inputEmail3" placeholder="Nom" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="inputEmail3">Email:</label>
								<div class="col-sm-10"><input type="email"  name="email"class="form-control" id="inputEmail3" placeholder="Email" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="inputEmail3">Password:</label>
								<div class="col-sm-10"><input type="password"  name="password" class="form-control" id="inputEmail3" placeholder="Password" />
								</div>
							</div>
							
							<!-- Modal Footer -->
					        <div class="modal-footer">
						    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						    <button type="submit"name="action" value="enregistrer" class="btn"style="background-color: #015D53;color: white;">Enregistrer</button>
					        </div>
						</form>
					</div>

					
				</div>
			</div>
		</div>
<!-- Modal -->

	</div>


</body>
</html>