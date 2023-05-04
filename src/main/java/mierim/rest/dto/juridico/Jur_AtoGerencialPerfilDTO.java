package mierim.rest.dto.juridico;

import mierim.model.entity.juridico.Jur_AtoGerencial;
import mierim.model.entity.juridico.Jur_AtoGerencialPerfil;
import mierim.model.entity.sistema.*;


import java.io.Serializable;
import java.util.Date;

public class Jur_AtoGerencialPerfilDTO   implements Serializable {
    private static final long serialVersionUID = 1L;

    protected Long id;
    protected String descricao;
    protected Jur_AtoGerencial jur_atogerencial;
    protected Sis_Perfil Sis_perfil;
    protected String status = "A";
    protected String deletado = "N";
    protected String juridico ;
    protected String origem;
    protected Sis_Usuario sis_usuario_inclusao;
    protected Date data_inclusao = new Date();
    protected Sis_Usuario sis_usuario_alteracao;
    protected Date data_alteracao = new Date();
    protected Sis_CompanyGroup sis_group;
    protected Sis_CompanyEmpresa sis_empresa;
    protected Sis_CompanyFilial sis_filial;

    public Jur_AtoGerencialPerfilDTO(){
        super();
    }

    public Jur_AtoGerencialPerfilDTO(Jur_AtoGerencialPerfil obj){
        this.id = obj.getId();
        this.descricao  = obj.getDescricao();
        this.jur_atogerencial  = obj.getJur_atogerencial();
        this.Sis_perfil = obj.getSis_perfil();
        this.status = obj.getStatus();
        this.deletado = obj.getDeletado();
        this.juridico = obj.getJuridico();
        this.origem = obj.getOrigem();
        this.sis_usuario_inclusao = obj.getSis_usuario_inclusao();
        this.data_inclusao = obj.getData_inclusao();
        this.sis_usuario_alteracao = obj.getSis_usuario_alteracao();
        this.data_alteracao  = obj.getData_alteracao();
        this.sis_group = obj.getSis_group();
        this.sis_empresa = obj.getSis_empresa();
        this.sis_filial = obj.getSis_filial();

    }

}
