package mierim.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import mierim.model.entity.autocontida.Municipio;
import mierim.model.entity.faturamento.Categoria;
import mierim.model.entity.faturamento.Escritorio;
import mierim.model.entity.faturamento.Profissional;
import mierim.model.entity.financeiro.Centrocusto;
import mierim.model.entity.rhumanos.Cargo;
import mierim.model.entity.rhumanos.Departamento;
import mierim.model.entity.sistema.Sis_CompanyEmpresa;
import mierim.model.entity.sistema.Sis_CompanyFilial;
import mierim.model.entity.sistema.Sis_CompanyGroup;
import mierim.model.entity.sistema.Sis_Usuario;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ProfissionalDTO {

    protected Long id;
    protected String nome;
    protected String nome_social;
    protected String sigla;
    protected String apelido;
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected Date data_nascimento;
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected Date data_admissao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected Date data_demissao;
    protected String tipo;
    protected String sexo;
    protected Long id_municipio = 0L;
    protected Municipio municipio;
    protected String id_uf;
    protected String id_pais;
    protected Long id_categoria;
    protected Escritorio escritorio;
    protected Long id_escritorio;
    protected Departamento departamento;
    protected Long id_departamento;
    protected Centrocusto centrocusto;
    protected Long id_centrocusto;
    protected String endereco;
    protected String bairro;
    protected String cep;
    protected String numero;
    protected String complemento;
    protected String cpf;
    protected String rg;
    protected String carteira_trabalho;
    protected String pis;
    protected String juiz;
    protected String email;
    protected String telefone;
    protected String celular;
    protected String status;
    protected String part_distribuicao;
    protected String revisor_faturamento;
    protected String altera_caso_encerrado;
    protected String inclui_pos_corte;
    protected String altera_pos_corte;
    protected String excluir_pos_corte;
    protected String altera_lanc_prefatura;
    protected String socio;
    protected String participa_rateio_despesa;
    protected String tecnico;
    protected String tempo_disponivel;
    protected String deletado;

    protected Cargo cargo;
    protected Long id_cargo;
    protected Sis_CompanyGroup sis_group;
    protected Long id_tenant;
    protected Sis_CompanyEmpresa sis_empresa;
    protected Long id_tenant_empresa;
    protected Sis_CompanyFilial sis_filial;
    protected Long id_tenant_filial;
    protected Sis_Usuario sis_usuario_inclusao;
    protected Long id_usuario_inclusao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected Date data_inclusao;
    protected Sis_Usuario sis_usuario_alteracao;
    protected Long id_usuario_alteracao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected Date data_alteracao = new Date();
    protected Sis_Usuario sis_usuario;
    protected Long id_usuario;

    public ProfissionalDTO() {

    }


    public ProfissionalDTO(Profissional obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.nome_social = obj.getNome_social();
        this.sigla = obj.getSigla();
        this.apelido = obj.getApelido();
        this.data_nascimento = obj.getData_nascimento();
        this.data_admissao = obj.getData_admissao();
        this.data_demissao = obj.getData_demissao();
        this.tipo = obj.getTipo();
        this.sexo = obj.getSexo();
        if (obj.getMunicipio() != null) {
            this.id_municipio = obj.getMunicipio().getId();
            this.id_uf = obj.getMunicipio().getCod_uf();
            this.id_pais = obj.getMunicipio().getNome_pais();
        }
        if (obj.getCategoria() != null) {
            this.id_categoria = obj.getCategoria().getId();
        }
        if (obj.getEscritorio() != null) {
            this.id_escritorio = obj.getEscritorio().getId();
        }
        if (obj.getDepartamento() != null) {
            this.id_departamento = obj.getDepartamento().getId();
        }
        if (obj.getCentrocusto() != null) {
            this.id_centrocusto = obj.getCentrocusto().getId();
        }
        this.endereco = obj.getEndereco();
        this.bairro = obj.getBairro();
        this.cep = obj.getCep();
        this.numero = obj.getNumero();
        this.complemento = obj.getComplemento();
        this.cpf = obj.getCpf();
        this.rg = obj.getRg();
        this.carteira_trabalho = obj.getCarteira_trabalho();
        this.pis = obj.getPis();
        this.juiz = obj.getJuiz();
        this.email = obj.getEmail();
        this.telefone = obj.getTelefone();
        this.celular = obj.getCelular();
        this.status = obj.getStatus();
        this.part_distribuicao = obj.getPart_distribuicao();
        this.revisor_faturamento = obj.getRevisor_faturamento();
        this.altera_caso_encerrado = obj.getAltera_caso_encerrado();
        this.inclui_pos_corte = obj.getInclui_pos_corte();
        this.altera_pos_corte = obj.getAltera_pos_corte();
        this.excluir_pos_corte = obj.getExcluir_pos_corte();
        this.altera_lanc_prefatura = obj.getAltera_lanc_prefatura();
        this.socio = obj.getSocio();
        this.participa_rateio_despesa = obj.getParticipa_rateio_despesa();
        this.tecnico = obj.getTecnico();
        this.tempo_disponivel = obj.getTempo_disponivel();
        this.deletado = obj.getDeletado();
        if (obj.getCargo() != null) {
            this.id_cargo = obj.getCargo().getId();
        }
        if (obj.getSis_group() != null) {
            this.id_tenant = obj.getSis_group().getId_tenant();
        }
        if (obj.getSis_empresa() != null) {
            this.id_tenant_empresa = obj.getSis_empresa().getId_tenant_company();
        }
        if (obj.getSis_filial() != null) {
            this.id_tenant_filial = obj.getSis_filial().getId_tenant_filial();
        }
        if (obj.getSis_usuario_inclusao() != null) {
            this.id_usuario_inclusao = obj.getSis_usuario_inclusao().getId();
        }
        this.data_inclusao = obj.getData_inclusao();
        if (obj.getSis_usuario_alteracao() != null) {
            this.id_usuario_alteracao = obj.getSis_usuario_alteracao().getId();
        }
        this.data_alteracao = obj.getData_alteracao();
        if (obj.getSis_usuario() != null) {
            this.id_usuario = obj.getSis_usuario().getId();
        }
    }
}
