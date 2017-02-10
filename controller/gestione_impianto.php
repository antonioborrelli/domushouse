<?php

	define('UPDATE_LIGHTS', 'lights');
	define('UPDATE_DOOR', 'door');
	define('UPDATE_TEMPERATURE', 'temperature');
	define('UPDATE_TEMPERATURA_DESIDERATA', 'change_temp');
	

    define('INGRESSO',  '18');
    define('CUCINA',    '23');
	define('BAGNO',     '24');
	define('LETTO',		'25');

	define('AUTO',      '12');
    //define('PEDONE',	'16');
    define('PORTONE',	'20');
    define('PORTA',	    '21');

//     $operazione=$_POST['operazione'];
    $command = '';
    
//     //Apertura connessione DB
//     include "../model/start_connection.php";
    
   switch ($operazione) {
   	
   	case UPDATE_LIGHTS:
   		{
   			$Sql = "SELECT * 
   					FROM `rele` 
   					WHERE 	descrizione = 'cucina' 
   							OR descrizione = 'bagno' 
   							OR descrizione = 'letto' 
   							OR descrizione = 'ingresso'";
   			
   			$result = mysql_query($Sql) or die('Query failed: ' . mysql_error());
   			
   			$rows = array();
   			while($r = mysql_fetch_assoc($result)) {
   				$rows['data'][] = $r;
   			}
   			
   			echo json_encode($rows);
   			
   			
   			
   		}break;
   		
   		case UPDATE_DOOR:
   			{
   				$Sql = "SELECT *
   					FROM `rele`
   					WHERE 	descrizione = 'auto'
   							OR descrizione = 'portone'
   							OR descrizione = 'porta'";
   				 
   				$result = mysql_query($Sql) or die('Query failed: ' . mysql_error());
   				 
   				$rows = array();
   				while($r = mysql_fetch_assoc($result)) {
   					$rows['data'][] = $r;
   				}
   				 
   				echo json_encode($rows);
   				 
   				 
   				 
   			}break;
   			
   		case UPDATE_TEMPERATURE:
   			{
   				$Sql = "SELECT *
   						FROM `temperature`
   						WHERE 	id_rele = '4'";
   					 
   				$result = mysql_query($Sql) or die('Query failed: ' . mysql_error());
   					 
   				$rows = array();
   				while($r = mysql_fetch_assoc($result)) {
   					$rows['data'][] = $r;
   				}
   					 
   				echo json_encode($rows);
   					 
   					 
   					 
   			}break;
   		case UPDATE_TEMPERATURA_DESIDERATA:
   			{
   				$temp_desiderata = $_POST['val_temp'];
   				$Sql = "UPDATE temperature SET temperatura = '$temp_desiderata' WHERE id_rele = '4';";
   						
   				$result = mysql_query($Sql) or die('Query failed: ' . mysql_error());
   						
   				if($result){
   					$result = array('stato' => 1);
   				}else{
   					$result = array('stato' => 0);
   				}
   						
   				echo json_encode($rows);
   						
   						
   						
   			}break;
    case "ingresso":
        $command = 'sudo python ../model/switching.py '.INGRESSO;
        break;
    case "cucina":
        $command = 'sudo python ../model/switching.py '.CUCINA;
        break;
    case "bagno":
        $command = 'sudo python ../model/switching.py '.BAGNO;
        break;
    case "letto":
        $command = 'sudo python ../model/switching.py '.LETTO;
        break;
    case "auto":
        $command = 'sudo python ../model/switching.py '.AUTO;
        break;
    case "pedone":
        $command = 'sudo python ../model/switching.py '.PEDONE;
        break;
    case "portone":
        $command = 'sudo python ../model/switching.py '.PORTONE;
        break;
     case "porta":
        $command = 'sudo python ../model/switching.py '.PORTA;
        break;
//     default: echo $operazione;
    }
    if($command != '')
        exec($command);
    
//     //Chiusura connessione DB
//     include "../model/close_connection.php";