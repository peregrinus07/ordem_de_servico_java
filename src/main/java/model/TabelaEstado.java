package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tabela_estado database table.
 * 
 */
@Entity
@Table(name="tabela_estado")
@NamedQuery(name="TabelaEstado.findAll", query="SELECT t FROM TabelaEstado t")
public class TabelaEstado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_estado")
	private int idEstado;

	@Column(name="nome_estado")
	private String nomeEstado;

	@Column(name="sigla_estado")
	private String siglaEstado;

	//bi-directional many-to-one association to TabelaCidade
	@OneToMany(mappedBy="tabelaEstado")
	private List<TabelaCidade> tabelaCidades;

	public TabelaEstado() {
	}

	public int getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getNomeEstado() {
		return this.nomeEstado;
	}

	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}

	public String getSiglaEstado() {
		return this.siglaEstado;
	}

	public void setSiglaEstado(String siglaEstado) {
		this.siglaEstado = siglaEstado;
	}

	public List<TabelaCidade> getTabelaCidades() {
		return this.tabelaCidades;
	}

	public void setTabelaCidades(List<TabelaCidade> tabelaCidades) {
		this.tabelaCidades = tabelaCidades;
	}

	public TabelaCidade addTabelaCidade(TabelaCidade tabelaCidade) {
		getTabelaCidades().add(tabelaCidade);
		tabelaCidade.setTabelaEstado(this);

		return tabelaCidade;
	}

	public TabelaCidade removeTabelaCidade(TabelaCidade tabelaCidade) {
		getTabelaCidades().remove(tabelaCidade);
		tabelaCidade.setTabelaEstado(null);

		return tabelaCidade;
	}

}