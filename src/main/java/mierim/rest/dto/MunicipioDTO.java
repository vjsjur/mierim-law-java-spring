package mierim.rest.dto;

import javax.persistence.Id;

public class MunicipioDTO {

    public Integer id;
    public String cod_mun;
    public String cod_mun_comp;
    public String nome_mun;

    public MunicipioDTO(Integer id, String cod_mun, String cod_mun_comp, String nome_mun) {
        this.id = id;
        this.cod_mun = cod_mun;
        this.cod_mun_comp = cod_mun_comp;
        this.nome_mun = nome_mun;
    }
    @Override
    public String toString() {
        return "Municipio{" +
                "id "+":" + id +
                ", cod_mun "+":" + cod_mun +
                ", cod_mun_comp "+":" + cod_mun_comp +
                ", nome_mun "+":" + nome_mun +
                '}';
    }
}
