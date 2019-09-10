$(document).ready(function() {

	$("#estados").change(function() {
		// $('#pesquisaCliente').keyup(function(){

		// input[name='pesquisaCliente'
		var $nomeAluno = $("#estados");

		var $teste = $("#estados");
		// alert($teste.val());
		// alert ($nomeAluno.val());

		$.ajax({

			url : 'Cidade',
			type : 'POST',
			data : {
				id : $nomeAluno.val(),
				logradouro : "cidades"
			},

			beforeSend : function() {

				$("#cidades").css({
					'display' : 'block'
				});
				// $("body").html('<p>Carregando...</p>');
				$("#cidades").html('<p>Carregando</p>');

			},

			success : function(data) {
				console.log(data);
				$("#cidades").css({
					'display' : 'block'
				});
				$("#cidades").html("");
				$("#cidades").html(data);

			},

			error : function(data) {

				$("#cidades").css({
					'display' : 'block'
				});
				$("#cidades").html("Houve um erro ao carregar");
				console.log("erro ao carregar cidades");

			}

		}); // estados

	}); // estados

})