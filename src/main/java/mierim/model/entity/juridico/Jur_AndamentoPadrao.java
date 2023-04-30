package mierim.model.entity.juridico;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mierim.model.entity.sistema.Sis_CompanyEmpresa;
import mierim.model.entity.sistema.Sis_CompanyFilial;
import mierim.model.entity.sistema.Sis_CompanyGroup;
import mierim.model.entity.sistema.Sis_Usuario;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "jur_andamento_padrao")

public class Jur_AndamentoPadrao implements Serializable {


    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private String descricao_padrao;
    private String Status = "1";
    private String deletado = "2";


    @ManyToOne
    @JoinColumn(name = "id_usuario_inclusao")
    @JsonBackReference
    private Sis_Usuario sis_usuario_inclusao;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_inclusao;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_usuario_alteracao")
    private Sis_Usuario sis_usuario_alteracao;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_alteracao = new Date();


    @ManyToOne
    @JoinColumn(name = "id_tenant")
    private Sis_CompanyGroup sis_group;


    @ManyToOne
    @JoinColumn(name = "id_tenant_company")
    private Sis_CompanyEmpresa sis_empresa;


    @ManyToOne
    @JoinColumn(name = "id_tenant_filial")
    private Sis_CompanyFilial sis_filial;


}
