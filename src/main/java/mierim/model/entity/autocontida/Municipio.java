package mierim.model.entity.autocontida;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "cad_municipio")
public class Municipio implements Serializable {

    @Id
    private Integer id;
    private Integer id_rec_status;
    private String cod_uf;
    private String sigla_uf;
    private String nome_uf;
    private String cod_mesor_geog;
    private String nome_mesor;
    private String cod_micror_geog;
    private String nome_micror;
    private String cod_mun;
    private String cod_mun_comp;
    private String nome_mun;
    private String cod_pais;
    private String sigla_pais;
    private String nome_pais;
}
