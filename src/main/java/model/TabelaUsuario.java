package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tabela_usuario database table.
 * 
 */
@Entity
@Table(name="tabela_usuario")
@NamedQuery(name="TabelaUsuario.findAll", query="SELECT t FROM TabelaUsuario t")
public class TabelaUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_usuario")
	private int idUsuario;

	@Column(name="cpf_usuario")
	private String cpfUsuario;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_cadastro_usuario")
	private Date dataCadastroUsuario;

	@Column(name="e_mail_usuario")
	private String eMailUsuario;

	@Column(name="nome_usuario")
	private String nomeUsuario;

	@Column(name="rg_usuario")
	private String rgUsuario;

	@Column(name="telefone_usuario")
	private String telefoneUsuario;

	public TabelaUsuario() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getCpfUsuario() {
		return this.cpfUsuario;
	}

	public void setCpfUsuario(String cpfUsuario) {
		this.cpfUsuario = cpfUsuario;
	}

	public Date getDataCadastroUsuario() {
		return this.dataCadastroUsuario;
	}

	public void setDataCadastroUsuario(Date dataCadastroUsuario) {
		this.dataCadastroUsuario = dataCadastroUsuario;
	}

	public String getEMailUsuario() {
		return this.eMailUsuario;
	}

	public void setEMailUsuario(String eMailUsuario) {
		this.eMailUsuario = eMailUsuario;
	}

	public String getNomeUsuario() {
		return this.nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getRgUsuario() {
		return this.rgUsuario;
	}

	public void setRgUsuario(String rgUsuario) {
		this.rgUsuario = rgUsuario;
	}

	public String getTelefoneUsuario() {
		return this.telefoneUsuario;
	}

	public void setTelefoneUsuario(String telefoneUsuario) {
		this.telefoneUsuario = telefoneUsuario;
	}

}