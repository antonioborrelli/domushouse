/* ========================================================================
 * Settings: index 0.1.js
 * ========================================================================
 * Componente utilizzato per gestire il login
 * ======================================================================== */

$(function() {

	function refresh(){
		location.reload();
	   };
	   window.setTimeout( refresh, 60000 );
	
	//AGGIORNAMENTO STATO TEMPERATURE
	// INIZIO CHIMATA AJAX
    $.ajax({
		  // definisco il tipo della chiamata
		  type: "POST",
		  // specifico la URL della risorsa da contattare
		  url: "../controller/webserver.php",
		  // passo dei dati alla risorsa remota
		  data: JSON.parse('{ "operazione" : "temperature"}'),
		  // definisco il formato della risposta
		  dataType: "html",
		  // imposto un'azione per il caso di successo
		  success: function(risposta){
			  
//			console.log(risposta);
			var result = JSON.parse(risposta);

			if(result != null){

				  if(result.data!= null && result.data!= undefined){
					  var data= result.data

					  
					  for(i=0; i< data.length; i++){
						  
						  $('.temp_attuale').html(data[i].temp_attuale + " °C")
						  $('.umi_attuale').html(data[i].umidita_attuale + " %")
						  $( ".temp_des" ).val(data[i].temperatura);
//						  console.log("Temp attuale " + data[i].temp_attuale);
//						  console.log("Umidità attuale " + data[i].umidita_attuale);
//						  console.log("Temp desiderata " + data[i].temperatura);
//						  console.log("data" + data[i].data);
						  
						  
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
    // FINE CHIMATA AJAX
	
    
    //GESTIONE CAMBIO TEMPERATURA
    $( ".temp_des" ).change(function() {
    	
    	// INIZIO CHIMATA AJAX
        $.ajax({
    		  // definisco il tipo della chiamata
    		  type: "POST",
    		  // specifico la URL della risorsa da contattare
    		  url: "../controller/webserver.php",
    		  // passo dei dati alla risorsa remota
    		  data: JSON.parse('{ "operazione" : "change_temp", "val_temp" : "'+$( ".temp_des" ).val()+'"}'),
    		  // definisco il formato della risposta
    		  dataType: "html",
    		  // imposto un'azione per il caso di successo
    		  success: function(risposta){

                //NASCONDO IL LOADER
    			$("#myLoader").modal("hide");
    			//REFRESCH DELLA PAGINA
				location.reload();

    		  },// ed una per il caso di fallimento
    		  error: function(){
    		    alert("Si è verificato un errore riprovare più tardi!!!");
                //NASCONDO IL LOADER
    			$("#myLoader").modal("hide");
    		  }
    	});
        // FINE CHIMATA AJAX
    	  
    	});
	
    //Gestione pressione bottone Salva
    $( "#logout" ).on('click keyCode',logout);
    
  
    //Funzione per effettuare il login
    function logout(){
        var dataSet = [];
        var arrayData=	'{"operazione" : "logout_utente"}' ;


        // INIZIO CHIMATA AJAX
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
				  
//				console.log(risposta);

                if(risposta == 1){
                    window.location.replace("../view/home.php");
                }else{
                    window.location.replace("../view/index.php");
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
        // FINE CHIMATA AJAX





    }

});