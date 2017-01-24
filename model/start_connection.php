<?php

    define('DB_SERVER',   'localhost');
    define('DB_USERNAME', 'root');
    define('DB_PASSWORD', 'root');
    define('DB_DATABASE', 'domus_house');

    // Avvio una connessione 
    $link = mysql_connect(DB_SERVER,DB_USERNAME,DB_PASSWORD);
    mysql_select_db(DB_DATABASE) or die('Could not select database');

   
?>