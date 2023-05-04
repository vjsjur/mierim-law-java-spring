package mierim.rest.dto.juridico;

import mierim.model.entity.juridico.Jur_Ato;
import mierim.model.entity.juridico.Jur_Fase;
import mierim.model.entity.sistema.Sis_CompanyEmpresa;
import mierim.model.entity.sistema.Sis_CompanyFilial;
import mierim.model.entity.sistema.Sis_CompanyGroup;
import mierim.model.entity.sistema.Sis_Usuario;

import java.io.Serializable;
import java.util.Date;

public class Jur_AtoDTO  implements Serializable {
    private static final long serialVersionUID = 1L;

    protected Long id;
    protected String descricao;
    protected String texto_padrao;
    protected Jur_Fase jur_fase;
    protected String status = "A";
    protected String deletado = "N";
    protected Sis_Usuario sis_usuario_inclusao;
    protected Date data_inclusao = new Date();
    protected Sis_Usuario sis_usuario_alteracao;
    protected Date data_alteracao = new Date();
    protected Sis_CompanyGroup sis_group;
    protected Sis_CompanyEmpresa sis_empresa;
    protected Sis_CompanyFilial sis_filial;

    public Jur_AtoDTO(){
        super();
    }

    public Jur_AtoDTO(Jur_Ato obj){

        this.id = obj.getId();
        this.descricao  = obj.getDescricao();
        this.texto_padrao  = obj.getTexto_padrao();
        this.jur_fase  = obj.getJur_fase();
        this.status   = obj.getStatus();
        this.deletado   = obj.getDeletado();
        this.sis_usuario_inclusao   = obj.getSis_usuario_inclusao();
        this.data_inclusao   = obj.getData_inclusao();
        this.sis_usuario_alteracao  = obj.getSis_usuario_alteracao();
        this.data_alteracao   = obj.getData_alteracao();
        this.sis_group   = obj.getSis_group();
        this.sis_empresa   = obj.getSis_empresa();
        this.sis_filial   = obj.getSis_filial();
    }

}
