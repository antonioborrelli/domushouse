<?php 
    if(isset($_COOKIE['LOGIN'])){
        header('Location: home.php');
    }
include 'component/header.php';?>

<form action="../controller/login.php" method="POST">
    <div class="container">
        <div class="row riga_home_img">
            <div class="col-md-4 col-md-offset-2"><img src="../img/logo.png" class="img_home" ></div>
            <div class="col-md-4 ">

                <div class="row riga_home_imp1">
                    <div class="col-md-12">
                        <input type="text" class="input-base" placeholder="Username" id="username" name="username" aria-describedby="basic-addon1">
                    </div>
                </div>
                <div class="row riga_home_imp">
                    <div class="col-md-12">
                        <input type="password" class="input-base " placeholder="Password" id="password" name="password" aria-describedby="basic-addon1">
                    </div>
                </div>
                <div class="row riga_home_imp">
                    <div class="col-md-12">
                        <button type="submit" class="bottone-base">Login</button>
                    </div>
                </div>

               
            </div>
        </div>

        <!--
        <div class="row">
            <div class="col-md-6 component_login_sx"><img src="../img/logo.png" class="img-rounded" ></div>
            <div class="col-md-6 component_login_dx">
                 <div class="row">
                    <div class="col-md-12">
                        <div class="input-group">
                            <hr>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="input-group">
                            <input type="text" class="input-base" placeholder="Username" id="username" name="username" aria-describedby="basic-addon1">
                        </div>
                    </div>
                    <div class="col-md-6">
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="input-group">
                            <hr>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="input-group">
                            
                            <input type="password" class="input-base " placeholder="Password" id="password" name="password" aria-describedby="basic-addon1">
                        </div>
                        <div class="col-md-6">
                    </div>
                    </div>
                </div>
                 <div class="row">
                    <div class="col-md-12">
                        <div class="input-group">
                            <hr>
                        </div>
                    </div>
                </div>
                 <div class="row">
     
                    <div class="col-md-3">
                       
                    </div>
                    <div class="col-md-3">
                        <div class="input-group">
                           <button type="submit" class="bottone-base">Login</button>
                        </div>
                    </div>
                    <div class="col-md-6">
                    </div>
                </div>
                
                

            </div>
        </div>
    -->
    </div>
        
</form>
  
<?php include 'component/footer.php';?>