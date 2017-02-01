<?php 

    # VA IMPLEMENTATA LA LOGICA PER DEFINIRE IL REDIRECT SE 
    # SULLA PAGINA LOGIN O SU HOME A SECONDA SE E' STATO 
    # EFFETTUATO IL LOGNI O MENO'

    


    if (is_device()) {
        // echo "Mobile";
        header("location: view/download_app.php");
    } else {
        // echo "Desktop";
        header("location: view/");
    }



    function is_device() {
        $user_agent = $_SERVER["HTTP_USER_AGENT"];
        $device = array("iPhone", "Android", "Windows Phone", "BlackBerry", "iPod");
        foreach ($device as $value) {
            if (strpos($user_agent, $value) !== false) {
                return true;
            }
        }
        return false;
    }

?>