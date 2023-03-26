package mierim.model.entity.juridico;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mierim.model.entity.sistema.Sis_CompanyEmpresa;
import mierim.model.entity.sistema.Sis_CompanyFilial;
import mierim.model.entity.sistema.Sis_CompanyGroup;
import mierim.model.entity.sistema.Sis_Usuario;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "jur_processo")
public class Jur_Processo implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  ID;

    private String  id_areajuridica;
    private String  id_subareajuridica;
    private String  id_escritorio;
    private String  id_caso;
    private String id_cliente;
    private String id_contrato;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date  data_entrada;
    private String  id_natureza;
    private String  id_tipoacao;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date  data_distribuicao;
    private String  id_vara;
    private String  id_correspondente;
    private String  houve_decisao;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date  data_decisao;
    private String  id_decisao;
    private String  id_juiz;
    @Column(nullable=false, length=1)
    private String  situacao;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date  data_encerramento;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date  data_cancelamento;
    private String  id_objeto;


    private String  detalhamento_objeto;
    private String  id_rito;
    private String  id_forma_correcao;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date  data_atualizacao;
    private String  observacao_atualizacao;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date  data_vcausa;
    private String  id_moeda_vcausa;
    private String  valor_causa;
    private String  valor_causa_atualizado;
    private String  valor_causa_juros;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date  data_venvolvido;
    private String  id_moeda_venvolvido;
    private String  valor_envolvido;
    private String  valor_envolvido_atualizado;
    private String  valor_envolvido_juros;
    private String  venvolvido_inestimavel;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date  data_vfinal;
    private String  id_moeda_vfinal;
    private String  valor_final;
    private String  id_motivoencerramento;
    private String  detalhamento_encerramento;
    private String  numero_inquerito;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date  data_fatos;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date  data_denuncia;
    private String  nome_consulta;
    private String  codigo;
    private String  id_prognostico;
    private String  numero_processo;
    private String  numero_antigo;
    private String  abre_caso_automaticamente;
    private String  extradata;
    private String  id_tipoassunto;
    private String  origem_alteracao;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date  data_reabertura;
    private String  motivo_reabertura;
    private String  detalhamento_decisao;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date  data_juros;
    private String  import_andamentos;
    private String  digital;
    private String  import_observacoes;
    private String  observacoes;
    private String  instancia;
    private String  id_tipocontrato;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date  data_lancamento;
    private String  vigencia_inicio;
    private String  vigencia_termino;
    private String  numero_registro;
    private String  identificador;
    private String  contrato_regular;
    private String  renovacao_automatica;
    private String  importado;
    private String  validar_cnj;
    private String  id_comarca;
    private String  id_foro;
    private String  pasta;
    private String  import_situacao;
    private String  tipo;
    private String  id_profissional;
    private String  id_envolvido_ativo;
    private String  id_envolvido_passivo;
    private String  responsaveis;
    private String  numeros_processo;
    private String  id_ultimo_andamento;
    private String  tribunal_url;
    private String  log_encerramento;
    private String  erro_encerramento;
    private String  id_fase_prioridade;


    @NotNull(message = "Preencha o Usuário de Aleração")
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario_inclusao")
    private Sis_Usuario sis_usuario_inclusao;


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

}
