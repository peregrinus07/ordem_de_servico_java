package br.linuxpro.hibernate.acessoAosDados;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Ignore;
import org.junit.Test;

import br.linuxpro.util.HibernateUtil;
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

	@Test
	public void teste() {

		TabelaCliente cliente = new TabelaCliente();

		cliente.setNomeCliente("Junit teste");
		cliente.setTelefoneCliente("1");
		cliente.setEMailCliente("a@gmail.com");
		cliente.setCpfCnpjCliente("1");

		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {

			transacao = session.beginTransaction();

			TabelaCliente teste = new TabelaCliente();

			Integer id = (Integer) session.save(cliente);

			System.out.println();
			session.flush(); // address will not get saved without this
			System.out.println("*****"+id);

			transacao.commit();

			System.out.println("teste" + id);

		} catch (RuntimeException e) {
			// TODO: handle exception

			if (transacao != null)
				transacao.rollback();
			throw e;

		}

		finally {
			session.close();

		}

	} // function
}
