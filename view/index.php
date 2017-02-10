<?php 
    if(isset($_COOKIE['LOGIN'])){
        header('Location: home.php');
    }
include 'component/header.php';?>
<script language="javascript" type="text/javascript" src="script/index.js"></script>

    <div class="container">
    
        <div class="row riga_home_img">
            <div class="col-md-4 col-md-offset-2"><img src="../img/logo.png" class="img_home" ></div>
            <div class="col-md-4 ">
				<ul class="list-group list-group-index">
					<li class="list-group-item my_thumbnail"><div
							class="input-group input-group-lg">
							<span class="input-group-addon" id="sizing-addon1"><i
								class="fa fa-user-circle-o" aria-hidden="true"></i></span> <input
								type="text" class="form-control" id="username" name="username"
								placeholder="Username"
								aria-describedby="sizing-addon1">
						</div></li>
					<li class="list-group-item my_thumbnail"><div
							class="input-group input-group-lg">
							<span class="input-group-addon" id="sizing-addon1"><i
								class="fa fa-key" aria-hidden="true"></i></span> <input
								type="password" class="form-control" id="password" name="password"
								placeholder="Password" aria-describedby="sizing-addon1">
						</div></li>
						
					<li class="list-group-item my_thumbnail row_error" style="display:none;"><div class="alert alert-danger" role="alert">
					  <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
					  <span class="sr-only">Error:</span>
					  <span class="msg_error"></span>
					</div></li>
				</ul>
				<div class="btn-login" >
					<button type="button" id="login" name="login"
						class="btn btn-info">Login 
						<i class="fa fa-sign-in" aria-hidden="true"></i>
					</button>
				</div>
				
				
				
				
       
            </div>
        </div>


    </div>
        
  
<?php include 'component/footer.php';?>