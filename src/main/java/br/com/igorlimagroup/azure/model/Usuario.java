package br.com.igorlimagroup.azure.model;

import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

	@Id
	@GeneratedValue(generator = "UUID")
	private UUID idUsuario;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String sobrenome;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String localidade;
	private String uf;
	
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Usuario usuario = (Usuario) o;
		return Objects.equals(idUsuario, usuario.idUsuario) &&
				Objects.equals(nome, usuario.nome) &&
				Objects.equals(sobrenome, usuario.sobrenome) &&
				Objects.equals(email, usuario.email) &&
				Objects.equals(cep, usuario.cep) &&
				Objects.equals(logradouro, usuario.logradouro) &&
				Objects.equals(complemento, usuario.complemento) &&
				Objects.equals(bairro, usuario.bairro) &&
				Objects.equals(localidade, usuario.localidade) &&
				Objects.equals(uf, usuario.uf);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idUsuario, nome, sobrenome, email, cep, logradouro, complemento, bairro, localidade, uf);
	}

	@Override
	public String toString() {
		return "Usuario{" +
				"idUsuario=" + idUsuario +
				", nome='" + nome + '\'' +
				", sobrenome='" + sobrenome + '\'' +
				", email='" + email + '\'' +
				", cep='" + cep + '\'' +
				", logradouro='" + logradouro + '\'' +
				", complemento='" + complemento + '\'' +
				", bairro='" + bairro + '\'' +
				", localidade='" + localidade + '\'' +
				", uf='" + uf + '\'' +
				'}';
	}
}