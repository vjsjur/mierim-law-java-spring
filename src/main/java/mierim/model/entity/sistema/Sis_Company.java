package mierim.model.entity.sistema;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "sis_company")
public class Sis_Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tenant;
    @Column(nullable=false)
    private Integer cpf_cnpj;
    @Column(nullable=false, length=120)
    private String nome_emp;
    @Column(nullable=false, length=120)
    private String nome_fant;
    @Column(nullable=false, length=120)
    private String logradouro;
    @Column(nullable=false, length=15)
    private String numero;
    @Column(nullable=false, length=60)
    private String complemento;
    @Column(nullable=false, length=10)
    private String cep;
    @Column(nullable=false, length=60)
    private String bairro;
    private String municipio;
    private String uf;

    @Column(nullable=false, length=120)
    private String email;
    @Column(nullable=false, length=15)
    private String telefone;


}
