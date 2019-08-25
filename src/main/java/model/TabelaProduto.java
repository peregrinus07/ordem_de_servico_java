package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the tabela_produto database table.
 * 
 */
@Entity
@Table(name="tabela_produto")
@NamedQuery(name="TabelaProduto.findAll", query="SELECT t FROM TabelaProduto t")
public class TabelaProduto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_produto")
	private int idProduto;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_entrada_produto")
	private Date dataEntradaProduto;

	@Column(name="descricao_produto")
	private String descricaoProduto;

	@Column(name="id_categoria_produto")
	private int idCategoriaProduto;

	@Column(name="nome_produto")
	private String nomeProduto;

	@Column(name="preco_de_compra_produto")
	private BigDecimal precoDeCompraProduto;

	@Column(name="preco_de_venda_produto")
	private BigDecimal precoDeVendaProduto;

	@Column(name="quantidade_entrada_produto")
	private int quantidadeEntradaProduto;

	@Column(name="quantidade_minima_estoque_produto")
	private int quantidadeMinimaEstoqueProduto;

	@Column(name="quantidade_produto_estoque_produto")
	private int quantidadeProdutoEstoqueProduto;

	public TabelaProduto() {
	}

	public int getIdProduto() {
		return this.idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public Date getDataEntradaProduto() {
		return this.dataEntradaProduto;
	}

	public void setDataEntradaProduto(Date dataEntradaProduto) {
		this.dataEntradaProduto = dataEntradaProduto;
	}

	public String getDescricaoProduto() {
		return this.descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public int getIdCategoriaProduto() {
		return this.idCategoriaProduto;
	}

	public void setIdCategoriaProduto(int idCategoriaProduto) {
		this.idCategoriaProduto = idCategoriaProduto;
	}

	public String getNomeProduto() {
		return this.nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public BigDecimal getPrecoDeCompraProduto() {
		return this.precoDeCompraProduto;
	}

	public void setPrecoDeCompraProduto(BigDecimal precoDeCompraProduto) {
		this.precoDeCompraProduto = precoDeCompraProduto;
	}

	public BigDecimal getPrecoDeVendaProduto() {
		return this.precoDeVendaProduto;
	}

	public void setPrecoDeVendaProduto(BigDecimal precoDeVendaProduto) {
		this.precoDeVendaProduto = precoDeVendaProduto;
	}

	public int getQuantidadeEntradaProduto() {
		return this.quantidadeEntradaProduto;
	}

	public void setQuantidadeEntradaProduto(int quantidadeEntradaProduto) {
		this.quantidadeEntradaProduto = quantidadeEntradaProduto;
	}

	public int getQuantidadeMinimaEstoqueProduto() {
		return this.quantidadeMinimaEstoqueProduto;
	}

	public void setQuantidadeMinimaEstoqueProduto(int quantidadeMinimaEstoqueProduto) {
		this.quantidadeMinimaEstoqueProduto = quantidadeMinimaEstoqueProduto;
	}

	public int getQuantidadeProdutoEstoqueProduto() {
		return this.quantidadeProdutoEstoqueProduto;
	}

	public void setQuantidadeProdutoEstoqueProduto(int quantidadeProdutoEstoqueProduto) {
		this.quantidadeProdutoEstoqueProduto = quantidadeProdutoEstoqueProduto;
	}

}