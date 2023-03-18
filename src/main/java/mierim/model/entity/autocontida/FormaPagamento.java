package mierim.model.entity.autocontida;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public enum FormaPagamento {

	DINHEIRO("Dinheiro"), 
	CARTAO_CREDITO("Cartão de crédito"), 
	CARTAO_DEBITO("Cartão de débito"), 
	CHEQUE("Cheque"), 
	BOLETO_BANCARIO("Boleto bancário"), 
	DEPOSITO_BANCARIO("Depósito bancário"),
	CARNE_DA_CASA("Carnê da casa");
	
	private String descricao;

	
}
