package mierim.model.entity.faturamento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Office {
    
    private Integer Id;
    private String Codigo;
    private String Nome;
    private String Razao;
    private String Emite_Fat;
    private String Separa_Prod;
    private String CNPJ;
    private String DDD;
    private String Telefone;
    private String Email;
    private String Pais;
    private String UF;    
    private String Estado;
    private String Municipio;
    private String Cep;
    private String Bairro;
    private String Endereco;
    private String Numero;
    private String Complemento;
    private String NFe;
    private String NFSe;
    private String NFi;
    private String Ativo;

}
