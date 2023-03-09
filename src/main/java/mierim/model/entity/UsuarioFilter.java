package mierim.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private String rg;
	private String cpf;

	
}
