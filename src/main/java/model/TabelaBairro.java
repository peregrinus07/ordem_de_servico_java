package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tabela_bairro database table.
 * 
 */
@Entity
@Table(name="tabela_bairro")
@NamedQuery(name="TabelaBairro.findAll", query="SELECT t FROM TabelaBairro t")
public class TabelaBairro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_bairro")
	private int idBairro;

	@Column(name="nome_bairro")
	private String nomeBairro;

	//bi-directional many-to-one association to TabelaCidade
	@ManyToOne
	@JoinColumn(name="id_cidade")
	private TabelaCidade tabelaCidade;

	//bi-directional many-to-one association to TabelaDescricaoRua
	@OneToMany(mappedBy="tabelaBairro")
	private List<TabelaDescricaoRua> tabelaDescricaoRuas;

	public TabelaBairro() {
	}

	public int getIdBairro() {
		return this.idBairro;
	}

	public void setIdBairro(int idBairro) {
		this.idBairro = idBairro;
	}

	public String getNomeBairro() {
		return this.nomeBairro;
	}

	public void setNomeBairro(String nomeBairro) {
		this.nomeBairro = nomeBairro;
	}

	public TabelaCidade getTabelaCidade() {
		return this.tabelaCidade;
	}

	public void setTabelaCidade(TabelaCidade tabelaCidade) {
		this.tabelaCidade = tabelaCidade;
	}

	public List<TabelaDescricaoRua> getTabelaDescricaoRuas() {
		return this.tabelaDescricaoRuas;
	}

	public void setTabelaDescricaoRuas(List<TabelaDescricaoRua> tabelaDescricaoRuas) {
		this.tabelaDescricaoRuas = tabelaDescricaoRuas;
	}

	public TabelaDescricaoRua addTabelaDescricaoRua(TabelaDescricaoRua tabelaDescricaoRua) {
		getTabelaDescricaoRuas().add(tabelaDescricaoRua);
		tabelaDescricaoRua.setTabelaBairro(this);

		return tabelaDescricaoRua;
	}

	public TabelaDescricaoRua removeTabelaDescricaoRua(TabelaDescricaoRua tabelaDescricaoRua) {
		getTabelaDescricaoRuas().remove(tabelaDescricaoRua);
		tabelaDescricaoRua.setTabelaBairro(null);

		return tabelaDescricaoRua;
	}

}