package mierim.model.entity.faturamento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mierim.model.entity.rhumanos.Departamento;
import mierim.model.entity.rhumanos.Cargo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.persistence.Version;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "cad_contato")
public class Contato implements Serializable {

    private static final long serialVersionUID = -4451928900154383946L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(6) ZEROFILL")
    private Integer id;

    @Version
    private Long version;
    private String tratamento;
    private String nome;
    private String cpf;
    private String status;
    private String deletado  = "2";
    private String cep;
    private String bairro;
    private String endereco;
    private String complemento;
    private String telefone;
    private String ramal;
    private String celular;
    private String email;
    private String sexo;

    @Transient
    private String filtro;

    @Transient
    private String filtro_tipo;

    @ManyToOne
    @JoinColumn(name = "id_cargo")
    private Cargo cargo;

    @ManyToOne
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;

}
