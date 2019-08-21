package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tabela_descricao_rua database table.
 * 
 */
@Entity
@Table(name="tabela_descricao_rua")
@NamedQuery(name="TabelaDescricaoRua.findAll", query="SELECT t FROM TabelaDescricaoRua t")
public class TabelaDescricaoRua implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_descricao_rua")
	private int idDescricaoRua;

	@Column(name="fk_id_tipo_da_rua")
	private int fkIdTipoDaRua;

	@Column(name="nome_da_rua")
	private String nomeDaRua;

	//bi-directional many-to-one association to TabelaBairro
	@ManyToOne
	@JoinColumn(name="id_bairro")
	private TabelaBairro tabelaBairro;

	public TabelaDescricaoRua() {
	}

	public int getIdDescricaoRua() {
		return this.idDescricaoRua;
	}

	public void setIdDescricaoRua(int idDescricaoRua) {
		this.idDescricaoRua = idDescricaoRua;
	}

	public int getFkIdTipoDaRua() {
		return this.fkIdTipoDaRua;
	}

	public void setFkIdTipoDaRua(int fkIdTipoDaRua) {
		this.fkIdTipoDaRua = fkIdTipoDaRua;
	}

	public String getNomeDaRua() {
		return this.nomeDaRua;
	}

	public void setNomeDaRua(String nomeDaRua) {
		this.nomeDaRua = nomeDaRua;
	}

	public TabelaBairro getTabelaBairro() {
		return this.tabelaBairro;
	}

	public void setTabelaBairro(TabelaBairro tabelaBairro) {
		this.tabelaBairro = tabelaBairro;
	}

}