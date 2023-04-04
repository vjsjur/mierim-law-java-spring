package mierim.model.entity.sistema;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Sis_UsuarioFilter implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String rg;
	private String cpf;

	@NotNull(message = "Preencha o Grupo Econômico!")
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tenant")
	private Sis_CompanyGroup sis_company_group;

	@NotNull(message = "Preencha a Empresa!")
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tenant_company")
	private Sis_CompanyEmpresa sis_empresa;

	@NotNull(message = "Preencha a Filial!")
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tenant_filial")
	private Sis_CompanyFilial sis_filial;

	
}
