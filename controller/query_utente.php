<?php

    define('LOGIN',	                'login_utente');
    define('LOGOUT',	            'logout_utente');
	define('INSERIMENTO_UTENTE',	'insert_utente');
	define('MODIFICA_PASSWORD',		'update_pw');
	define('ELIMINA_UTENTE',		'delete_utente');
    define('GET_UTENTI',		    'get_utenti');

// 	$operazione=$_POST['operazione'];
	
// 	//Apertura connessione DB
// 	include "../model/start_connection.php";


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

            $result = array('stato' => 1, 'msg'=>'Credenziali di accesso valide');

        }else{

            $result = array('stato' => 0, 'msg'=>'Credenziali di accesso non valide');

        }

        echo json_encode($result);

    }else if($operazione == LOGOUT){

        setcookie('LOGIN', null, -1, "/" );

		 echo json_encode('1');

    }else if($operazione == INSERIMENTO_UTENTE){

        $username = mysql_real_escape_string($_POST['username']);
        $password = md5(mysql_real_escape_string($_POST['password'])); 
        
        $Sql = "SELECT * FROM utenti WHERE username='".$username."';";
        $Query = mysql_query($Sql) or die('Query failed: ' . mysql_error());
        
        
        if(mysql_num_rows($Query) >= 1){
        	$result = array('stato' => 0, 'msg'=>'Nome utente non disponibile');
        }else{

        	if(strlen($_POST['username'])>0){
        		if(check_psw($_POST['password'])){
        			$Sql = "INSERT INTO utenti( username ,  password ) VALUES ('$username' ,'$password');";
        		
        			$result = mysql_query($Sql) or die('Query failed: ' . mysql_error());
        		
        			if($result){
        				$result = array('stato' => 1, 'msg'=>'Utente aggiunto correttamente');
        			}else{
        				$result = array('stato' => 0, 'msg'=>'Errore connessione con il server riprovare pi&ugrave; tardi');
        			}
        		}else{
        			$result = array('stato' => 0, 'msg'=>'Errore password non corretta');
        		}
        		
        	}else{
        		$result = array('stato' => 0, 'msg'=>'Errore username non corretta');
        	} 
	
        }
        
		echo json_encode($result);

    }else if($operazione == ELIMINA_UTENTE){

        $id = $_POST['id'];

        $Sql = "DELETE FROM utenti WHERE id = '$id'";

        $result = mysql_query($Sql) or die('Query failed: ' . mysql_error());

        if($result){
            $result = array('stato' => 1, 'msg'=>'Utente eliminato correttamente');
        }else{
            $result = array('stato' => 0, 'msg'=>'Errore connessione con il server riprovare pi&ugrave; tardi');
        }

		echo json_encode($result);

    }else if($operazione == MODIFICA_PASSWORD){

        $username = mysql_real_escape_string($_POST['username']);
        $password = md5(mysql_real_escape_string($_POST['password'])); 

        if(check_psw($_POST['password'])){
        	$Sql = "UPDATE utenti SET password = '$password' WHERE username = '$username';";
        	
        	$result = mysql_query($Sql) or die('Query failed: ' . mysql_error());
        	
        	if($result){
        		$result = array('stato' => 1, 'msg'=>'Password modificata correttamente');
        	}else{
        		$result = array('stato' => 0, 'msg'=>'Errore connessione con il server riprovare pi&ugrave; tardi');
        	}
        }else{
        	$result = array('stato' => 0, 'msg'=>'Errore password non corretta');
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

//     //Chiusura connessione DB
// 	include "../model/close_connection.php";
	
	
	
	//Funzione per il controllo della password
	function check_psw($psw)
	{
		// Verificare che la password contenga almeno 8 caratteri
		if(strlen($psw) < 8)
			return false;
		
		// Verificare che la password contenga almeno un numero
		$numeri = preg_replace("/[^0-9]/", "", $psw);
		if($numeri==null)
			return false;
	
	
		// Verificare che la password contenga almeno una lettera
		$caratteri = preg_replace("/[^A-z]/", "", $psw);
		if($caratteri==null)
			return false;
		
			
		return true;
	}
	

?>