package mierim.model.entity.sistema;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String nome;
    private String email;

    @ManyToOne
    @JoinColumn(name = "departament_id")
    private Departament departament;

}
