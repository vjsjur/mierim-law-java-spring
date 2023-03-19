package mierim.model.entity.faturamento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mierim.model.entity.juridico.Area;
import mierim.model.entity.juridico.SubArea;
import mierim.model.entity.sistema.Sis_CompanyEmpresa;
import mierim.model.entity.sistema.Sis_CompanyFilial;
import mierim.model.entity.sistema.Sis_CompanyGroup;
import mierim.model.entity.sistema.Sis_Usuario;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "cad_caso")
public class Caso implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(6) ZEROFILL")
    private Long id;
    private String codigo;

    @NotEmpty(message = "Prenncha")
    private String titulo;

    @Temporal(TemporalType.DATE)
    private Date data_cadastro = new Date();

    @Temporal(TemporalType.DATE)
    private Date data_encerramento;
    private String cobravel;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    private String cliente_codigo;
    private String cliente_loja_codigo;

    @ManyToOne
    @JoinColumn(name = "id_profissional_revisor")
    private Profissional profRev;
    private String revisor_nome;

    @ManyToOne
    @JoinColumn(name = "id_profissional_socio")
    private Profissional profSoc;
    private String socio_nome;
    private String status;
    private String deletado = "2";
    private String encerra_timesheet;
    private String encerra_despesa;
    private String encerra_tabelado;
    private String cobra_timesheet;
    private String cobra_despesa;
    private String cobra_tabelado;
    private String tipo_execao;

    @ManyToOne
    @JoinColumn(name = "id_grupo_cliente")
    private Grupocliente grupo_cliente;
    private double valor_excecao;

    @ManyToOne
    @JoinColumn(name = "id_tabela_honorario")
    private TabelaHonorario tabelaHonorario;

    @ManyToOne
    @JoinColumn(name = "id_area_juridica")
    private Area areaJuridica;
    private String area_juridica_descricao;

    @ManyToOne
    @JoinColumn(name = "id_subarea_juridica")
    private SubArea subAreaJuridica;
    private String subarea_juridica_descricao;

    @ManyToOne
    @JoinColumn(name = "id_lancamento_tabelado_tabela")
    private LancamentoTabeladoTabela lancamentoTabeladoTabela;

    @ManyToOne
    @JoinColumn(name = "id_idioma")
    private Idioma idioma;
    private String idioma_descricao;

    @ManyToOne
    @JoinColumn(name = "id_escritorio")
    private Escritorio escritorio;
    private String escritorio_codigo;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_inclusao;

    @NotNull(message = "Preencha o Usuário de Aleração")
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario_alteracao")
    private Sis_Usuario sis_usuario_alteracao;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_alteracao = new Date();

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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Caso other = (Caso) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
