package mierim.model.entity;

/**
 *
 * @author Administrator
 */
import java.io.Serializable;

public class UsuarioFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private String rg;
	private String cpf;
	
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
