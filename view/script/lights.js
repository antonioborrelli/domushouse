/* ========================================================================
 * Settings: lights 0.1.js
 * ========================================================================
 * Componente utilizzato per gestire le luci
 * ======================================================================== */

$(function() {
	
	
	
	//AGGIORNAMENTO STATO LUCI
	// INIZIO CHIMATA AJAX
    $.ajax({
		  // definisco il tipo della chiamata
		  type: "POST",
		  // specifico la URL della risorsa da contattare
		  url: "../controller/webserver.php",
		  // passo dei dati alla risorsa remota
		  data: JSON.parse('{ "operazione" : "lights"}'),
		  // definisco il formato della risposta
		  dataType: "html",
		  // imposto un'azione per il caso di successo
		  success: function(risposta){
			  
			console.log(risposta);
			var result = JSON.parse(risposta);
			
			if(result != null){

				  if(result.data!= null && result.data!= undefined){
					  var data= result.data
					  
					  
					  for(i=0; i< data.length; i++){
						  
//						  $('#'+data[i].descrizione).removeClass('lux-off');
//						  $('#'+data[i].descrizione).removeClass('lux-on');
						  if(data[i].stato==1){
							  $('#'+data[i].descrizione+' img')[0].src="../img/luxon.png";
//							  $('#'+data[i].descrizione).addClass('lux-on')
						  }else{
//							  $('#'+data[i].descrizione).addClass('lux-off')
							  $('#'+data[i].descrizione+' img')[0].src="../img/luxoff.png";
						  }
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
    
    
    
	

    //Gestione pressione bottone Salva
    $( "#cucina" ).on('click keyCode',switch_cucina);
    
    //Funzione per effettuare il login
    function switch_cucina(){
        var dataSet = [];
        var arrayData=	'{ "operazione" : "cucina"}' ;


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
				  
				console.log(risposta);

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
	}

	//Gestione pressione bottone ingresso
    $( "#ingresso" ).on('click keyCode',switch_ingresso);
    
    
    function switch_ingresso(){
        var dataSet = [];
        var arrayData=	'{ "operazione" : "ingresso"}' ;


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
				  
				console.log(risposta);

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
    }

		//Gestione pressione bottone bagno
    $( "#bagno" ).on('click keyCode',switch_bagno);
    
    
    function switch_bagno(){
        var dataSet = [];
        var arrayData=	'{ "operazione" : "bagno"}' ;


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
				  
				console.log(risposta);

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
    }

			//Gestione pressione bottone bagno
    $( "#letto" ).on('click keyCode',switch_letto);
    
    
    function switch_letto(){
        var dataSet = [];
        var arrayData=	'{ "operazione" : "letto"}' ;


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
				  
				console.log(risposta);

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
    }

});