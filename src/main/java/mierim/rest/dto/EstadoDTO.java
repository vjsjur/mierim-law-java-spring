package mierim.rest.dto;

public class EstadoDTO {

    public String cod_uf;
    public String sigla_uf;
    public String nome_Uf;

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
