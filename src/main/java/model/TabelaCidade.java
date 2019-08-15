package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tabela_cidade database table.
 * 
 */
@Entity
@Table(name="tabela_cidade")
@NamedQuery(name="TabelaCidade.findAll", query="SELECT t FROM TabelaCidade t")
public class TabelaCidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_cidade")
	private int idCidade;

	@Column(name="nome_cidade")
	private String nomeCidade;

	//bi-directional many-to-one association to TabelaBairro
	@OneToMany(mappedBy="tabelaCidade")
	private List<TabelaBairro> tabelaBairros;

	//bi-directional many-to-one association to TabelaEstado
	@ManyToOne
	@JoinColumn(name="id_estado")
	private TabelaEstado tabelaEstado;

	public TabelaCidade() {
	}

	public int getIdCidade() {
		return this.idCidade;
	}

	public void setIdCidade(int idCidade) {
		this.idCidade = idCidade;
	}

	public String getNomeCidade() {
		return this.nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public List<TabelaBairro> getTabelaBairros() {
		return this.tabelaBairros;
	}

	public void setTabelaBairros(List<TabelaBairro> tabelaBairros) {
		this.tabelaBairros = tabelaBairros;
	}

	public TabelaBairro addTabelaBairro(TabelaBairro tabelaBairro) {
		getTabelaBairros().add(tabelaBairro);
		tabelaBairro.setTabelaCidade(this);

		return tabelaBairro;
	}

	public TabelaBairro removeTabelaBairro(TabelaBairro tabelaBairro) {
		getTabelaBairros().remove(tabelaBairro);
		tabelaBairro.setTabelaCidade(null);

		return tabelaBairro;
	}

	public TabelaEstado getTabelaEstado() {
		return this.tabelaEstado;
	}

	public void setTabelaEstado(TabelaEstado tabelaEstado) {
		this.tabelaEstado = tabelaEstado;
	}

}