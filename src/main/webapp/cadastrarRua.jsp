<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastrar Rua</title>

<script src="./js/listarCidades.js"></script>
 
<script type="text/javascript">
	$(document).ready(function() {
		$("input[name='cep'").mask("99.999-999");
		//$('input.decimal').mask('#.##0,00');

	});
</script>
</head>
<body>

	<div id="cadastrarRua">
		<!-- cadastrar Rua -->

		<div id="formularioRua"
			style="float: left; margin-left: -15%; margin-top: -2%;">

			<form style="border: 10px; margin-left: 400px; margin-top: 80px;"
				action="
      ControllerCadastrarRua" method="POST">

				<legend style="">Cadastrar Endereço</legend>

				<!--
      <img class="img" onclick="modal(3);" style="width: 30px; height: 30px;" src="./img/adicionar.png">
       -->



				<div class="form-row" style="margin-top: 10%;">

					<div class="form-group col-md-4">
						<label for="inputEstado">Estado <img class="img"
							style="width: 30px; height: 30px;" src="./img/adicionar.png"></label>
						<select name="estado" id="estados" class="form-control">
							<!-- <option selected>Escolher...</option> -->
							<!-- <option>...</option> -->
							<option id="estados2" selected>Escolher...</option>
							<option value="AC">Acre</option>
							<option value="AL">Alagoas</option>
							<option value="AP">Amapá</option>
							<option value="AM">Amazonas</option>
							<option value="BA">Bahia</option>
							<option value="CE">Ceará</option>
							<option value="DF">Distrito Federal</option>
							<option value="ES">Espírito Santo</option>
							<option value="GO">Goiás</option>
							<option value="MA">Maranhão</option>
							<option value="MT">Mato Grosso</option>
							<option value="MS">Mato Grosso do Sul</option>
							<option value="MG">Minas Gerais</option>
							<option value="PA">Pará</option>
							<option value="PB">Paraíba</option>
							<option value="PR">Paraná</option>
							<option value="PE">Pernambuco</option>
							<option value="PI">Piauí</option>
							<option value="RJ">Rio de Janeiro</option>
							<option value="RN">Rio Grande do Norte</option>
							<option value="RS">Rio Grande do Sul</option>
							<option value="RO">Rondônia</option>
							<option value="RR">Roraima</option>
							<option value="SC">Santa Catarina</option>
							<option value="SP">São Paulo</option>
							<option value="SE">Sergipe</option>
							<option value="TO">Tocantins</option>
						</select>
					</div>


					<div class="form-group col-md-4">
						<label for="inputCity">Cidade <img id="imgCidade"
							class="img" style="width: 30px; height: 30px;"
							onclick="getData(2);" src="./img/adicionar.png"></label> <select
							id="cidades" name="cidades" class="form-control"></select>
					</div>

					<div class="form-group col-md-4">
						<label for="inputCity">Bairro <img class="img"
							id="imgBairro" onclick="getData(3)"
							style="width: 30px; height: 30px;" src="./img/adicionar.png"></label>
						<select id="bairro" name="bairro" class="form-control">

						</select>
					</div>


				</div>
				<!-- linha -->

				<div class="form-row" style="margin-top: 1%;">

					<div class="form-group col-md-12">
						<label for="inputAddress">Endereço</label> <input type="text"
							class="form-control" name="endereco" id="endereco"
							placeholder="Rua dos Bobos, nº 0">
					</div>


					<div class="form-group col-md-6">
						<label for="inputCEP">CEP</label> <input type="text"
							class="form-control" name="cep" id="cep">
					</div>

					<div class="form-group col-md-12">
						<input type="hidden" name="cadastrarBairro"
							value="cadastrarEndereco">
					</div>
				</div>



				<button type="submit" class="btn btn-primary">Cadastrar</button>

				<p>
					<a href="listarCidades.php">
				</p>
				listar Cidades
				<p>
					</a>
				</p>
		</div>
		<!-- linha -->

		</form>


	</div>
	<!-- formulario rua -->

	</div>
	<!-- cadastrar rua -->

	</a>
	</p>
	</form>
	</div>
	</div>
</body>
</html>
