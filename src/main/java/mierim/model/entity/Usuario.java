package mierim.model.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Transient;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Transactional
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario implements Serializable, UserDetails {

    private Integer id;
    private String nome;
    private String email;
    private String email_bkp;
    private String login;
    private String senha;
    private boolean ativo;
    private Integer nivel_visao_campo;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotEmpty(message = "IMPORME O LOGIN!")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getNivel_visao_campo() {
        return nivel_visao_campo;
    }

    public void setNivel_visao_campo(Integer nivel_visao_campo) {
        this.nivel_visao_campo = nivel_visao_campo;
    }

    public String getEmail_bkp() {
        return email_bkp;
    }

    public void setEmail_bkp(String email_bkp) {
        this.email_bkp = email_bkp;
    } 
    

    @NotEmpty(message = "IMPORME A SENHA!")
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    @Transient
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authority = new HashSet<GrantedAuthority>();
        authority.add(new SimpleGrantedAuthority("ROLE_USER"));
        return authority;

    }

    @Override
    @Transient
    public String getPassword() {
        return senha;
    }

    @Override
    @Transient
    public String getUsername() {
        return login;
    }

    @Override
    @Transient
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @Transient
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @Transient
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @Transient
    public boolean isEnabled() {
        return ativo;
    }

    @NotEmpty(message = "IMPORME O NOME!")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

   
    @NotEmpty(message = "IMPORME O EMAIL!")
    @Email(message = "INFORME UM EMAIL VÁLIDO")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
