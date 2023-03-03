package mierim.model.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public enum Estado {

    ACRE("Acre","AC", 1),
    ALAGOAS("Alagoas","AL", 2),
    AMAPA("Amapá","AP", 3),
    AMAZONAS("Amazonas", "AM", 4),
    BAHIA("Bahia","BA", 5),
    CEARA("Ceará","CE", 6),
    DISTRITO_FEDERAL("Distrito Federal","DF", 7),
    ESPIRITO_SANTO("Espírito Santo","ES", 8),
    GOIAS("Goiás","GO", 9),
    MARANHAO("Maranhão","MA", 10),
    MATO_GROSSO("Mato Grosso","MT", 11),
    MATO_GROSSO_DO_SUL("Mato Grosso do Sul","MS", 12),
    MINAS_GERAIS("Minas Gerais","MG", 13),
    PARA("Pará","PA", 14),
    PARAIBA("Paraíba","PB", 15),
    PARANA("Paraná","PR", 16),
    PERNANBUCO("Pernambuco","PE", 17),
    PIAUI("Piauí","PI", 18),
    RORAIMA("Roraima","RR", 19),
    RONDONIA("Rondônia","RO", 20),
    RIO_DE_JANEIRO("Rio de Janeiro","RJ", 21),
    RIO_GRANDE_DO_NORTE("Rio Grande do Norte","RN", 22),
    RIO_GRANDE_DO_SUL("Rio Grande do Sul","RS", 23),
    SANTA_CATARINA("Santa Catarina","SC", 25),
    SAO_PAULO("São Paulo","SP", 26),
    SERGIPE("Sergipe","SE", 27),
    TOCANTINS("Tocantins","TO", 28);

    private String label;
    private String sigla;
    private Integer codigo;

}
