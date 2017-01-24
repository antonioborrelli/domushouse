/* ========================================================================
 * Settings: index 0.1.js
 * ========================================================================
 * Componente utilizzato per gestire il login
 * ======================================================================== */

$(function() {

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
			  url: "../controller/query_utente.php",
			  // passo dei dati alla risorsa remota
			  data: JSON.parse(arrayData),
			  // definisco il formato della risposta
			  dataType: "html",
			  // imposto un'azione per il caso di successo
			  success: function(risposta){
				  
				console.log(risposta);

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