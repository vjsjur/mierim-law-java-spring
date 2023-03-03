package mierim.model.entity;

import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String documentoReceitaFederal;

}
