package mierim.model.entity.compras;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mierim.model.entity.autocontida.Cidade;

import javax.validation.constraints.NotNull;

import javax.validation.constraints.NotEmpty;
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
	@JoinColumn(name = "id_cidade")
	@NotNull(message = "Selecione a cidade")
	private Cidade cidade = new Cidade();

}
