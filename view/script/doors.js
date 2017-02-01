/* ========================================================================
 * Settings: doors 0.1.js
 * ========================================================================
 * Componente utilizzato per gestire l'apertura delle porte
 * ======================================================================== */

$(function() {

    //Gestione pressione bottone Cancello Auto
    $( "#auto" ).on('click keyCode',switch_auto);
    
    //Funzione per effettuare il login
    function switch_auto(){
        var dataSet = [];
        var arrayData=	'{ "operazione" : "auto"}' ;


        // INIZIO CHIMATA AJAX
        $.ajax({
			  // definisco il tipo della chiamata
			  type: "POST",
			  // specifico la URL della risorsa da contattare
			  url: "../controller/gestione_impianto.php",
			  // passo dei dati alla risorsa remota
			  data: JSON.parse(arrayData),
			  // definisco il formato della risposta
			  dataType: "html",
			  // imposto un'azione per il caso di successo
			  success: function(risposta){
				  
				console.log(risposta);

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

	//Gestione pressione bottone Cancello Pedone
    $( "#pedone" ).on('click keyCode',switch_pedone);
    
    
    function switch_pedone(){
        var dataSet = [];
        var arrayData=	'{ "operazione" : "pedone"}' ;


        // INIZIO CHIMATA AJAX
        $.ajax({
			  // definisco il tipo della chiamata
			  type: "POST",
			  // specifico la URL della risorsa da contattare
			  url: "../controller/gestione_impianto.php",
			  // passo dei dati alla risorsa remota
			  data: JSON.parse(arrayData),
			  // definisco il formato della risposta
			  dataType: "html",
			  // imposto un'azione per il caso di successo
			  success: function(risposta){
				  
				console.log(risposta);

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

		//Gestione pressione bottone Portone
    $( "#portone" ).on('click keyCode',switch_portone);
    
    
    function switch_portone(){
        var dataSet = [];
        var arrayData=	'{ "operazione" : "portone"}' ;


        // INIZIO CHIMATA AJAX
        $.ajax({
			  // definisco il tipo della chiamata
			  type: "POST",
			  // specifico la URL della risorsa da contattare
			  url: "../controller/gestione_impianto.php",
			  // passo dei dati alla risorsa remota
			  data: JSON.parse(arrayData),
			  // definisco il formato della risposta
			  dataType: "html",
			  // imposto un'azione per il caso di successo
			  success: function(risposta){
				  
				console.log(risposta);

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

	//Gestione pressione bottone Porta
    $( "#porta" ).on('click keyCode',switch_porta);
    
    
    function switch_porta(){
        var dataSet = [];
        var arrayData=	'{ "operazione" : "porta"}' ;


        // INIZIO CHIMATA AJAX
        $.ajax({
			  // definisco il tipo della chiamata
			  type: "POST",
			  // specifico la URL della risorsa da contattare
			  url: "../controller/gestione_impianto.php",
			  // passo dei dati alla risorsa remota
			  data: JSON.parse(arrayData),
			  // definisco il formato della risposta
			  dataType: "html",
			  // imposto un'azione per il caso di successo
			  success: function(risposta){
				  
				console.log(risposta);

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