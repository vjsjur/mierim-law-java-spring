package mierim.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BuscaCep {

    @SerializedName("cep")
    @Expose
    private String cep;
    @SerializedName("logradouro")
    @Expose
    private String logradouro;
    @SerializedName("complemento")
    @Expose
    private String complemento;
    @SerializedName("bairro")
    @Expose
    private String bairro;
    @SerializedName("localidade")
    @Expose
    private String localidade;
    @SerializedName("uf")
    @Expose
    private String uf;
    @SerializedName("unidade")
    @Expose
    private String unidade;
    @SerializedName("ibge")
    @Expose
    private String ibge;
    @SerializedName("gia")
    @Expose
    private String gia;
    private String numero;

    @Override
    public String toString() {
    return new ToStringBuilder(this).append("cep", cep).append("logradouro", logradouro).append("complemento", complemento).append("bairro", bairro).append("localidade", localidade).append("uf", uf).append("unidade", unidade).append("ibge", ibge).append("gia", gia).toString();
    }

    @Override
    public int hashCode() {
    return new HashCodeBuilder().append(gia).append(bairro).append(complemento).append(cep).append(ibge).append(uf).append(localidade).append(logradouro).append(unidade).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
    if (other == this) {
    return true;
    }
    if ((other instanceof BuscaCep) == false) {
    return false;
    }
    BuscaCep rhs = ((BuscaCep) other);
    return new EqualsBuilder().append(gia, rhs.gia).append(bairro, rhs.bairro).append(complemento, rhs.complemento).append(cep, rhs.cep).append(ibge, rhs.ibge).append(uf, rhs.uf).append(localidade, rhs.localidade).append(logradouro, rhs.logradouro).append(unidade, rhs.unidade).isEquals();
    }

}
