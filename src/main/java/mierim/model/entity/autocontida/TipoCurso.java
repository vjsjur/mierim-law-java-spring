package mierim.model.entity.autocontida;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public enum TipoCurso {

	CORDAS("Cordas"),
	MADEIRAS("Madeiras"),
	METAIS("Metais"),
	PERCUSSAO("Percussão");
	
	private String label;

}
