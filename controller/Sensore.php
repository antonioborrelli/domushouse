<?php


class Sensore
{

    private $DB_SERVER='localhost:/Applications/MAMP/tmp/mysql/mysql.sock';
//     private $DB_SERVER='localhost';
    private $DB_USERNAME= 'root';
    private $DB_PASSWORD= 'root';
    private $DB_DATABASE= 'domus_house';
        
    private $pin;
    public $temp;
    public $umid;
    public $temp_des;

    

    public function __construct($pin)
    {

        $this->pin = $pin;
       

        // Avvio una connessione 
        $link = mysql_connect($this->DB_SERVER,$this->DB_USERNAME,$this->DB_PASSWORD);
        mysql_select_db($this->DB_DATABASE) or die('Could not select database');

        $Sql = "SELECT *
   						FROM `temperature`
   						WHERE 	id_rele = '".$this->pin."'";
   					 
   		$result = mysql_query($Sql) or die('Query failed: ' . mysql_error());
       
        // Chiudo la connessione 
        mysql_close($link);
       
        while($r = mysql_fetch_assoc($result)) {
   			$this->temp = $r['temp_attuale'];
   			$this->umid = $r['umidita_attuale'];
   			$this->temp_des = $r['temperatura'];
		}
        
    }

    public function getTemp()
    {
        return $this->temp;
    }

    public function getUmid()
    {
        return $this->umid;
    }
    
    public function getTempDes()
    {
    	return $this->temp_des;
    }


}