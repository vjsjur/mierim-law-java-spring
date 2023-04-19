package mierim.rest.dto;

public class EstadoDTO {

    private String cod_uf;
    private String sigla_uf;
    private String nome_Uf;

    public EstadoDTO(String cod_uf, String sigla_uf, String nome_Uf) {
        this.cod_uf = cod_uf;
        this.sigla_uf = sigla_uf;
        this.nome_Uf = nome_Uf;
    }
    @Override
    public String toString() {
        return "Estado{" +
                "cod_uf "+":" + cod_uf +
                ", sigla_uf "+":" + sigla_uf +
                ", nome_Uf "+":" + nome_Uf +
                '}';
    }

}
