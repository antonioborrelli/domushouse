<?php 

    //Apertura connessione DB
	include "../model/start_connection.php";

    //$password = md5($_POST["password"]);
    $username = mysql_real_escape_string($_POST['username']);
    $password = mysql_real_escape_string($_POST['password']); 

    $Sql = "SELECT * FROM `utenti` WHERE `username`='".$username."' AND `password`='".$password."';";
    $Query = mysql_query($Sql) or die('Query failed: ' . mysql_error());

    if(mysql_num_rows($Query) == 1)
        {
                $Dati = mysql_fetch_array($Query);
                if(@$_POST["ricorda"] == 1)
                    $TempoDiValidita = 2592000;  //Cookie attivo per 30 giorni
                else
                    $TempoDiValidita = 72000; //Cookie attivo per 2 ore
              
               setcookie('LOGIN', $Dati["username"], time()+$TempoDiValidita, "/" );
                header('Location: ../view/home.php');
        }
    else
        {
                header('Location: ../view/index.php');
        }


    //Chiusura connessione DB
	include "../model/close_connection.php";

?>
