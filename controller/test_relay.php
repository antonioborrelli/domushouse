<?php

    if($_POST["test_button"]==1){
        exec('sudo python ../model/test_accensione.py');
    }else if($_POST["test_button"]==0){
        exec('sudo python ../model/test_spegnimento.py');
    }
    
    header("location: ../view/test.php");
?>