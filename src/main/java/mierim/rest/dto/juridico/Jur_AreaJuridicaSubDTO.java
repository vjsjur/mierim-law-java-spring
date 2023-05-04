package mierim.rest.dto.juridico;

import com.fasterxml.jackson.annotation.JsonFormat;
import mierim.model.entity.juridico.Jur_AreaJuridica;
import mierim.model.entity.juridico.Jur_AreaJuridicaSub;
import mierim.model.entity.sistema.Sis_CompanyEmpresa;
import mierim.model.entity.sistema.Sis_CompanyFilial;
import mierim.model.entity.sistema.Sis_CompanyGroup;
import mierim.model.entity.sistema.Sis_Usuario;


import java.io.Serializable;
import java.util.Date;

public class Jur_AreaJuridicaSubDTO  implements Serializable {
    private static final long serialVersionUID = 1L;

    protected Long id;
    protected String codigo;
    protected String descricao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected Date dt_cadastro = new Date();
    protected Jur_AreaJuridica jurAreaJuridica;
    protected String status = "A";
    protected String tecnico = "S";
    protected String deletado = "N";
    protected Sis_Usuario sis_usuario_inclusao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected Date data_inclusao = new Date();
    protected Sis_Usuario sis_usuario_alteracao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected Date data_alteracao = new Date();
    protected Sis_CompanyGroup sis_group;
    protected Sis_CompanyEmpresa sis_empresa;
    protected Sis_CompanyFilial sis_filial;

    public Jur_AreaJuridicaSubDTO(){
        super();
    }

    public Jur_AreaJuridicaSubDTO(Jur_AreaJuridicaSub obj){

        this.id = obj.getId();
        this.codigo  = obj.getCodigo();
        this.descricao  = obj.getDescricao();
        this.dt_cadastro = obj.getDt_cadastro();
        this.jurAreaJuridica  = obj.getJurAreaJuridica();
        this.status = obj.getStatus();
        this.tecnico  = obj.getTecnico();
        this.deletado  = obj.getDeletado();
        this.sis_usuario_inclusao  = obj.getSis_usuario_inclusao();
        this.data_inclusao  = obj.getData_inclusao();
        this.sis_usuario_alteracao  = obj.getSis_usuario_alteracao();
        this.data_alteracao  = obj.getData_alteracao();
        this.sis_group  = obj.getSis_group();
        this.sis_empresa  = obj.getSis_empresa();
        this.sis_filial  = obj.getSis_filial();
    }

}
