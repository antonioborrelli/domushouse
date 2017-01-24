<?php include '../controller/testLogin.php'; ?>
<?php include 'component/header.php'; ?>

    <div id="admin_container" class="container" style=" display: <?php if(!$isAdmin){echo 'none';}  ?>;" >
        <h3>Amministrazione utenti </h3>
    </div>
    <div id="utente_container" class="container">
        <h3>Modifica Password</h3>
        <br>
        <div class="row">
            <div class="col-md-4 col-md-offset-2">
                 <div class="input-group">
                     <input type="text" class="input-base" placeholder=<?php echo $utente ?> aria-describedby="basic-addon1" disabled>
                 </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-4 col-md-offset-6"> <a href="home.php"><button type="button" class="bottone-base">Salva</button></a></div>
        </div>
        <div class="row">
            <div class="col-md-4 col-md-offset-2">
                 <div class="input-group">
                     <input type="password" class="input-base" placeholder="Password" aria-describedby="basic-addon1">
                 </div>
            </div>
        </div>
    </div>

<?php include 'component/footer.php';?>