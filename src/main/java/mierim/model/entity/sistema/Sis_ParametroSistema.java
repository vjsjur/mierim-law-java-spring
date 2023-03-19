package mierim.model.entity.sistema;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "sis_parametro_sistema")
public class Sis_ParametroSistema implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 10, unique = true)
    @NotEmpty(message = "PREENCHA O CÓDIGO!")
    private String codigo;

    @Column(length = 150)
    @NotEmpty(message = "PREENCHA A DESCRIÇÃO!")
    private String descricao;
    @Column(length = 255)
    @NotEmpty(message = "PREENCHA A FUNÇÃ0!")
    private String exemplo;
    @Column(length = 100)
    @NotEmpty(message = "PREENCHA O MODULO!")
    private String modulo;
    @Column(length = 15)
    @NotEmpty(message = "PREENCHA O CONTEÚDO!")
    private String valor;
    private String deletado = "2";
    private String status = "1";

    @NotNull(message = "Preencha o Grupo Econômico!")
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tenant")
    private Sis_CompanyGroup sis_company_group;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sis_ParametroSistema other = (Sis_ParametroSistema) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
