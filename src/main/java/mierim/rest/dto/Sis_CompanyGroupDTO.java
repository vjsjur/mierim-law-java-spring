package mierim.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import mierim.model.entity.sistema.Sis_CompanyGroup;


import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
public class Sis_CompanyGroupDTO implements Serializable {
    private static final long serialVersionUID = 0L;

    protected Long id_tenant;
    protected String nome;
    protected String grupo_economico;
    protected String dominio;
    protected String deletado;
    protected String status;
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected Date data_inclusao = new Date();
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected Date data_alteracao = new Date();

    public Sis_CompanyGroupDTO(){

    }

    public Sis_CompanyGroupDTO(Sis_CompanyGroup obj){
        this.id_tenant = obj.getId_tenant();
        this.nome = obj.getNome();
        this.grupo_economico = obj.getGrupo_economico();
        this.dominio = obj.getDominio();
        this.deletado = obj.getDeletado();
        this.status = obj.getStatus();
        this.data_inclusao = obj.getData_inclusao();
        this.data_alteracao = obj.getData_inclusao();
    }

    public Long getId_tenant() {
        return id_tenant;
    }

    public void setId_tenant(Long id_tenant) {
        this.id_tenant = id_tenant;
    }

    public String getNome() {
        return nome;
    }

    public String getGrupo_economico() {
        return grupo_economico;
    }

    public void setGrupo_economico(String grupo_economico) {
        this.grupo_economico = grupo_economico;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
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
