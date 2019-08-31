package br.linuxpro.hibernate.acessoAosDados;

import org.junit.Ignore;
import org.junit.Test;

import model.TabelaCliente;

public class ClienteDbTest {

	@Test
	@Ignore
	public void salvar() {

		TabelaCliente cliente = new TabelaCliente();

		cliente.setNomeCliente("teste junit");
		cliente.setEMailCliente("a@gmail.com");
		cliente.setCpfCnpjCliente("1");
		cliente.setTelefoneCliente("1");

		ClienteDb clientedb = new ClienteDb();

		clientedb.salvar(cliente);

	} // function

	@Test
	@Ignore
	public void pesquisar() {

		TabelaCliente cliente = new TabelaCliente();

		cliente.setIdCliente(300);

		ClienteDb clientedb = new ClienteDb();

		cliente = clientedb.buscar(cliente.getIdCliente());

		if (cliente == null) {

			System.out.println("cliente não encontrado");
		} 
		
		else {

			System.out.println("cliente: " + cliente.getNomeCliente());
		}

	} //
}
