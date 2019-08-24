<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv= "Content-Type" content= "text/html; charset=iso-8859-1" > 
 
<title>teste</title>


<script type="text/javascript" src="./js/jquery-3.3.1.min.js"></script>

<link rel="stylesheet" href="./css/bootstrap.min.css">

<script src="./js/jquery-ui.min.js"></script>
<link rel="stylesheet" href="./js/jquery-ui.css">


<script type="text/javascript" src="./js/jquery.mask.js"></script>

<script type="text/javascript" src="./js/maskMoney.min.js"></script>

<script src="./js/bootstrap.min.js"></script>
 
<script src="./js/listarCidades.js"></script>

<script src="./js/letrasMaiusculas.js"></script>

<script>
	 
</script>

</head>
<body>

<%@include file="template/menu.jsp" %>
<!-- 
	<h1>
		horas :
		<%=new SimpleDateFormat("hh:mm:ss").format(new Date())%></h1>
	<%
		out.println("a");
		int dia = Integer.parseInt((new SimpleDateFormat("dd")).format(new Date()));
		int mes = Integer.parseInt((new SimpleDateFormat("M")).format(new Date()));
		int ano = Integer.parseInt((new SimpleDateFormat("yyyy")).format(new Date()));

		if (mes == 8) {
			out.println("teste");
		}
	%>
	<br>	<%=new Date()%></body>
	
	
	<form action="CadastrarCliente" method="post">
            Nome:<input type="text" name="txtnome"/><br>
            E-Mail:<input type="text" name="txtemail"/><br>
            Data de Nascimento:<input type="text" name="txtdtnasc"/><br>
            <input type="submit" value="Enviar"/>
 
        </form>
      -->   
        
      <form name="formulario"   id="formulario" class="form-group" style="border:10px; margin-left: 50px; margin-top: 75px;" action="CadastrarCliente" method="POST">
   
      <legend style="">Cadastrar Cliente</legend>

    <div class="form-group">
    <label for="inputAddress">Nome:</label>
    <input id="nomeCliente" onkeyup="upCase(this);" type="text" name="nomeCliente" class="form-control" id="inputAddress" placeholder="">
    </div>
    <div class="form-row">
    <div class="form-group col-md-4">
      <label for="inputEmail4">Email <span id="validacao">*</span></label>
      <input onkeyup="IsEmail(this);" id="email"  type="email" name="email" class="form-control" id="inputEmail4" placeholder="Email">
    </div>
    <div class="form-group col-md-4">
      <label for="inputPassword4">Telefone</label>
      <input type="text" name="telefone" class="form-control" id="telefone" placeholder="">
    </div>
  <div class="form-group col-md-4">
      <label for="inputPassword4">Cpf:</label>
      <input type="text" name="cpf" class="form-control" id="cpf" placeholder="">
    </div>

  </div> <!-- form - row -->
  
   <div class="form-row">
     
	     <div class="form-group col-md-4">
	      <label for="inputEstado">Estado</label>
	      <select name="estado" id="estados" class="form-control">
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

</div> <!-- linha -->

      <div class="form-group col-md-4">
      <label for="inputCity">Cidade</label>
      <select id="cidades" name="cidades" class="form-control"></select>
     </div>

      <div class="form-group col-md-4">
      <label for="inputCity">Bairro</label>
      <select id="bairro" name="bairro" class="form-control">
       
      </select>
      </div>

<div class="form-group col-md-6">
    <label for="inputAddress">Endereço</label>
    <input onkeyup="upCase(this);" onblur="upCase(this)" type="text" class="form-control" name="endereco" id="endereco" placeholder="Rua dos Bobos, nº 0">
  </div>

  <div class="form-group col-md-2">
    <label for="inputAddress">Numero</label>
    <input onkeyup="upCase(this);" type="text" class="form-control" name="numero" id="numero" placeholder="Nº">
  </div>
  
 <div class="form-group col-md-4">
      <label for="inputCEP">CEP</label>
      <input type="text" class="form-control" name="cep" id="cep">
    </div>

   </div> <!-- form-row -->

<button id="botao" onclick="validar();" type="submit" class="btn btn-primary" >Cadastrar</button>
<button type="button" id="limparCampos" class="btn btn-danger">Limpar Campos</button>

      <p><a href="listarClientes.php"><p>Listar Clientes<p></a><p>

    </form>

    </div> <!-- formulario cliente -->    

  
    </div> <!-- coluna -->     


    </div> <!-- linha -->


<!-- roda pe -->
<!-- linha -->
  <div class="row"> 

    <div class="col-md-12">
      <!-- 
        <h4  style="margin-right: 425px; margin-top:500px;">@LinuxProCe - 2019</h4>
-->
    </div> <!-- linha -->


    </div>
    <!-- coluna -->
       

      

    <!-- 
    <div class="col" style="background-color:orange;">.col</div>
    <div class="col" style="background-color:lavender;">.col</div>
    -->
  </div> <!-- linha -->


  <script>
    
 $(document).ready(function(){

  //alert();



 })


  </script>
</html>