package mierim.rest.dto;

public class PaisDTO {
    private String cod_pais;
    private String sigla_pais;
    private String nome_pais;

    public PaisDTO(String cod_pais, String sigla_pais, String nome_pais) {
        this.cod_pais = cod_pais;
        this.sigla_pais = sigla_pais;
        this.nome_pais = nome_pais;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "cod_pais "+":" + cod_pais +
                ", sigla_pais "+":" + sigla_pais +
                ", nome_pais "+":" + nome_pais +
                '}';
    }
}
