/* ========================================================================
 * Settings: settings 0.1.js
 * ========================================================================
 * Componente utilizzato per gestire le impostazioni dell'utente
 * ======================================================================== */

$(function() {


        // INIZIO CHIAMATA AJAX PER IL RIEMPIMENTO DELLA TABELLA UTENTI
        $("#myLoader").modal("show");
        $.ajax({
			  // definisco il tipo della chiamata
			  type: "POST",
			  // specifico la URL della risorsa da contattare
			  url: "../controller/query_utente.php",
			  // passo dei dati alla risorsa remota
			  data: JSON.parse('{"operazione" : "get_utenti"}'),
			  // definisco il formato della risposta
			  dataType: "html",
			  // imposto un'azione per il caso di successo
			  success: function(risposta){
				  
				console.log('UTENTI' + risposta);


                //NASCONDO IL LOADER
				$("#myLoader").modal("hide");

			  },// ed una per il caso di fallimento
			  error: function(){
			    alert("Si è verificato un errore riprovare più tardi!!!");
                //NASCONDO IL LOADER
				$("#myLoader").modal("hide");
			  }
		});
        // FINE CHIAMATA AJAX


    //Gestione pressione bottone Salva
    $( "#salva" ).on('click keyCode',aggiorna_password);
    
    //Gestione pressione bottone Aggiungi
    $( "#aggiungi" ).on('click keyCode',nuovo_utente);


    //Aggiungi nuovo utente
    function nuovo_utente(){
        var dataSet = [];
        var arrayData=	'{'+
                        '"operazione" : "insert_utente",' +
                        '"username" : "'+$( "#new_username" ).val()+'",' +
                        '"password" : "'+$( "#new_password" ).val()+'"}' ;

        // INIZIO CHIAMATA AJAX
        $("#myLoader").modal("show");
        $.ajax({
			  // definisco il tipo della chiamata
			  type: "POST",
			  // specifico la URL della risorsa da contattare
			  url: "../controller/query_utente.php",
			  // passo dei dati alla risorsa remota
			  data: JSON.parse(arrayData),
			  // definisco il formato della risposta
			  dataType: "html",
			  // imposto un'azione per il caso di successo
			  success: function(risposta){
				  
				console.log(risposta);

                if(risposta == 1){
                    alert('Inserimento avvenuto con successo!');
                }

                //NASCONDO IL LOADER
				$("#myLoader").modal("hide");

			  },// ed una per il caso di fallimento
			  error: function(){
			    alert("Si è verificato un errore riprovare più tardi!!!");
                //NASCONDO IL LOADER
				$("#myLoader").modal("hide");
			  }
		});
        // FINE CHIAMATA AJAX

    }

    //Aggiorna password
    function aggiorna_password(){
        var dataSet = [];
        var arrayData=	'{'+
                        '"operazione" : "update_pw",' +
                        '"username" : "'+$( "#username" ).val()+'",' +
                        '"password" : "'+$( "#password" ).val()+'"}' ;


        // INIZIO CHIAMATA AJAX
        $.ajax({
			  // definisco il tipo della chiamata
			  type: "POST",
			  // specifico la URL della risorsa da contattare
			  url: "../controller/query_utente.php",
			  // passo dei dati alla risorsa remota
			  data: JSON.parse(arrayData),
			  // definisco il formato della risposta
			  dataType: "html",
			  // imposto un'azione per il caso di successo
			  success: function(risposta){
				  
				console.log(risposta);

                if(risposta == 1){
                    alert('Aggiornamento avvenuto con successo!');
                }

                //NASCONDO IL LOADER
				$("#myLoader").modal("hide");

			  },// ed una per il caso di fallimento
			  error: function(){
			    alert("Si è verificato un errore riprovare più tardi!!!");
                //NASCONDO IL LOADER
				$("#myLoader").modal("hide");
			  }
		});
        // FINE CHIAMATA AJAX





    }

});