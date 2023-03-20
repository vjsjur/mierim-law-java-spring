package mierim.model.entity.faturamento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mierim.model.entity.autocontida.UnidadeFederativa;
import mierim.model.entity.sistema.Sis_CompanyEmpresa;
import mierim.model.entity.sistema.Sis_CompanyFilial;
import mierim.model.entity.sistema.Sis_CompanyGroup;
import mierim.model.entity.sistema.Sis_UsuarioComplemento;
import mierim.model.entity.autocontida.Municipio;
import mierim.model.entity.autocontida.Pais;
import mierim.model.entity.financeiro.Centrocusto;
import mierim.model.entity.rhumanos.Cargo;
import mierim.model.entity.rhumanos.Departamento;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
    private String nome;
    private String nome_social;
    private String sigla;
    private String apelido;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_nascimento;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_admissao;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_demissao;
    private String tipo;
    private String sexo;
    @ManyToOne
    @JoinColumn(name = "id_municipio")
    private Municipio municipio;
    @ManyToOne
    @JoinColumn(name = "id_estado")
    private UnidadeFederativa id_estado;
    @ManyToOne
    @JoinColumn(name = "id_pais")
    private Pais id_pais;
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
    @JoinColumn(name = "id_usuario")
    private Sis_UsuarioComplemento usuario;
    @ManyToOne
    @JoinColumn(name = "id_centro_custo")
    private Centrocusto centrocusto;
    private String endereco;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cpf;
    private String rg;
    private String carteira_trabalho;
    private String pis;
    private String juiz = "2";
    private String email;
    private String telefone;
    private String celular;
    private String status;
    private String part_distribuicao;
    private String revisor_faturamento;
    private String altera_caso_encerrado;
    private String inclui_pos_corte;
    private String altera_pos_corte;
    private String excluir_pos_corte;
    private String altera_lanc_prefatura;
    private String socio;
    private String participa_rateio_despesa;
    private String tecnico;
    private String tempo_disponivel;
    private String deletado = "2";
    @ManyToOne
    @JoinColumn(name = "id_cargo")
    private Cargo cargo;



    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tenant")
    private Sis_CompanyGroup sis_company_group;


    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tenant_company")
    private Sis_CompanyEmpresa sis_empresa;


    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tenant_filial")
    private Sis_CompanyFilial sis_filial;




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
