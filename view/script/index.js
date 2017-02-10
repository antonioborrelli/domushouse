/* ========================================================================
 * Settings: index 0.1.js
 * ========================================================================
 * Componente utilizzato per gestire il login
 * ======================================================================== */

$(function() {

    //Gestione pressione bottone Salva
    $( "#login" ).on('click keyCode',login);
    $("body").keypress(function(e) {
    	  if (e.which == 13) {
    		  login();
    	  }
    	});
  
    //Funzione per effettuare il login
    function login(){
        var dataSet = [];
        var arrayData=	'{'+
                        '"operazione" : "login_utente",' +
                        '"username" : "'+$( "#username" ).val()+'",' +
                        '"password" : "'+$( "#password" ).val()+'"}' ;


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
				
				 var result = JSON.parse(risposta);
	  				
	  				if(result != null && result.stato==1){
	  					window.location.replace("../view/home.php");
	  				}else{

	  					$(".row_error").show();
	  					$(".msg_error").html(result.msg);
	  					$( "#username" ).val("");
	                	$( "#password" ).val("");
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