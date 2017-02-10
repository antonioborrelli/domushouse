<?php include '../controller/testLogin.php'; ?>
<?php include 'component/header.php'; ?>
<script language="javascript" type="text/javascript"
	src="script/settings.js"></script>

<div id="admin_container" class="container"  >
	<div class="row">
		<div class="col-md-12">
			<br>
		</div>
	</div>
	
	
	<div class="row row_error" style="display:none;">
		<div class="col-md-12">
			<div class="alert alert-danger" role="alert">
			  <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
			  <span class="sr-only">Error:</span>
			  <span class="msg_error"></span>
			</div>
		</div>
	</div>
	
	<div class="row row_success" style="display:none;">
		<div class="col-md-12">
			<div class="alert alert-success" role="alert">
			  <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
			  <span class="sr-only">Error:</span>
			  <span class="msg_success"></span>
			</div>
		</div>
	</div>

	<div class="row">
		<!-- inizio colonna di sx  -->
		<div class="col-md-6 ">
			<div class="panel-group">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title">
							<a data-toggle="collapse" href="#collapse1"><i class="fa fa-pencil" aria-hidden="true"></i> Modifica Password</a>
						</h4>
					</div>
					<div id="collapse1" class="panel-collapse collapse">
						<ul class="list-group">
							<li class="list-group-item"><div
									class="input-group input-group-lg">
									<span class="input-group-addon" id="sizing-addon1"><i
										class="fa fa-user-circle-o" aria-hidden="true"></i></span> <input
										type="text" class="form-control" id="username" name="username"
										placeholder="Username" value=<?php echo $utente ?> readonly
										aria-describedby="sizing-addon1">
								</div></li>
							<li class="list-group-item"><div
									class="input-group input-group-lg">
									<span class="input-group-addon" id="sizing-addon1"><i
										class="fa fa-key" aria-hidden="true"></i></span> <input
										type="password" class="form-control" id="password" name="password"
										placeholder="New Password" aria-describedby="sizing-addon1">
								</div></li>
						</ul>
						<div class="panel-footer" style="text-align: right;">
							<button type="button" id="salva" name="salva"
								class="btn btn-success">
								<i class="fa fa-floppy-o" aria-hidden="true"></i> Modifica
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- fine colonna di sx  -->

		<!-- inizio colonna di dx  -->
		<div class="col-md-6 " style=" display: <?php if(!$isAdmin){echo 'none';}  ?>;">
			<div class="panel-group">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title">
							<a data-toggle="collapse" href="#collapse2"><i class="fa fa-plus" aria-hidden="true"></i> Nuovo Utente</a>
						</h4>
					</div>
					<div id="collapse2" class="panel-collapse collapse">
						<ul class="list-group">
							<li class="list-group-item"><div
									class="input-group input-group-lg">
									<span class="input-group-addon" id="sizing-addon1"><i
										class="fa fa-user-circle-o" aria-hidden="true"></i></span> <input
										type="text" class="form-control" id="new_username"
										name="new_username" placeholder="Username"
										aria-describedby="sizing-addon1">
								</div></li>
							<li class="list-group-item"><div
									class="input-group input-group-lg">
									<span class="input-group-addon" id="sizing-addon1"><i
										class="fa fa-key" aria-hidden="true"></i></span> <input
										type="password" class="form-control" id="new_password"
										name="new_password" placeholder="Password"
										aria-describedby="sizing-addon1">
								</div></li>
						</ul>
						<div class="panel-footer" style="
    text-align: right;
">
							<button type="button" id="aggiungi" name="aggiungi"
								class="btn btn-success">
								<i class="fa fa-floppy-o" aria-hidden="true"></i> Aggiungi
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- fine colonna di dx  -->
	</div>


	<div class="row" style=" display: <?php if(!$isAdmin){echo 'none';}  ?>;">
		<div class="col-md-12">
			<div class="panel-group">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title">
							<a data-toggle="collapse" href="#collapse0"><i class="fa fa-list" aria-hidden="true"></i> Lista
								utenti</a>
						</h4>
					</div>
					<div id="collapse0" class="panel-collapse collapse in">

						<!-- Table -->
						<table class="table my_table">
							<tbody id="contenuto_tabella"></tbody>
						</table>

					</div>
				</div>
			</div>

		</div>

	</div>




	

</div>





<?php include 'component/footer.php';?>