package mierim.model.entity.compras;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mierim.model.entity.autocontida.Municipio;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
@Entity
public class Endereco implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "Informe o logradouro")
	private String logradouro;

	@NotNull(message = "Informe o número!")
	private Integer numero;

	@NotEmpty(message = "Informe o cep")
	private String cep;

	@ManyToOne
	@JoinColumn(name = "id_municipio")
	@NotNull(message = "Selecione o Municipio")
	private Municipio municipio = new Municipio();

}
