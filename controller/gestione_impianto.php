<?php
include 'Sensore.php';
include 'Rele.php';

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
   			$cucina = new Rele('cucina');
	   		$bagno = new Rele('bagno');
	   		$letto = new Rele('letto');
	   		$ingresso = new Rele('ingresso');
   				
   			$rows['data'][]=$cucina;
   			$rows['data'][]=$bagno;
   			$rows['data'][]=$letto;
   			$rows['data'][]=$ingresso;
   			
   			
   			echo json_encode($rows);
   			
   			
   			
   		}break;
   		
   		case UPDATE_DOOR:
   			{
   				$auto = new Rele('auto');
   				$portone = new Rele('portone');
   				$porta = new Rele('porta');
   					
   				$rows['data'][]=$auto;
   				$rows['data'][]=$portone;
   				$rows['data'][]=$porta;
   				
   				
   				echo json_encode($rows);
   				
   				
   				 
   				 
   				 
   			}break;
   			
   		case UPDATE_TEMPERATURE:
   			{


   				$sensore = new Sensore('4');
   				
   				$rows['data']['temp_attuale'] = $sensore->getTemp();
   				$rows['data']['umidita_attuale'] = $sensore->getUmid();
   				$rows['data']['temperatura'] = $sensore->getTempDes();
   					 
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