package mierim.model.entity.juridico;


import mierim.model.entity.faturamento.Cliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "jur_correspondente")
public class Jur_Correspondente implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_correspondente")
    private Cliente id_correspondente;
    private String cnpj_cpf;
    private String status = "1";
    private String deletado = "2";

}
