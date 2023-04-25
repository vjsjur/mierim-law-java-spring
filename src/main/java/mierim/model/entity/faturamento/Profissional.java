package mierim.model.entity.faturamento;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mierim.model.entity.autocontida.Municipio;
import mierim.model.entity.financeiro.Centrocusto;
import mierim.model.entity.rhumanos.Cargo;
import mierim.model.entity.rhumanos.Departamento;
import mierim.model.entity.sistema.Sis_CompanyEmpresa;
import mierim.model.entity.sistema.Sis_CompanyFilial;
import mierim.model.entity.sistema.Sis_CompanyGroup;
import mierim.model.entity.sistema.Sis_Usuario;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "cad_profissional")
@Table(uniqueConstraints =
        { 
            @UniqueConstraint(columnNames = {"sigla", "deletado"}, name = "profissionalsigla_uk"),
            @UniqueConstraint(columnNames = {"id_usuario", "deletado"}, name = "profissionalusuario_uk")
                }
)
public class Profissional implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 120)
    private String nome;
    @Column(length = 120)
    private String nome_social;
    @Column(length = 10)
    private String sigla;

    @Column(length = 10)
    private String apelido;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_nascimento;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_admissao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_demissao;

    @Column(length = 1)
    private String tipo;

    @Column(length = 1)
    private String sexo;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_municipio")
    private Municipio municipio;

    @Column(length = 30)
    private String id_uf;

    @Column(length = 60)
    private String id_pais;
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
    @ManyToOne
    @JoinColumn(name = "id_escritorio")
    private Escritorio escritorio;
    @ManyToOne
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;

    @ManyToOne
    @JoinColumn(name = "id_centro_custo")
    private Centrocusto centrocusto;

    @Column(length = 100)
    private String endereco;

    @Column(length = 80)
    private String bairro;

    @Column(length = 10)
    private String cep;

    @Column(length = 10)
    private String numero;

    @Column(length = 60)
    private String complemento;

    @Column(length = 11)
    private String cpf;

    @Column(length = 11)
    private String rg;

    @Column(length = 12)
    private String carteira_trabalho;

    @Column(length = 15)
    private String pis;

    @Column(length = 1)
    private String juiz ;

    @Column(length = 120)
    private String email;

    @Column(length = 15)
    private String telefone;

    @Column(length = 15)
    private String celular;

    @Column(length = 1)
    private String status;

    @Column(length = 1)
    private String part_distribuicao;

    @Column(length = 1)
    private String revisor_faturamento;

    @Column(length = 1)
    private String altera_caso_encerrado;
    @Column(length = 1)
    private String inclui_pos_corte;
    @Column(length = 1)
    private String altera_pos_corte;
    @Column(length = 1)
    private String excluir_pos_corte;
    @Column(length = 1)
    private String altera_lanc_prefatura;
    @Column(length = 1)
    private String socio;
    @Column(length = 1)
    private String participa_rateio_despesa;
    @Column(length = 1)
    private String tecnico;

    @Column(length = 4)
    private String tempo_disponivel;

    @Column(length = 1)
    private String deletado ;
    @ManyToOne
    @JoinColumn(name = "id_cargo")
    private Cargo cargo;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tenant")
    private Sis_CompanyGroup sis_group;


    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tenant_company")
    private Sis_CompanyEmpresa sis_empresa;


    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tenant_filial")
    private Sis_CompanyFilial sis_filial;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario_inclusão")
    private Sis_Usuario sis_usuario_inclusao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_inclusao ;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario_alteracao")
    private Sis_Usuario sis_usuario_alteracao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_alteracao = new Date();

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario")
    private Sis_Usuario sis_usuario;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Profissional other = (Profissional) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
