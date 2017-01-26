<?php include '../controller/testLogin.php'; ?>
<?php include 'component/header.php'; ?>
<script language="javascript" type="text/javascript" src="script/settings.js"></script>

    <div id="admin_container" class="container" style=" display: <?php if(!$isAdmin){echo 'none';}  ?>;" >
        <h3>Amministrazione utenti </h3>

        <div class="row">
            <div class="col-md-6">
                <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading">Utenti Registrati</div>

                <!-- Table -->
                <table class="table">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Username</th>
                            <th>Password</th>
                            <th>Elimina</th>
                        </tr>
                    </thead>
                    <tbody id="contenuto_tabella"></tbody>
                </table>
                </div>
            </div>
            <div class="col-md-4 col-md-offset-2">
                <div class="row riga_home_imp">
                    <div class="col-md-4 col-md-offset-2">
                        <div class="input-group">
                            <input type="text" class="input-base" id="new_username" name="new_username" placeholder="Username" aria-describedby="basic-addon1" >
                        </div>
                    </div>
                </div>
                <div class="row"><div class="col-md-12"></div></div> 
                <div class="row riga_home_imp">
                    <div class="col-md-4 col-md-offset-2">
                        <div class="input-group">
                            <input type="password" id="new_password" name="new_password" class="input-base" placeholder="Password" aria-describedby="basic-addon1">
                        </div>
                    </div>
                </div> 
                <div class="row"><div class="col-md-12"></div></div> 
                <div class="row riga_home_imp">
                    <div class="col-md-4 col-md-offset-6"><button type="button" id="aggiungi" name="aggiungi" class="bottone-base">Aggiungi</button></div>
                </div>          
            </div>

        </div>
                



    </div>
        <div id="utente_container" class="container">
            <h3>Modifica Password</h3>
            <br>
            <div class="row">
                <div class="col-md-4 col-md-offset-2">
                    <div class="input-group">
                        <input type="text" class="input-base" id="username" name="username" value=<?php echo $utente ?> aria-describedby="basic-addon1" readonly>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4 col-md-offset-6"><button type="button" id="salva" name="salva" class="bottone-base">Salva</button></div>
            </div>
            <div class="row">
                <div class="col-md-4 col-md-offset-2">
                    <div class="input-group">
                        <input type="password" id="password" name="password" class="input-base" placeholder="Password" aria-describedby="basic-addon1">
                    </div>
                </div>
            </div>
        </div>

<?php include 'component/footer.php';?>