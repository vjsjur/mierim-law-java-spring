package mierim.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "cad_area_juridica")
public class Area implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "locado", length = 1)
    private Integer locado = 2;
    private String filtro;

    @NotEmpty(message = "PREENCHA O CÓDIGO!")
    @Column(name = "codigo", length = 10)
    private String codigo;

    @NotEmpty(message = "PREENCHA A DESCRIÇÃO!")
    @Column(name = "descricao", length = 80)
    private String descricao;

    @NotEmpty(message = "PREENCHA O TÉCNICO")
    @Column(name = "tecnico", length = 1)
    private String tecnico;

    @NotEmpty(message = "PREENCHA O STATUS!")
    @Column(name = "status", length = 1)
    private String status;

    @OneToMany
    @JoinColumn(name = "id_area")
    private List<SubArea> subarea;

    @Column(name = "deletado", length = 1)
    private String deletado = "2";

    
}
