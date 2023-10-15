package com.gcpTest.gcp.database.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;

@Entity(name = "usuario")
public class Usuario implements Serializable {

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer idUsuario;

   private String nome;

   private String sobrenome;

   private String email;

   public Integer getIdUsuario() {
       return idUsuario;
   }

   public void setIdUsuario(Integer idUsuario) {
       this.idUsuario = idUsuario;
   }

   public String getNome() {
       return nome;
   }

   public void setNome(String nome) {
       this.nome = nome;
   }

   public String getSobrenome() {
       return sobrenome;
   }

   public void setSobrenome(String sobrenome) {
       this.sobrenome = sobrenome;
   }

   public String getEmail() {
       return email;
   }

   public void setEmail(String email) {
       this.email = email;
   }

   @Override
   public boolean equals(Object o) {
       if (this == o) return true;
       if (o == null || getClass() != o.getClass()) return false;
       Usuario usuario = (Usuario) o;
       return Objects.equals(idUsuario, usuario.idUsuario) &&
               Objects.equals(nome, usuario.nome) &&
               Objects.equals(sobrenome, usuario.sobrenome) &&
               Objects.equals(email, usuario.email);
   }

   @Override
   public int hashCode() {
       return Objects.hash(idUsuario, nome, sobrenome, email);
   }

   @Override
   public String toString() {
       return "Usuario{" +
               "idUsuario=" + idUsuario +
               ", nome='" + nome + '\'' +
               ", sobrenome='" + sobrenome + '\'' +
               ", email='" + email + '\'' +
               '}';
   }
}