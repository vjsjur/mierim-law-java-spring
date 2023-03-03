package mierim.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "cad_escritorio")
public class Escritorio implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "PREENCHA O CÓDIGO!")
    private String codigo;

    @NotEmpty(message = "PREENCHA O NOME!")
    private String nome;

    @NotEmpty(message = "PREENCHA A RAZÃO SOCIAL!")
    private String razao;

    @NotEmpty(message = "PREENCHA O CNPJ!")
    private String cnpj;

    @NotEmpty(message = "PREENCHA O STATUS")
    private String status;

    @Temporal(TemporalType.DATE)
    @NotNull(message = "PREENCHA A DATA!")
    private Date dt_cadastro;
    private String emite_fat;
    private String emite_nfe;
    private String emite_nfse;
    private String deletado = "2";
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String unidade_federativa;
    private String pais;

    @ManyToOne
    @JoinColumn(name = "id_pais")
    private Pais id_pais;

    @ManyToOne
    @JoinColumn(name = "id_municipio")
    private Municipio municipio;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private UnidadeFederativa id_estado;

}
