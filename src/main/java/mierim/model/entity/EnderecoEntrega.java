/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mierim.model.entity;

/**
 *
 * @author Administrator
 */

import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class EnderecoEntrega implements Serializable {

	private static final long serialVersionUID = 1L;


	@NotEmpty @Size(max = 150)
	@Column(name = "entrega_logradouro", nullable = false, length = 150)
	private String logradouro;

	@NotEmpty @Size(max = 20)
	@Column(name = "entrega_numero", nullable = false, length = 20)
	private String numero;

	@Size(max = 150)
	@Column(name = "entrega_complemento", length = 150)
	private String complemento;

	@NotEmpty @Size(max = 60)
	@Column(name = "entrega_cidade", nullable = false, length = 60)
	private String cidade;

	@NotEmpty @Size(max = 60)
	@Column(name = "entrega_uf", nullable = false, length = 60)
	private String uf;

	@NotEmpty @Size(max = 9)
	@Column(name = "entrega_cep", nullable = false, length = 9)
	private String cep;

}
