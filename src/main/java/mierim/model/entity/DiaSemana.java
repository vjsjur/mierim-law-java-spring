package mierim.model.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public enum DiaSemana {

	SEGUNDA("Segunda-Feira"),
	QUARTA("Quarta-Feira"),
	SEXTA("Quinta-Feira");
	
	private String label;
}
