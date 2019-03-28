package br.com.caelum.ingresso.model.desconto;

import java.math.BigDecimal;

public class DescontoParaBancos implements Desconto {
	@Override
	public BigDecimal aplicarDescontoSobre(BigDecimal precoOriginal) {
		return precoOriginal.subtract(trintaPorCentoSobre(precoOriginal));
		
	}
	private BigDecimal trintaPorCentoSobre(BigDecimal precoOrginal) {
		return precoOrginal.multiply(new BigDecimal("0.3"));
	}
	@Override
	public String getDescricao() {
		return "Desconto Banco";
	}
}
