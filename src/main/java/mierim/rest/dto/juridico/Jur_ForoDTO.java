package mierim.rest.dto.juridico;

import mierim.model.entity.juridico.Jur_Comarca;
import mierim.model.entity.juridico.Jur_Foro;
import mierim.model.entity.sistema.Sis_CompanyEmpresa;
import mierim.model.entity.sistema.Sis_CompanyFilial;
import mierim.model.entity.sistema.Sis_CompanyGroup;
import mierim.model.entity.sistema.Sis_Usuario;

import java.io.Serializable;
import java.util.Date;

public class Jur_ForoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    protected Long  id;
    protected Jur_Comarca comarca;
    protected String  descricao;
    protected String  instancia;
    protected String  endereco;
    protected String  status;
    protected String  codigo;
    protected String  deletado;
    protected String  chave_cnj;
    protected String  sigla;
    protected Sis_Usuario sis_usuario_inclusao;
    protected Date data_inclusao;
    protected Sis_Usuario sis_usuario_alteracao;
    protected Date data_alteracao = new Date();
    protected Sis_CompanyGroup sis_company_group;
    protected Sis_CompanyEmpresa sis_empresa;
    protected Sis_CompanyFilial sis_filial;

    public Jur_ForoDTO(){
        super();
    }


    public Jur_ForoDTO(Jur_Foro obj){
        this.id = obj.getId();
        this.comarca = obj.getComarca();
        this.descricao = obj.getDescricao();
        this.instancia = obj.getInstancia();
        this.endereco = obj.getEndereco();
        this.status = obj.getStatus();
        this.codigo  = obj.getCodigo();
        this.deletado = obj.getDeletado();
        this.chave_cnj  = obj.getChave_cnj();
        this.sigla  = obj.getSigla();
        this.sis_usuario_inclusao  = obj.getSis_usuario_inclusao();
        this.data_inclusao  = obj.getData_inclusao();
        this.sis_usuario_alteracao  = obj.getSis_usuario_alteracao();
        this.data_alteracao = obj.getData_alteracao();
        this.sis_company_group = obj.getSis_company_group();
        this.sis_empresa = obj.getSis_empresa();
        this.sis_filial = obj.getSis_filial();
    }
}
