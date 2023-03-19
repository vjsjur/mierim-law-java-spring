package mierim.model.entity.sistema;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private String rg;
	private String cpf;

	@NotNull(message = "Preencha o Grupo Econômico!")
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tenant")
	private Sis_CompanyGroup sis_company_group;

	
}
