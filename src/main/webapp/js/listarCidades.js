
$( document ).ready(function() {
 
 $("#estados").change(function() {
    //$('#pesquisaCliente').keyup(function(){
         
 
        // input[name='pesquisaCliente'
         var $nomeAluno = $("#estados");


          var $teste = $("#estados");
          //alert($teste.val());
          //alert ($nomeAluno.val());    

 
        $.ajax({


          url: 'Cidade',
          type: 'POST',
          data: {id: $nomeAluno.val(), logradouro:"cidades"},

          beforeSend: function(){
          $("#cidades").css({'display':'block'});
            //$("body").html('<p>Carregando...</p>');
            $("#cidades").html('<p>Carregando</p>');

        },

          success: function(data)
                {
                  console.log(data);
                    $("#cidades").css({'display':'block'});
                    $("#cidades").html("");
                    $("#cidades").html(data);
                     
                },

                 error: function(data)
                {

                    $("#cidades").css({'display':'block'});
                    $("#cidades").html("Houve um erro ao carregar");
                    console.log("erro ao carregar cidades");  
                     
                }

        }); // estados


    }); // estados

   $("#cidades").change(function() {

     //alert();

    var $nomeAluno = $("#cidades");

    var $estado = $("#estados").val();
    //alert($nomeCidade.val());
    //alert($estado);
    $.ajax({
        
                  url: 'Cidade',
                  type: 'POST',
                  data: {id: $nomeAluno.val(), logradouro:"bairros", estado: $estado,},
        
                  beforeSend: function(){
                  $("#bairro").css({'display':'block'});
                    //$("body").html('<p>Carregando...</p>');
                    $("#bairro").html('<p>Carregando</p>');
        
                },
        
                  success: function(data)
                        {
                          console.log(data);
                            $("#bairro").css({'display':'block'});
                            $("#bairro").html("");
                            $("#bairro").html(data);
                             
                        },
        
                         error: function(data)
                        {
                             
                            $("#bairro").css({'display':'block'});
                            $("#bairro").html("Houve um erro ao carregar");
                        }
        
                }); 


   }); // end cidades


        //listar endereços
      $("#endereco").keyup(function(){
       // alert("teste");
        // select cidade
        var cidade = $("#cidades option:selected").val();


        if(cidade =="" || cidade =="registre uma cidade" || cidade==null){

             alert("Selecione uma Cidade");

        }

        else {

         var bairro = $("#bairro option:selected").val();

         if(bairro =="" || bairro =="Selecione um bairro" || bairro==null){

             alert("Selecione um bairro");

         } // if


        }

        var rua = $("#endereco").val()
        var teste = $("#bairro option:selected").val();
        var logradouro = "logradouro"; 

 
         //alert(teste);

        //var QtdAcomodacaoD = $("#cidades option:selected").val();

       //var QtdAcomodacaoD = "CE";
      //  alert(QtdAcomodacaoD);

    //var nome = $("#test").val();

    //var nome =  $("#cidades").val();

    //alert("Value: " + nome);

    //alert("uia");    

        /*
       
        $.ajax({
            
            url: 'Cidade',
            type: 'POST',
            data: {logradouro:"logradouro", id:teste },
  
            beforeSend: function(){
           // $("#bairro").css({'display':'block'});
              //$("body").html('<p>Carregando...</p>');
             // $("#bairro").html('<p>Carregando</p>');
  
          },
  
            success: function(data)
                  {
                    console.log(data);
                      
                     // $("#bairro").html(data);
                       
                  },
  
                   error: function(data)
                  {
                       
                      //alert("erro ao carregar cidades");
                  }
  
          }); // ajax
*/
	 
        
    //console.log("bairro selecionado: "+teste);
   $("#endereco").autocomplete({
    


     // fonte dos dados
     source: "Cidade?rua="+rua+"&teste=" + teste +"&logradouro="+logradouro+ "",

      });


     }); // listar ruas
 



}); // end document
