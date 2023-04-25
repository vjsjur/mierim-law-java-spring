package mierim.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import mierim.model.entity.autocontida.Municipio;
import mierim.model.entity.sistema.Sis_CompanyEmpresa;


import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
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
    protected Long id_municipio;
    protected String id_municipio_nome = "";
    protected Long id_tenant;
    protected String id_tenant_nome;

    public Sis_CompanyEmpresaDTO() {

    }

    public Sis_CompanyEmpresaDTO(Sis_CompanyEmpresa obj) {
        this.id_tenant_company = obj.getId_tenant_company();
        this.cpf_cnpj = obj.getCpf_cnpj();
        this.nome_emp = obj.getNome_emp();
        this.nome_fant = obj.getNome_fant();
        this.logradouro = obj.getLogradouro();
        this.numero = obj.getNumero();
        this.complemento = obj.getComplemento();
        this.cep = obj.getCep();
        this.bairro = obj.getBairro();
        this.id_uf = obj.getId_uf();
        this.id_pais = obj.getId_pais();
        this.email = obj.getEmail();
        this.telefone = obj.getTelefone();
        this.deletado = obj.getDeletado();
        this.status = obj.getStatus();
        this.data_inclusao = obj.getData_inclusao();
        this.data_alteracao = obj.getData_alteracao();
        if (obj.getMunicipio() != null) {
            this.id_municipio = obj.getMunicipio().getId();
            this.id_municipio_nome = obj.getMunicipio().getNome_mun();
        }
        if (obj.getSis_company_group() != null) {
            this.id_tenant = obj.getSis_company_group().getId_tenant();
            this.id_tenant_nome = obj.getSis_company_group().getNome();
        }
    }

    public Long getId_tenant_company() {
        return id_tenant_company;
    }

}
