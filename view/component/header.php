<!DOCTYPE html>
<html lang="it">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="../img//icona.ico" />
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Domus - House</title>

    <!-- jquery -->
    <script language="javascript" type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
    <script language="javascript" type="text/javascript" src="../view/script/utility.js"></script>
    

    <!-- Bootstrap -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/custom.css" rel="stylesheet">
    <link rel="stylesheet" href="../font/css/font-awesome.min.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>

  <?php 
    include 'loader.php'; 

    $utente=$_COOKIE["LOGIN"];
    $isAdmin=false;

    if($utente == 'admin')
      $isAdmin=true;

    $url =  $_SERVER['REQUEST_URI'];

    $url_list = explode("/", $_SERVER['REQUEST_URI']);

    $pagina = $url_list[count($url_list)-1];

    if( $pagina != 'index.php' && $pagina != '' ){

        $visibile="";
        if($pagina == 'home.php'){
          $visibile="none";
        }
      
        echo '  			<div class="container">
                  <div class="row">
                      <div class="col-md-2 col_header_1">
                          <img src="../img/logo.png" class="img_home" >
                      </div>
                      <div class="col-md-8 col_header_2">
                          <h3>Benvenuto '.$utente.'</h3>

                         
    						<div class="row">
								<div class="col-md-12">
									<div class="my_panel panel-group">
										<div class="panel my_panel panel-default my_thumbnail">
											
											<div id="collapse10" class="panel-collapse collapse in my_thumbnail">
						
												<table class="table my_table my_thumbnail">
													<tbody class="my_thumbnail">
														<tr class="my_thumbnail">
															<td scope="row"class=" my_thumbnail"><i class="fa fa-thermometer-quarter  "
																style="margin-left: 15px;" aria-hidden="true"></i> <label
																style="margin-left: 15px;" class="temp_attuale"></label></td>
															<td class="my_thumbnail"><label for="exampleSelect1">Temperatura desiderata </label><select
																id="exampleSelect1" class="temp_des selectpicker "
																aria-describedby="basic-addon1" readonly>';
    															for($i = 1; $i< 51 ; $i++)
																	echo '<option value="'.$i.'">'.$i.'</option>';
    															echo'</select></td>
														</tr>
														<tr class="my_thumbnail">
															<td scope="row"class="  my_thumbnail"><i class="fa fa-tint "
																style="margin-left: 15px;" aria-hidden="true"></i><label
																style="margin-left: 15px;" class="umi_attuale"></label></td>
															<td class="my_thumbnail"></td>
														</tr>
													</tbody>
												</table>
						
											</div>
										</div>
									</div>
						
                          	</div>
                          	<div class="col-md-4">
                          	</div>
                          </div>       
                      </div>
                      <div class="col-md-1 col_header_3">
                          <h3> <a href="home.php"><button type="button" class="btn btn-info"style=" display: '.$visibile.';" ><i class="fa fa-home" aria-hidden="true"></i> Home</button></a></h3>
                      </div>
                      <div class="col-md-1 col_header_3">
                          <h3> <button type="button" id="logout" name="logout" class="btn btn-info">Logout <i class="fa fa-sign-out" aria-hidden="true"></i></button></h3>
                      </div>
                  </div>
                </div>';


    }
  
  ?>
  
  




  

  