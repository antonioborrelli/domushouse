<?php 

	
	//Apertura connessione DB
	include "../model/start_connection.php";
	


	$operazione=$_POST['operazione'];

	include "../controller/query_utente.php";
	
	include "../controller/gestione_impianto.php";
	
	//Chiusura connessione DB
	include "../model/close_connection.php";
	


?>