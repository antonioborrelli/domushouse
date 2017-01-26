<?php include '../controller/testLogin.php'; ?>
<?php include 'component/header.php';?>

    <form action="../controller/test_relay.php" method="post">
    <div class="container">

         <div class="row">
            <div class="col-md-12">
                <br> <br>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <br> <br>
            </div>
        </div>


        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-1"></div>
            <div class="col-md-2">
                <div class="input-group">
                    <button type="submit" value="1" name="test_button" id="test_button" class="bottone-grande">Accendi</button>
                </div>
            </div>
            <div class="col-md-2"></div>
            <div class="col-md-2">
                <div class="input-group">
                    <button type="submit" value ="0" name="test_button" id="test_button" class="bottone-grande">Spegni</button>
                </div>
            </div>
            <div class="col-md-2"></div>
                        <div class="col-md-1"></div>


        </div>

        <div class="row">
            <div class="col-md-12">
                <br> <br>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <br> <br>
            </div>
        </div>

        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-1"></div>
            <div class="col-md-2"></div>
            </div>
            <div class="col-md-2"></div>
            <div class="col-md-2"></div>
            <div class="col-md-1"></div>
           
        </div>

    </div>
 </form>
<?php include 'component/footer.php';?>