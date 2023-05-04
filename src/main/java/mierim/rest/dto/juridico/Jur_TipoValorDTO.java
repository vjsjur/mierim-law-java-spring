package mierim.rest.dto.juridico;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import mierim.model.entity.juridico.Jur_TipoValor;
import mierim.model.entity.sistema.Sis_CompanyEmpresa;
import mierim.model.entity.sistema.Sis_CompanyFilial;
import mierim.model.entity.sistema.Sis_CompanyGroup;
import mierim.model.entity.sistema.Sis_Usuario;


import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Jur_TipoValorDTO implements Serializable {
    private static final long serialVersionUID = 0L;

    protected Long id;
    protected String descricao;
    protected String descricao_padrao;
    protected String Status = "A";
    protected String deletado = "N";
    protected Sis_Usuario sis_usuario_inclusao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected Date data_inclusao  = new Date();;
    protected Sis_Usuario sis_usuario_alteracao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected Date data_alteracao = new Date();
    protected Sis_CompanyGroup sis_company_group;
    protected Sis_CompanyEmpresa sis_empresa;
    protected Sis_CompanyFilial sis_filial;

    public Jur_TipoValorDTO() {
        super();
    }

    public Jur_TipoValorDTO(Jur_TipoValor obj) {
        this.id = obj.getId();
        this.descricao = obj.getDescricao();
        this.descricao_padrao = obj.getDescricao_padrao();
        this.Status = obj.getStatus();
        this.deletado = obj.getDeletado();
        this.sis_usuario_inclusao = obj.getSis_usuario_inclusao();
        this.data_inclusao  = obj.getData_inclusao();
        this.sis_usuario_alteracao = obj.getSis_usuario_alteracao();
        this.data_alteracao = obj.getData_alteracao();
        this.sis_company_group = obj.getSis_company_group();
        this.sis_empresa = obj.getSis_empresa();
        this.sis_filial = obj.getSis_filial();
    }
}
