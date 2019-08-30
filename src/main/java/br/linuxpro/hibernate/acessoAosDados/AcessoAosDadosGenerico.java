package br.linuxpro.hibernate.acessoAosDados;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.linuxpro.util.HibernateUtil;

public class AcessoAosDadosGenerico<Ob> {

	@SuppressWarnings("unused")
	private Class<Ob> classe;

	@SuppressWarnings("unchecked")
	public AcessoAosDadosGenerico() {

		this.classe = (Class<Ob>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

	}

	public void salvar(Ob ob) {

		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {

			transacao = session.beginTransaction();

			session.save(ob);
			transacao.commit();

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

	@SuppressWarnings("unchecked")
	public List<Ob> listar() {

		Session session = HibernateUtil.getFabricaDeSessoes().openSession();

		try {

			Criteria consulta = session.createCriteria(classe);
			List<Ob> resultado = consulta.list();
			return resultado;

		} catch (RuntimeException e) {
			// TODO: handle exception

			throw e;

		}

		finally {
			session.close();

		}

	} // function

	@SuppressWarnings("unchecked")
	public Ob buscar(int codigo) {

		Session session = HibernateUtil.getFabricaDeSessoes().openSession();

		try {

			Criteria consulta = session.createCriteria(classe);
			consulta.add(Restrictions.idEq(codigo));

			Ob resultado = (Ob) consulta.uniqueResult();
			return resultado;

		} catch (RuntimeException e) {
			// TODO: handle exception

			throw e;

		}

		finally {
			session.close();

		}

	} // function

	public void excluir(Ob ob) {

		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {

			transacao = session.beginTransaction();
			session.delete(ob);
			transacao.commit();

		} catch (RuntimeException e) {

			if (transacao != null) {
				transacao.rollback();
			}

			throw e;

		}

		finally {
			session.close();

		}

	} // function

	public void editar(Ob ob) {

		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {

			transacao = session.beginTransaction();
			session.update(ob);
			transacao.commit();

		} catch (RuntimeException e) {

			if (transacao != null) {
				transacao.rollback();
			}

			throw e;

		}

		finally {
			session.close();

		}

	} // function

}
