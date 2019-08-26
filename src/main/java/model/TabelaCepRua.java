package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tabela_cep_rua database table.
 * 
 */
@Entity
@Table(name="tabela_cep_rua")
@NamedQuery(name="TabelaCepRua.findAll", query="SELECT t FROM TabelaCepRua t")
public class TabelaCepRua implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_cep_rua")
	private int idCepRua;

	@Column(name="cep_rua")
	private String cepRua;

	//bi-directional many-to-one association to TabelaDescricaoRua
	@ManyToOne
	@JoinColumn(name="id_rua")
	private TabelaDescricaoRua tabelaDescricaoRua;

	public TabelaCepRua() {
	}

	public int getIdCepRua() {
		return this.idCepRua;
	}

	public void setIdCepRua(int idCepRua) {
		this.idCepRua = idCepRua;
	}

	public String getCepRua() {
		return this.cepRua;
	}

	public void setCepRua(String cepRua) {
		this.cepRua = cepRua;
	}

	public TabelaDescricaoRua getTabelaDescricaoRua() {
		return this.tabelaDescricaoRua;
	}

	public void setTabelaDescricaoRua(TabelaDescricaoRua tabelaDescricaoRua) {
		this.tabelaDescricaoRua = tabelaDescricaoRua;
	}

}