<?php 
    //Controllo sui permessi per accedere alla pagina
    if(!isset($_COOKIE['LOGIN'])){
        header('Location: ../view/index.php');
    }
    
?>