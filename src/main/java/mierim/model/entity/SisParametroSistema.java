package mierim.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "sis_parametro_sistema")
public class SisParametroSistema implements Serializable {

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
        final SisParametroSistema other = (SisParametroSistema) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}