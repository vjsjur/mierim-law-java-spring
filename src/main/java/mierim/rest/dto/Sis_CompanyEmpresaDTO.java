package mierim.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import mierim.model.entity.autocontida.Municipio;
import mierim.model.entity.sistema.Sis_CompanyEmpresa;



import java.io.Serializable;
import java.util.Date;


@AllArgsConstructor
public class Sis_CompanyEmpresaDTO implements Serializable {

    private static final long serialVersionUID = 0L;

    protected Long id_tenant_company;
    protected Long cpf_cnpj;
    protected String nome_emp;
    protected String nome_fant;
    protected String logradouro;
    protected String numero;
    protected String complemento;
    protected String cep;
    protected String bairro;
    protected String id_uf;
    protected String id_pais;
    protected String email;
    protected String telefone;
    protected String deletado;
    protected String status;
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected Date data_inclusao = new Date();
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected Date data_alteracao = new Date();
    protected Integer id_municipio;
    protected String id_municipio_nome;
    protected Long id_tenant ;
    protected String id_tenant_nome;

    public Sis_CompanyEmpresaDTO (){

    }

    public Sis_CompanyEmpresaDTO (Sis_CompanyEmpresa obj){
        this.id_tenant_company = obj.getId_tenant_company();
        this.cpf_cnpj = obj.getCpf_cnpj();
        this.nome_emp = obj.getNome_emp();
        this.nome_fant = obj.getNome_fant();
        this.logradouro = obj.getLogradouro();
        this.numero =  obj.getNumero();
        this.complemento = obj.getComplemento();
        this.cep = obj.getCep();
        this.bairro = obj.getBairro();
        this.id_uf = obj.getId_uf();
        this.id_pais = obj.getId_pais();
        this.email = obj.getEmail();
        this.telefone = obj.getTelefone();
        this.deletado =  obj.getDeletado();
        this.status = obj.getStatus();
        this.data_inclusao = obj.getData_inclusao();
        this.data_alteracao = obj.getData_alteracao();
        this.id_municipio = obj.getMunicipio().getId();
        this.id_municipio_nome = obj.getMunicipio().getNome_mun();
        this.id_tenant = obj.getSis_company_group().getId_tenant();
        this.id_tenant_nome = obj.getSis_company_group().getNome();
    }

    public Long getId_tenant_company() {
        return id_tenant_company;
    }

    public void setId_tenant_company(Long id_tenant_company) {
        this.id_tenant_company = id_tenant_company;
    }

    public Integer getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(Integer id_municipio) {
        this.id_municipio = id_municipio;
    }

    public String getId_municipio_nome() {
        return id_municipio_nome;
    }

    public void setId_municipio_nome(String id_municipio_nome) {
        this.id_municipio_nome = id_municipio_nome;
    }

    public Long getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(Long cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome_emp() {
        return nome_emp;
    }

    public void setNome_emp(String nome_emp) {
        this.nome_emp = nome_emp;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Long getId_tenant() {
        return id_tenant;
    }

    public void setId_tenant(Long id_tenant) {
        this.id_tenant = id_tenant;
    }

    public String getId_tenant_nome() {
        return id_tenant_nome;
    }

    public void setId_tenant_nome(String id_tenant_nome) {
        this.id_tenant_nome = id_tenant_nome;
    }

    public String getNome_fant() {
        return nome_fant;
    }

    public void setNome_fant(String nome_fant) {
        this.nome_fant = nome_fant;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
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

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getId_uf() {
        return id_uf;
    }

    public void setId_uf(String id_uf) {
        this.id_uf = id_uf;
    }

    public String getId_pais() {
        return id_pais;
    }

    public void setId_pais(String id_pais) {
        this.id_pais = id_pais;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDeletado() {
        return deletado;
    }

    public void setDeletado(String deletado) {
        this.deletado = deletado;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getData_inclusao() {
        return data_inclusao;
    }

    public void setData_inclusao(Date data_inclusao) {
        this.data_inclusao = data_inclusao;
    }

    public Date getData_alteracao() {
        return data_alteracao;
    }

    public void setData_alteracao(Date data_alteracao) {
        this.data_alteracao = data_alteracao;
    }
}
