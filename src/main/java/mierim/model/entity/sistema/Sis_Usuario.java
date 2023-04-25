package mierim.model.entity.sistema;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mierim.model.entity.faturamento.Profissional;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "sis_usuario")
public class Sis_Usuario implements Serializable {

    private static final long serialVersionUID = 0L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "usuario", length = 50)
    private String usuario;

    @Column(name = "senha", length = 50)
    private String senha;
    @Column(name = "usuario_ad", length = 30)
    private String usuario_ad;
    @Column(name = "celular", length = 11)
    private String celular;
    private Integer tentativas;

    @Column(name = "ativo", length = 1)
    private String ativo;
    @Column(name = "bloqueado", length = 1)
    private String bloqueado;
    @Column(name = "e_mail", length = 150)
    private String e_mail;
    @Column(name = "palavra_passe", length = 50)
    private String palavra_passe;
    private Integer nivel_visao_campo;

    @NotNull(message = "Preencha o Grupo Econômico!")
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tenant")
    private Sis_CompanyGroup sis_company_group;

    @NotNull(message = "Preencha a Empresa!")
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tenant_company")
    private Sis_CompanyEmpresa sis_empresa;

    @NotNull(message = "Preencha a Filial!")
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tenant_filial")
    private Sis_CompanyFilial sis_filial;


    /////////////////////////////////////////////////////////////////////////////
    /////////////////////////Retorno dos relacionamentos/////////////////////////
    /////////////////////////////////////////////////////////////////////////////

    @JsonIgnore
    @OneToMany(mappedBy = "sis_usuario_inclusao")
    private List<Profissional> profissional_inclusao;

    @JsonIgnore
    @OneToMany(mappedBy = "sis_usuario_alteracao")
    private List<Profissional> profissional_alteracao;

    @JsonIgnore
    @OneToMany(mappedBy = "sis_usuario")
    private List<Profissional> profissional;
}
