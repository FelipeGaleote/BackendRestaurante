package com.sancarest.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sancarest.restaurante.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,String>{
	

	@Query("SELECT u FROM Usuario u WHERE u.nomeUsuario = ?1 AND u.senha = ?2")
	Usuario findByNomeUsuarioAndSenha(String nomeUsario, String senha);

}
