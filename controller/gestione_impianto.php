<?php

    define('INGRESSO',  '18');
    define('CUCINA',    '23');
	define('BAGNO',     '24');
	define('LETTO',		'25');

	define('AUTO',      '12 30');
    define('PEDONE',	'16 1');
    define('PORTONE',	'20 1');
    define('PORTA',	    '21 1');

    $operazione=$_POST['operazione'];
    $command = '';
    
   switch ($operazione) {
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
    default: echo $operazione;
    }
    if($command != '')
        exec($command);