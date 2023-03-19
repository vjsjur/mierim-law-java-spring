package mierim.model.entity.juridico;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "jur_processo")
public class Jur_Processo implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String  ID;

    private String  id_areajuridica;
    private String  id_subareajuridica;
    private String  id_escritorio;
    private String  id_caso;
    private String  data_entrada;
    private String  id_natureza;
    private String  id_tipoacao;
    private String  data_distribuicao;
    private String  id_vara;
    private String  id_correspondente;
    private String  houve_decisao;

    @Column(nullable=false, length=1)
    private String  data_decisao;
    private String  id_decisao;
    private String  id_juiz;
    @Column(nullable=false, length=1)
    private String  situacao;
    private String  data_encerramento;
    private String  data_cancelamento;
    private String  id_objeto;


    private String  detalhamento_objeto;
    private String  id_rito;
    private String  id_forma_correcao;
    private String  data_atualizacao;
    private String  observacao_atualizacao;
    private String  data_vcausa;
    private String  id_moeda_vcausa;
    private String  valor_causa;
    private String  valor_causa_atualizado;
    private String  valor_causa_juros;
    private String  data_venvolvido;
    private String  id_moeda_venvolvido;
    private String  valor_envolvido;
    private String  valor_envolvido_atualizado;
    private String  valor_envolvido_juros;
    private String  venvolvido_inestimavel;
    private String  data_vfinal;
    private String  id_moeda_vfinal;
    private String  valor_final;
    private String  id_motivoencerramento;
    private String  detalhamento_encerramento;
    private String  numero_inquerito;
    private String  data_fatos;
    private String  data_denuncia;
    private String  nome_consulta;
    private String  data_inclusao;
    private String  usuario_inclusao;
    private String  data_alteracao;
    private String  usuario_alteracao;
    private String  codigo;
    private String  id_prognostico;
    private String  numero_processo;
    private String  numero_antigo;
    private String  abre_caso_automaticamente;
    private String  extradata;
    private String  id_tipoassunto;
    private String  origem_alteracao;
    private String  data_reabertura;
    private String  motivo_reabertura;
    private String  detalhamento_decisao;
    private String  data_juros;
    private String  import_andamentos;
    private String  digital;
    private String  import_observacoes;
    private String  observacoes;
    private String  instancia;
    private String  id_tipocontrato;
    private String  data_lancamento;
    private String  vigencia_inicio;
    private String  vigencia_termino;
    private String  numero_registro;
    private String  identificador;
    private String  contrato_regular;
    private String  renovacao_automatica;
    private String  importado;
    private String  validar_cnj;
    private String  id_cidade;
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
}
