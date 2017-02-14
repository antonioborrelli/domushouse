<?php


class Rele
{

    private $DB_SERVER='localhost:/Applications/MAMP/tmp/mysql/mysql.sock';
//     private $DB_SERVER='localhost';
    private $DB_USERNAME= 'root';
    private $DB_PASSWORD= 'root';
    private $DB_DATABASE= 'domus_house';
        
    public $descrizione;
    public $stato;
    public $id;

    

    public function __construct($descrizione)
    {

        $this->descrizione = $descrizione;
       

        // Avvio una connessione 
        $link = mysql_connect($this->DB_SERVER,$this->DB_USERNAME,$this->DB_PASSWORD);
        mysql_select_db($this->DB_DATABASE) or die('Could not select database');

        $Sql = "SELECT *
   					FROM `rele`
   					WHERE 	descrizione = '".$this->descrizione."'";
        
        $result = mysql_query($Sql) or die('Query failed: ' . mysql_error());
       
        // Chiudo la connessione 
        mysql_close($link);
       
        while($r = mysql_fetch_assoc($result)) {
        	$this->id = $r['id'];
        	$this->stato = $r['stato'];
		}
        
    }

    public function getDescrizione()
    {
        return $this->descrizione;
    }
    
    public function getId()
    {
    	return $this->id;
    }

    public function getStato()
    {
    	return $this->stato;
    }
    


}