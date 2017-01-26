<?php

    define('LOGIN',	                'login_utente');
    define('LOGOUT',	            'logout_utente');
	define('INSERIMENTO_UTENTE',	'insert_utente');
	define('MODIFICA_PASSWORD',		'update_pw');
	define('ELIMINA_UTENTE',		'delete_utente');
    define('GET_UTENTI',		    'get_utenti');

	$operazione=$_POST['operazione'];
	
	//Apertura connessione DB
	include "../model/start_connection.php";


    if($operazione == LOGIN){

        $username = mysql_real_escape_string($_POST['username']);
        $password = md5(mysql_real_escape_string($_POST['password'])); 

        $Sql = "SELECT * FROM utenti WHERE username='".$username."' AND password='".$password."';";
        $Query = mysql_query($Sql) or die('Query failed: ' . mysql_error());


        if(mysql_num_rows($Query) == 1){

            $Dati = mysql_fetch_array($Query);

            if(@$_POST["ricorda"] == 1)
                $TempoDiValidita = 2592000;     //Cookie attivo per 30 giorni
            else
                $TempoDiValidita = 72000;       //Cookie attivo per 2 ore

        
            setcookie('LOGIN', $Dati["username"], time()+$TempoDiValidita, "/" );

            $result = array('stato' => 1);

        }else{

            $result = array('stato' => 0);

        }

        echo json_encode($result);

    }else if($operazione == LOGOUT){

        setcookie('LOGIN', null, -1, "/" );

		 echo json_encode('1');

    }else if($operazione == INSERIMENTO_UTENTE){

        $username = mysql_real_escape_string($_POST['username']);
        $password = md5(mysql_real_escape_string($_POST['password'])); 

        $Sql = "INSERT INTO utenti( username ,  password ) VALUES ('$username' ,'$password');";

        $result = mysql_query($Sql) or die('Query failed: ' . mysql_error());

        if($result){
            $result = array('stato' => 1);
        }else{
            $result = array('stato' => 0);
        }

		echo json_encode($result);

    }else if($operazione == ELIMINA_UTENTE){

        $id = $_POST['id'];

        $Sql = "DELETE FROM utenti WHERE id = '$id'";

        $result = mysql_query($Sql) or die('Query failed: ' . mysql_error());

        if($result){
            $result = array('stato' => 1);
        }else{
            $result = array('stato' => 0);
        }

		echo json_encode($result);

    }else if($operazione == MODIFICA_PASSWORD){

        $username = mysql_real_escape_string($_POST['username']);
        $password = md5(mysql_real_escape_string($_POST['password'])); 

        $Sql = "UPDATE utenti SET password = '$password' WHERE username = '$username';";

        $result = mysql_query($Sql) or die('Query failed: ' . mysql_error());

        if($result){
            $result = array('stato' => 1);
        }else{
            $result = array('stato' => 0);
        }

		 echo json_encode($result);

    }else if($operazione == GET_UTENTI){

        $Sql = "SELECT * FROM utenti WHERE 1=1;";

        $result = mysql_query($Sql) or die('Query failed: ' . mysql_error());
		
		//creazione oggetto Json contenente i risultati della query
		$rows = array();
		while($r = mysql_fetch_assoc($result)) {
			$rows['data'][] = $r;
		}

		echo json_encode($rows);

    }

    //Chiusura connessione DB
	include "../model/close_connection.php";
	

?>