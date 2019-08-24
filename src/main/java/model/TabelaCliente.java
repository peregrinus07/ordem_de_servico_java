package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tabela_clientes database table.
 * 
 */
@Entity
@Table(name="tabela_clientes")
@NamedQuery(name="TabelaCliente.findAll", query="SELECT t FROM TabelaCliente t")
public class TabelaCliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_cliente")
	private int idCliente;

	@Column(name="cpf_cnpj_cliente")
	private String cpfCnpjCliente;

	@Column(name="e_mail_cliente")
	private String eMailCliente;

	@Column(name="nome_cliente")
	private String nomeCliente;

	@Column(name="telefone_cliente")
	private String telefoneCliente;

	public TabelaCliente() {
	}

	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getCpfCnpjCliente() {
		return this.cpfCnpjCliente;
	}

	public void setCpfCnpjCliente(String cpfCnpjCliente) {
		this.cpfCnpjCliente = cpfCnpjCliente;
	}

	public String getEMailCliente() {
		return this.eMailCliente;
	}

	public void setEMailCliente(String eMailCliente) {
		this.eMailCliente = eMailCliente;
	}

	public String getNomeCliente() {
		return this.nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getTelefoneCliente() {
		return this.telefoneCliente;
	}

	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}

}