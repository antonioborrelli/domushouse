/* ========================================================================
 * Settings: settings 0.1.js
 * ========================================================================
 * Componente utilizzato per gestire le impostazioni dell'utente
 * ======================================================================== */

	//Elimina utente
    function delete_utente(id){
        var dataSet = [];
        var arrayData=	'{'+
                        '"operazione" : "delete_utente",' +
                        '"id" : "'+id+'"}' ;

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
                    alert('Eliminazione avvenuto con successo!');
                }

				location.reload();

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

				var result = JSON.parse(risposta);
				
				if(result != null){

					  if(result.data!= null && result.data!= undefined){
						  var data= result.data

						  for (i=0; i<data.length; i++){
							  var riga="";

							  if(data[i].username == 'admin')
							  	riga= '<tr><th scope="row">'+data[i].id+'</th><td>'+data[i].username+'</td><td>'+data[i].password+'</td></td></tr>';
							  else
							  	riga= '<tr><th scope="row">'+data[i].id+'</th><td>'+data[i].username+'</td><td>'+data[i].password+'</td><td style="text-align: center;"><button type="button" onclick="delete_utente('+data[i].id+');" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-trash"></span></button></td></tr>';
							  
							  $("#contenuto_tabella").append(riga);

						  }
							  
							  
						}
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

				location.reload();

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
				var result = JSON.parse(risposta);
				console.log(result.stato);
                if(result != null && result.stato == 1){
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