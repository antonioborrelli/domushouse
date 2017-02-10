/* ========================================================================
 * Settings: settings 0.1.js
 * ========================================================================
 * Componente utilizzato per gestire le impostazioni dell'utente
 * ======================================================================== */

	function riempimento_utenti(){
        // INIZIO CHIAMATA AJAX PER IL RIEMPIMENTO DELLA TABELLA UTENTI
        $("#myLoader").modal("show");
        $.ajax({
			  // definisco il tipo della chiamata
			  type: "POST",
			  // specifico la URL della risorsa da contattare
			  url: "../controller/webserver.php",
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
							  	riga= '<tr><td scope="row"><i class="fa fa-user-secret fa-6" aria-hidden="true"></i> '+data[i].username+'</td><td></td></tr>';
							  else
							  	riga= '<tr><td scope="row"><i class="fa fa-user-circle-o" aria-hidden="true"></i> '+data[i].username+'</td><td style="text-align: right;"><button type="button" onClick="delete_utente('+data[i].id+');" class="btn btn-danger btn-xs rimozione_utente"><span class="glyphicon glyphicon-trash"></span></button></td></tr>';
							  
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
	}
	
	

    


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
			  url: "../controller/webserver.php",
			  // passo dei dati alla risorsa remota
			  data: JSON.parse(arrayData),
			  // definisco il formato della risposta
			  dataType: "html",
			  // imposto un'azione per il caso di successo
			  success: function(risposta){
				  
				  var result = JSON.parse(risposta);
					
					if(result != null && result.stato==1){
						$( "#new_username" ).val("");
						$( "#new_password" ).val("");
						$(".row_error").hide();
						$(".msg_error").html("");
						$(".row_success").show();
						$(".msg_success").html(result.msg);
						$("#contenuto_tabella").empty();
						
						riempimento_utenti();
						
					}else{
						$(".row_success").hide();
						$(".msg_success").html("");
						$(".row_error").show();
						$(".msg_error").html(result.msg);
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
			  url: "../controller/webserver.php",
			  // passo dei dati alla risorsa remota
			  data: JSON.parse(arrayData),
			  // definisco il formato della risposta
			  dataType: "html",
			  // imposto un'azione per il caso di successo
			  success: function(risposta){
				  
				  var result = JSON.parse(risposta);
	  				
	  				if(result != null && result.stato==1){
	  					$( "#password" ).val("");
	  					$(".row_error").hide();
	  					$(".msg_error").html("");
	  					$(".row_success").show();
	  					$(".msg_success").html(result.msg);
	  					$("#contenuto_tabella").empty();
	  					riempimento_utenti();
	  				}else{
	  					$(".row_success").hide();
	  					$(".msg_success").html("");
	  					$(".row_error").show();
	  					$(".msg_error").html(result.msg);
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
  		  url: "../controller/webserver.php",
  		  // passo dei dati alla risorsa remota
  		  data: JSON.parse(arrayData),
  		  // definisco il formato della risposta
  		  dataType: "html",
  		  // imposto un'azione per il caso di successo
  		  success: function(risposta){
  			  
  			  var result = JSON.parse(risposta);
  				
  				if(result != null && result.stato==1){
  					$(".row_error").hide();
  					$(".msg_error").html("");
  					$(".row_success").show();
  					$(".msg_success").html(result.msg);
  					$("#contenuto_tabella").empty();
  					riempimento_utenti();
  				}else{
  					$(".row_success").hide();
  					$(".msg_success").html("");
  					$(".row_error").show();
  					$(".msg_error").html(result.msg);
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




$(function() {

	riempimento_utenti();
	//Gestione pressione bottone Salva
    $( "#salva" ).on('click keyCode',aggiorna_password);
    $("#password").keypress(function(e) {
  	  if (e.which == 13) {
  		aggiorna_password();
  	  }
  	});
    
    //Gestione pressione bottone Aggiungi
    $( "#aggiungi" ).on('click keyCode',nuovo_utente);
    $("#new_username").keypress(function(e) {
  	  if (e.which == 13) {
  		  nuovo_utente();
  	  }
  	});
    $("#new_password").keypress(function(e) {
  	  if (e.which == 13) {
  		  nuovo_utente();
  	  }
  	});

});

