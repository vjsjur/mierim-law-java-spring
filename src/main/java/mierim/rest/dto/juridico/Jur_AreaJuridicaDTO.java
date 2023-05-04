package mierim.rest.dto.juridico;

import com.fasterxml.jackson.annotation.JsonFormat;
import mierim.model.entity.juridico.Jur_AreaJuridica;
import mierim.model.entity.sistema.Sis_CompanyEmpresa;
import mierim.model.entity.sistema.Sis_CompanyFilial;
import mierim.model.entity.sistema.Sis_CompanyGroup;
import mierim.model.entity.sistema.Sis_Usuario;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Jur_AreaJuridicaDTO implements Serializable {
    private static final long serialVersionUID = 0L;

    protected  Integer id;
    protected  String codigo;
    protected  String descricao;
    protected  String tecnico = "S";
    protected  String status = "A";
    protected  String deletado = "N";
    protected  Sis_Usuario sis_usuario_inclusao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected  Date data_inclusao = new Date();
    protected  Sis_Usuario sis_usuario_alteracao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected  Date data_alteracao = new Date();
    protected  Sis_CompanyGroup sis_group;
    protected  Sis_CompanyEmpresa sis_empresa;
    protected  Sis_CompanyFilial sis_filial;

    public Jur_AreaJuridicaDTO(){
        super();
    }

    public Jur_AreaJuridicaDTO(Jur_AreaJuridica obj){
        this.id = obj.getId();
        this.codigo = obj.getCodigo();
        this.descricao = obj.getDescricao();
        this.tecnico = obj.getTecnico();
        this.status = obj.getStatus();
        this.deletado = obj.getDeletado();
        this.sis_usuario_inclusao = obj.getSis_usuario_inclusao();
        this.data_inclusao = obj.getData_inclusao();
        this.sis_usuario_alteracao = obj.getSis_usuario_alteracao();
        this.data_alteracao = obj.getData_alteracao();
        this.sis_group = obj.getSis_group();
        this.sis_empresa = obj.getSis_empresa();
        this.sis_filial = obj.getSis_filial();

    }

}
