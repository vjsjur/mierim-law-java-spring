package mierim.rest.dto;

public class MunicipioDTO {
    public String cod_mun;
    public String cod_mun_comp;
    public String nome_mun;

    public MunicipioDTO(String cod_mun, String cod_mun_comp, String nome_mun) {
        this.cod_mun = cod_mun;
        this.cod_mun_comp = cod_mun_comp;
        this.nome_mun = nome_mun;
    }
    @Override
    public String toString() {
        return "Municipio{" +
                "cod_mun "+":" + cod_mun +
                ", cod_mun_comp "+":" + cod_mun_comp +
                ", nome_mun "+":" + nome_mun +
                '}';
    }
}
