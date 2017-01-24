<!DOCTYPE html>
<html lang="it">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Domus - House</title>

    <!-- Bootstrap -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/custom.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>

  <?php 

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
      
        echo '<div class="container">
                  <div class="row">
                      <div class="col-md-2 col_header_1">
                          <img src="../img/logo.png" class="img_home" >
                      </div>
                      <div class="col-md-8 col_header_2">
                          <h3>Benvenuto '.$utente.'</h3>
                      </div>
                      <div class="col-md-1 col_header_3">
                          <h3> <a href="home.php"><button type="button" class="bottone-base"style=" display: '.$visibile.';" >Home</button></a></h3>
                      </div>
                      <div class="col-md-1 col_header_3">
                          <h3> <a href="../controller/logout.php"><button type="button" class="bottone-base">Logout</button></a></h3>
                      </div>
                  </div>
                </div>';


    }
  
  ?>



  

  