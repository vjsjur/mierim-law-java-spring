package mierim.model.entity.compras;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public enum StatusPedido {

	ORCAMENTO("Orçamento"), 
	EMITIDO("Emitido"), 
	CANCELADO("Cancelado");
	
	private String descricao;

}
