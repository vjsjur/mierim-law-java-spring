package mierim.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.UniqueConstraint;

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
    private UsuarioProfessor usuario;
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
    private String part_distrinuicao;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome_social() {
        return nome_social;
    }

    public void setNome_social(String nome_social) {
        this.nome_social = nome_social;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public Date getData_admissao() {
        return data_admissao;
    }

    public void setData_admissao(Date data_admissao) {
        this.data_admissao = data_admissao;
    }

    public Date getData_demissao() {
        return data_demissao;
    }

    public void setData_demissao(Date data_demissao) {
        this.data_demissao = data_demissao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

   

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Centrocusto getCentrocusto() {
        return centrocusto;
    }

    public void setCentrocusto(Centrocusto centrocusto) {
        this.centrocusto = centrocusto;
    }

    public Escritorio getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(Escritorio escritorio) {
        this.escritorio = escritorio;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public UsuarioProfessor getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioProfessor usuario) {
        this.usuario = usuario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCarteira_trabalho() {
        return carteira_trabalho;
    }

    public void setCarteira_trabalho(String carteira_trabalho) {
        this.carteira_trabalho = carteira_trabalho;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getPart_distrinuicao() {
        return part_distrinuicao;
    }

    public void setPart_distrinuicao(String part_distrinuicao) {
        this.part_distrinuicao = part_distrinuicao;
    }

    public String getRevisor_faturamento() {
        return revisor_faturamento;
    }

    public void setRevisor_faturamento(String revisor_faturamento) {
        this.revisor_faturamento = revisor_faturamento;
    }

    public String getAltera_caso_encerrado() {
        return altera_caso_encerrado;
    }

    public void setAltera_caso_encerrado(String altera_caso_encerrado) {
        this.altera_caso_encerrado = altera_caso_encerrado;
    }

    public String getInclui_pos_corte() {
        return inclui_pos_corte;
    }

    public void setInclui_pos_corte(String inclui_pos_corte) {
        this.inclui_pos_corte = inclui_pos_corte;
    }

    public String getAltera_pos_corte() {
        return altera_pos_corte;
    }

    public void setAltera_pos_corte(String altera_pos_corte) {
        this.altera_pos_corte = altera_pos_corte;
    }

    public String getExcluir_pos_corte() {
        return excluir_pos_corte;
    }

    public void setExcluir_pos_corte(String excluir_pos_corte) {
        this.excluir_pos_corte = excluir_pos_corte;
    }

    public String getAltera_lanc_prefatura() {
        return altera_lanc_prefatura;
    }

    public void setAltera_lanc_prefatura(String altera_lanc_prefatura) {
        this.altera_lanc_prefatura = altera_lanc_prefatura;
    }

    public String getSocio() {
        return socio;
    }

    public void setSocio(String socio) {
        this.socio = socio;
    }

    public String getParticipa_rateio_despesa() {
        return participa_rateio_despesa;
    }

    public void setParticipa_rateio_despesa(String participa_rateio_despesa) {
        this.participa_rateio_despesa = participa_rateio_despesa;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public String getTempo_disponivel() {
        return tempo_disponivel;
    }

    public void setTempo_disponivel(String tempo_disponivel) {
        this.tempo_disponivel = tempo_disponivel;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeletado() {
        return deletado;
    }

    public void setDeletado(String deletado) {
        this.deletado = deletado;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }


    public String getJuiz() {
        return juiz;
    }

    public void setJuiz(String juiz) {
        this.juiz = juiz;
    }

    public UnidadeFederativa getId_estado() {
        return id_estado;
    }

    public void setId_estado(UnidadeFederativa id_estado) {
        this.id_estado = id_estado;
    }

    public Pais getId_pais() {
        return id_pais;
    }

    public void setId_pais(Pais id_pais) {
        this.id_pais = id_pais;
    }
    
    

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
