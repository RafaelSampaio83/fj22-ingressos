package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.caelum.ingresso.model.desconto.Desconto;

@Entity
public class Ingresso {
	@Id
	@GeneratedValue
	private Integer id;
	@ManyToOne
	private Sessao sessao;
	
	@ManyToOne
	private Lugar lugar;
	
	private BigDecimal preco;
	@Enumerated(EnumType.STRING)
	private TipoDeIngresso tipoDeIngresso;
	
	public Ingresso(Sessao sessao, TipoDeIngresso tipoDeIngrresso, Lugar lugar) {
		
		this.setLugar(lugar);
	}

	/**
	 * @deprecated hibernate only
	 */
	public Ingresso() {

	}

	public Ingresso(Sessao sessao, Desconto tipoDeDesconto) {
		this.setSessao(sessao);
		this.preco = tipoDeDesconto.aplicarDescontoSobre(sessao.getPreco());

	}

	public BigDecimal getPreco() {
		return preco.setScale(2, RoundingMode.HALF_UP);
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Lugar getLugar() {
		return lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

	public TipoDeIngresso getTipoDeIngresso() {
		return tipoDeIngresso;
	}

	public void setTipoDeIngresso(TipoDeIngresso tipoDeIngresso) {
		this.tipoDeIngresso = tipoDeIngresso;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}
}
