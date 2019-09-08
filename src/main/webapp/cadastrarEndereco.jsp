<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Cadastrar Endereco</title>


<script type="text/javascript" src="./js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="./css/bootstrap.min.css">

<link rel="stylesheet" href="./css/bootstrap.min.css">

<script src="./js/jquery-ui.min.js"></script>
<link rel="stylesheet" href="./js/jquery-ui.css">


<script type="text/javascript" src="./js/jquery.mask.js"></script>

<script type="text/javascript" src="./js/maskMoney.min.js"></script>

<script src="./js/bootstrap.min.js"></script>


<script src="./js/bootstrap.min.js"></script>

<script src="./js/listarCidades.js"></script>

<script>
	function getData(cont) {

		if (cont == 1) {

			$(".conteudo").load('cadastrarRua.jsp');

		} // if

		if (cont == 2) {

			$(".conteudo").load('cadastrarCidade.jsp');

		} // if

		if (cont == 3) {

			console.log("teste")

			$(".conteudo").load('cadastrarBairro.jsp');

		} // if

	}

	$(document).ready(function() {

		$("#imgCidade").click(function(event) {

			alert();
			$("#cadastrarRua").hide("slow");
			$("#cadastrarCidade").show("slow");

		})// on

		$("#imgBairro").click(function(event) {

			alert();
			$("#cadastrarRua").hide("slow");
			$("#cadastrarCidade").hide("slow");
			$("#cadastrarbairro").show("slow");

		})// on

		// 

		$("input[name='cep'").mask("99.999-999");
		//$('input.decimal').mask('#.##0,00');

	});

	function onloadPagina() {

		$(".img").show();

	}
</script>

</head>

<body onload="getData(1);">

	<div class="container">


		<%@include file="template/menu.jsp"%>
		<!--   <?php include("menu.php") ?>
	-->


		<div class="conteudo"></div>
		<!-- conteudo -->



	</div>
	<!-- container -->
</body>
</html>