<?php

    if($_POST["test_button"]==1){
        exec('sudo python ../model/switching.py 18');
    }else if($_POST["test_button"]==0){
        exec('sudo python ../model/switching.py 23');
    }
    
    header("location: ../view/test.php");
?>