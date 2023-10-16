package br.com.igorlimagroup.azure.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.igorlimagroup.azure.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
	
}
